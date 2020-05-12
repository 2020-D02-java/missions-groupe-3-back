package dev.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

	/** PATCH :  mis à jour d'une nature de mission **/

	@PatchMapping
	@RequestMapping(value="/modification")
	@CrossOrigin
	public ResponseEntity<Object> updateClient(@RequestBody Nature newNature){
		Nature currentNature = natureRepo.findById(newNature.getId());

		currentNature.setNom(newNature.getNom());
		currentNature.setPrime(newNature.isPrime());
		currentNature.setFacturation(newNature.isFacturation());
		currentNature.setTjm(newNature.getTjm());
		currentNature.setPourcentage(newNature.getPourcentage());
		currentNature.setPlafond(newNature.getPlafond());
		currentNature.setPlafond_depassable(newNature.isPlafond_depassable());

		LocalDate newEndDate = LocalDate.now();
		newEndDate = newEndDate.minusDays(1);
		currentNature.setDate_fin(newEndDate);	


		/**		Si la nature n'est pas utilisée:
			On écrase la nature courante sans altérer sa date de début de validité.
		 **/
		List<Mission> missions = new ArrayList<>();
		missions = missionRepo.findAll();
		boolean natureUtilise = false;  
		for (Mission mission : missions) {
			
			if (mission.getNature() == currentNature ) {	
				natureUtilise = true;	
			}
		}

		if (natureUtilise == true ) {
			natureRepo.save(newNature);
		} else {
			newNature.setDate_debut(currentNature.getDate_debut());
			natureRepo.delete(currentNature);
			natureRepo.save(newNature);

		}

		return ResponseEntity.status(200).body(newNature);
	}
}
