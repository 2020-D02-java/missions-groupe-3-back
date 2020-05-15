package dev.controller;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.domain.Mission;
import dev.domain.Nature;
import dev.domain.NoteDeFrais;
import dev.repository.MissionRepo;
import dev.repository.NoteDeFraisRepo;

import dto.PrimeDto;

/**
 * @author Salaheddine El Majdoub
 *
 */
@RestController
@RequestMapping("/prime")
public class PrimeController {
	

	private NoteDeFraisRepo noteDeFraisRepo;
	private MissionRepo missionRepo;
	
	
	/**Constructeur
	 * @param noteDeFraisRepo
	 * @param missionRepo
	 */
	public PrimeController(NoteDeFraisRepo noteDeFraisRepo,MissionRepo missionRepo) {

		this.noteDeFraisRepo = noteDeFraisRepo;
		this.missionRepo = missionRepo;
		}
	
	// Methode retourne une liste de prime (ou un seul) qui correspond à la note de frais d'une mission donnée
	
	@GetMapping("{UUID}")
	  public List<PrimeDto> getPrime(@PathVariable String UUID) {
		  List<NoteDeFrais> notesFrais =  this.noteDeFraisRepo.findAll();
		  List<Mission> missions = this.missionRepo.findAll();
		  int idNote = Integer.parseInt(UUID.replace("UUID=", ""));
		  int idMission = -1;
		  for (NoteDeFrais note : notesFrais)
		  {
			  if(note.getId() == idNote)
				  idMission = note.getMission().getId();
		  }
		  
		  List<PrimeDto> resultat = new ArrayList();
		  for (Mission mission : missions)
			  if (mission.getId() == idMission)
				  
				  resultat.add(new PrimeDto(mission.getPrime().getId(), mission.getPrime().getDate(),mission.getPrime().getMontant()));
		  
		  return resultat;
	  }

}





















