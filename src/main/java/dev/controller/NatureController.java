package dev.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import dev.domain.Mission;
import dev.domain.Nature;
import dev.repository.MissionRepo;
import dev.repository.NatureRepo;

@RestController
@RequestMapping(value = "/natures")
public class NatureController {

	@Autowired
	NatureRepo natureRepo;

	@Autowired
	MissionRepo missionRepo;

	/** GET : all */
	@GetMapping
	public List<Nature> natures() {
		List<Nature> natures = natureRepo.findAll();
		return natures;
	}
	
	/** DELETE : suppression d'une nature **/
	
	@DeleteMapping
	@RequestMapping(value="/delete")
	@CrossOrigin
	public ResponseEntity<String> suppresionNature(@RequestParam("id") Integer id) {
		List<Mission> missions = missionRepo.findAll();
		Optional<Nature> nature = natureRepo.findById(id);
		
		for (Mission mission : missions) {
			if (mission.getNature() == nature.get()) {
				return ResponseEntity.status(200).body("\"La nature est déjà utilisée, impossible de la supprimer\"");
			}
		}
		
		if (nature.isPresent()) {
			natureRepo.delete(nature.get());
			return  ResponseEntity.status(200).body("\"La supression a bien été enregistrée\"");
		}
		return ResponseEntity.status(400).body("\"La nature est introuvable\"");
	}

	/** POST : ajout d'une nature **/
	
	@PostMapping
	@RequestMapping(value="/ajout")
	public ResponseEntity<Object> creationNature(@RequestBody Nature nature) {
		nature.setDate_debut(LocalDate.now());
		natureRepo.save(nature);
		return ResponseEntity.status(200).body(nature);
	}

	/** PATCH : mis à jour d'une nature de mission **/
	@PatchMapping
	@RequestMapping(value = "/modification")
	@CrossOrigin
	public ResponseEntity<Object> updateClient(@RequestBody Nature newNature) {
		Optional<Nature> natureOptionnal = natureRepo.findById(newNature.getId());
		Nature currentNature = natureOptionnal.get();
		List<Mission> missions = new ArrayList<>();
		missions = missionRepo.findAll();
		boolean natureUtilise = false;
		for (Mission mission : missions) {
			if (mission.getNature() == currentNature) {
				natureUtilise = true;
			}
		}

		if (natureUtilise == true) {
			Nature tempNature = new Nature();

			tempNature.setNom(newNature.getNom());
			tempNature.setPrime(newNature.isPrime());
			tempNature.setFacturation(newNature.isFacturation());
			tempNature.setTjm(newNature.getTjm());
			tempNature.setPourcentage(newNature.getPourcentage());
			tempNature.setPlafond(newNature.getPlafond());
			tempNature.setPlafond_depassable(newNature.isPlafond_depassable());
			tempNature.setDate_debut(LocalDate.now());

			LocalDate newEndDate = LocalDate.now();
			newEndDate = newEndDate.minusDays(1);
			currentNature.setDate_fin(newEndDate);
			natureRepo.save(tempNature);
			natureRepo.save(currentNature);
		} else {
			newNature.setDate_debut(currentNature.getDate_debut());
			natureRepo.delete(currentNature);
			natureRepo.save(newNature);
		}

		return ResponseEntity.status(200).body(newNature);
	}

	/** GET : all valides par date */
	@GetMapping
	@RequestMapping(value = "/valides")
	public List<Nature> naturesValides() {
		List<Nature> natures = natureRepo.findAll();
		List<Nature> resultat = new ArrayList<>();
		LocalDate date = LocalDate.now();
		for (Nature nature : natures) {
			if (nature.getDate_debut().compareTo(date) <= 0 && nature.getDate_fin() == null)
				resultat.add(nature);
			else if (nature.getDate_debut().compareTo(date) <= 0 && nature.getDate_fin().compareTo(date) >= 0) {
				resultat.add(nature);
			}
		}
		return resultat;
	}

}
