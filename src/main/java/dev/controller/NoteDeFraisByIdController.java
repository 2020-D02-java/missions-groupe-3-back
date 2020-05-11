package dev.controller;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.domain.LigneDeFrais;
import dev.domain.Nature;
import dev.domain.NoteDeFrais;
import dev.repository.NatureRepo;
import dev.repository.NoteDeFraisRepo;
import dto.NotesDeFraisDto;

@RestController
@RequestMapping("/note")
public class NoteDeFraisByIdController {

	private NoteDeFraisRepo noteDeFraisRepo;

	public NoteDeFraisByIdController(NoteDeFraisRepo noteDeFraisRepo) {
		this.noteDeFraisRepo = noteDeFraisRepo;

	}

	@GetMapping("{UUID}")

	  public List<NotesDeFraisDto> gestionNotesDeFrais(@PathVariable String UUID) {
		  List<NoteDeFrais> notesFrais =  this.noteDeFraisRepo.findAll();
		  List<NotesDeFraisDto> resultat = new ArrayList<>();
		  
		  for (NoteDeFrais note : notesFrais ) {
			  if (note.getId() == Integer.parseInt(UUID.replace("UUID=", "")))
				  resultat.add(new NotesDeFraisDto(note.getId()+"",note.getMission().getId(),note.getMission().getDate_debut(), note.getMission().getDate_fin(), 
						  note.getMission().getNature().getNom(), note.getMission().getVille_depart(), 
						  note.getMission().getVille_arrive(), note.getMission().getTransport(), 
						  note.getPrix()));
		  }
		  
		  return resultat;
	  }

}
