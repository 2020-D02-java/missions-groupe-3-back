package dev.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.domain.NoteDeFrais;
import dev.repository.NoteDeFraisRepo;
import dto.NotesDeFraisDto;

@RestController
@RequestMapping("/note")
public class GestionFraisController {
	
	private NoteDeFraisRepo noteDeFraisRepo;
	
	public GestionFraisController(NoteDeFraisRepo noteDeFraisRepo) {
		this.noteDeFraisRepo = noteDeFraisRepo;
		}
	
	  @GetMapping
	  public List<NotesDeFraisDto> gestionNotesDeFrais() {
		  List<NoteDeFrais> notesFrais =  this.noteDeFraisRepo.findAll();
		  List<NotesDeFraisDto> resultat = new ArrayList<>();
		  for (NoteDeFrais note : notesFrais ) {
			  resultat.add(new NotesDeFraisDto(note.getMission().getDate_debut(), note.getMission().getDate_fin(), 
					  note.getMission().getNature().getNom(), note.getMission().getVille_depart(), 
					  note.getMission().getVille_arrive(),   note.getMission().getTransport(), 
					  note.getPrix()));
		  }
		  return resultat;
	  }
	 
}
