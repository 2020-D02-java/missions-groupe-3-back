package dev.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.vm.NotesDeFraisVM;
import dev.domain.NoteDeFrais;
import dev.repository.NoteDeFraisRepo;

@RestController
@RequestMapping("/note")
public class GestionFraisController {
	
	private NoteDeFraisRepo noteDeFraisRepo;
	
	public GestionFraisController(NoteDeFraisRepo noteDeFraisRepo) {
		this.noteDeFraisRepo = noteDeFraisRepo;
		}
	
	  @GetMapping
	  public List<NotesDeFraisVM> gestionNotesDeFrais() {
		  List<NoteDeFrais> notesFrais =  this.noteDeFraisRepo.findAll();
		  List<NotesDeFraisVM> resultat = new ArrayList<>();
		  for (NoteDeFrais note : notesFrais ) {
			  resultat.add(new NotesDeFraisVM(note.getMission().getDate_debut(), note.getMission().getDate_fin(), 
					  note.getMission().getNature().getNom(), note.getMission().getVille_depart(), 
					  note.getMission().getVille_arrive(),   note.getMission().getTransport(), 
					  note.getPrix()));
		  }
		  return resultat;
	  }
	 
}
