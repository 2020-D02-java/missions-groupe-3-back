package dev.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.domain.Mission;
import dev.domain.Nature;
import dev.repository.MissionRepo;
import dev.repository.NatureRepo;
import dto.MissionDto;
import dto.MissionDtoPost;

@RestController
@RequestMapping(value = "/missions")
public class MissionController {

	@Autowired
	MissionRepo missionRepo;

	@Autowired
	NatureRepo natureRepo;

	// GET : all
	@GetMapping
	public List<MissionDto> missions() {
		List<Mission> missions = missionRepo.findAll();
		List<MissionDto> missionsDto = new ArrayList<>();
		for (Mission mission : missions) {
			MissionDto missionDto;
			if (mission.getCollegue() != null) {
				missionDto = new MissionDto(mission.getId(), mission.getCollegue().getId(), mission.getNature(),
						mission.getPrime(), mission.isValidation(), mission.getDate_debut(), mission.getDate_fin(),
						mission.getVille_depart(), mission.getVille_arrive(), mission.getTransport(),
						mission.getStatut());
			} else {
				missionDto = new MissionDto(mission.getId(), -1, mission.getNature(), mission.getPrime(),
						mission.isValidation(), mission.getDate_debut(), mission.getDate_fin(),
						mission.getVille_depart(), mission.getVille_arrive(), mission.getTransport(),
						mission.getStatut());
			}
			missionsDto.add(missionDto);
		}
		return missionsDto;
	}

	// GET : missions?start=x&end=y
	// verifie si il n'y a pas d'autres missions sur le creneau
	@GetMapping
	@RequestMapping(value = "/disponibilite")
	public String missionDisponible(@RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate start,
			@RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
		List<Mission> missions = missionRepo.findAll();
		System.out.println(start.toString() + " " + end.toString());
		for (Mission mission : missions) {
			if (mission.getDate_debut().compareTo(start) < 0 && mission.getDate_fin().compareTo(end) > 0)
				return "false";
			if (mission.getDate_debut().compareTo(start) > 0 && mission.getDate_debut().compareTo(end) < 0)
				return "false";
			if (mission.getDate_fin().compareTo(start) > 0 && mission.getDate_fin().compareTo(end) < 0)
				return "false";
		}
		return "true";
	}

	/** POST : missions/ ------ creation d'une mission */
	@PostMapping
	@CrossOrigin
	public ResponseEntity<Object> creationMission(@RequestBody MissionDtoPost missionDto) {
		List<Nature> natures = natureRepo.findAll();
		Nature nature = null;
		Mission mission = new Mission();
		for (Nature element : natures) {
			if (missionDto.getNature().equals(element.getNom()))
				nature = element;
		}
		mission.setDate_debut(missionDto.getDate_debut());
		mission.setDate_fin(missionDto.getDate_fin());
		mission.setNature(nature);
		mission.setTransport(missionDto.getTransport());
		mission.setStatut("Initiale");
		mission.setVille_arrive(missionDto.getVille_arrivee());
		mission.setVille_depart(missionDto.getVille_depart());
		missionRepo.save(mission);
		return ResponseEntity.status(200).body(mission);
	}

}
