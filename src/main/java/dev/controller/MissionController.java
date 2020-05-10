package dev.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.domain.Collegue;
import dev.domain.Mission;
import dev.domain.Nature;
import dev.repository.CollegueRepo;
import dev.repository.MissionRepo;
import dev.repository.NatureRepo;
import dev.services.DtoToEntite;
import dto.MissionDto;
import dto.MissionDtoPost;

@RestController
@RequestMapping(value = "/missions")
public class MissionController {

	@Autowired
	MissionRepo missionRepo;

	@Autowired
	NatureRepo natureRepo;

	@Autowired
	CollegueRepo collegueRepo;

	/** GET : all */
	@GetMapping
	public List<MissionDto> missions() {
		List<Mission> missions = missionRepo.findAll();
		List<MissionDto> missionsDto = new ArrayList<>();
		for (Mission mission : missions) {
			MissionDto missionDto;
			if (mission.getCollegue() != null) {
				missionDto = new MissionDto(mission.getId(), mission.getCollegue().getId(),
						mission.getNature().getNom(), mission.getPrime(), mission.isValidation(),
						mission.getDate_debut(), mission.getDate_fin(), mission.getVille_depart(),
						mission.getVille_arrive(), mission.getTransport(), mission.getStatut());
			} else {
				missionDto = new MissionDto(mission.getId(), -1, mission.getNature().getNom(), mission.getPrime(),
						mission.isValidation(), mission.getDate_debut(), mission.getDate_fin(),
						mission.getVille_depart(), mission.getVille_arrive(), mission.getTransport(),
						mission.getStatut());
			}
			missionsDto.add(missionDto);
		}
		return missionsDto;
	}

	/**
	 * GET : missions/collegue?email=xxx@dev.fr recupere les missions d'un collegue
	 */
	@GetMapping
	@RequestMapping(value = "/collegue")
	public List<MissionDto> missionsCollegue(@RequestParam("email") String email) {
		Optional<Collegue> collegueOptional = collegueRepo.findByEmail(email);
		List<MissionDto> missionsDto = new ArrayList<>();
		if (collegueOptional.isPresent()) {
			Collegue collegue = collegueOptional.get();
			List<Mission> missions = missionRepo.findByCollegue(collegue);
			for (Mission mission : missions) {
				MissionDto missionDto;
				if (mission.getNature() != null) {
					missionDto = new MissionDto(mission.getId(), mission.getCollegue().getId(),
							mission.getNature().getNom(), mission.getPrime(), mission.isValidation(),
							mission.getDate_debut(), mission.getDate_fin(), mission.getVille_depart(),
							mission.getVille_arrive(), mission.getTransport(), mission.getStatut());
				} else {
					missionDto = new MissionDto(mission.getId(), mission.getCollegue().getId(), "", mission.getPrime(),
							mission.isValidation(), mission.getDate_debut(), mission.getDate_fin(),
							mission.getVille_depart(), mission.getVille_arrive(), mission.getTransport(),
							mission.getStatut());
				}
				missionsDto.add(missionDto);
			}
		}
		return missionsDto;
	}

	/***
	 * GET : missions?start=yyyy-MM-dd&end=yyyy-MM-dd&email=xxx@dev.fr verifie si il
	 * n'y a pas d'autres missions sur le creneau une exception est creee pour la
	 * verification de disponibilite pour la mise a jour d'une mission
	 */
	@GetMapping
	@RequestMapping(value = "/disponibilite")
	public String missionDisponible(@RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate start,
			@RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end,
			@RequestParam("email") String email, @RequestParam("exception") Integer exception) {
		Optional<Collegue> collegueOptional = collegueRepo.findByEmail(email);
		if (collegueOptional.isPresent()) {
			Collegue collegue = collegueOptional.get();
			List<Mission> missions = missionRepo.findByCollegue(collegue);
			for (Mission mission : missions) {
				if (mission.getId() != exception) {
					if (mission.getDate_debut() != null && mission.getDate_fin() != null) {
						if (mission.getDate_debut().compareTo(start) <= 0 && mission.getDate_fin().compareTo(end) >= 0)
							return "false";
						if (mission.getDate_debut().compareTo(start) >= 0
								&& mission.getDate_debut().compareTo(end) <= 0)
							return "false";
						if (mission.getDate_fin().compareTo(start) >= 0 && mission.getDate_fin().compareTo(end) <= 0)
							return "false";
					}
					if (mission.getDate_debut() != null && (mission.getDate_debut().compareTo(start) == 0
							|| mission.getDate_debut().compareTo(end) == 0))
						return "false";
					if (mission.getDate_fin() != null && (mission.getDate_fin().compareTo(start) == 0
							|| mission.getDate_fin().compareTo(end) == 0))
						return "false";
				}
			}
			return "true";
		} else {
			return "\"erreur:404\"";
		}
	}

	/** POST : missions/ ------ creation d'une mission */
	@PostMapping
	@CrossOrigin
	public ResponseEntity<Object> creationMission(@RequestBody MissionDtoPost missionDto) {
		Mission mission = new Mission();
		mission.setDate_debut(missionDto.getDate_debut());
		mission.setDate_fin(missionDto.getDate_fin());
		mission.setTransport(missionDto.getTransport());
		mission.setStatut("Initiale");
		mission.setVille_arrive(missionDto.getVille_arrivee());
		mission.setVille_depart(missionDto.getVille_depart());
		Optional<Collegue> collegueOptionnal = collegueRepo.findByEmail(missionDto.getCollegue_email());
		if (collegueOptionnal.isPresent()) {
			mission.setCollegue(collegueOptionnal.get());
		} else {
			return ResponseEntity.status(400).body("\"erreur:404collegueNonTrouve\"");
		}
		Optional<Nature> natureOptional = natureRepo.findByNom(missionDto.getNature());
		if (natureOptional.isPresent()) {
			mission.setNature(natureOptional.get());
		}
		missionRepo.save(mission);
		return ResponseEntity.status(200).body(missionDto);
	}

	/** Supprime une mission */
	@DeleteMapping
	@RequestMapping(value = "/delete")
	@CrossOrigin
	public String missionDisponible(@RequestParam("id") Integer id) {
		Optional<Mission> mission = missionRepo.findById(id);
		if (mission.isPresent()) {
			missionRepo.delete(mission.get());
			return "\"mission supprimee\"";
		} else {
			return "\"erreur:404\"";
		}
	}

	/** met a jour les donnees d'une mission */
	@PatchMapping
	@CrossOrigin
	public ResponseEntity<String> updateClient(@RequestBody MissionDto missionDto) {
		Optional<Mission> missionOptional = missionRepo.findById(missionDto.getId());
		if (missionOptional.isPresent()) {
			Mission mission = missionOptional.get();
			mission = DtoToEntite.dtoToMission(mission, missionDto);
			Optional<Nature> natureOptional = natureRepo.findByNom(missionDto.getNature());
			if (natureOptional.isPresent()) {
				mission.setNature(natureOptional.get());
			} else {
				return ResponseEntity.status(400)
						.body(new String("\"erreur:404 nature non trouvee : " + missionDto.getNature() + "\""));
			}
			missionRepo.save(mission);
			return ResponseEntity.status(200).body("\"Mission creee\"");
		} else {
			return ResponseEntity.status(400).body("\"Erreur:404 Mission non trouvee\"");
		}
	}

}
