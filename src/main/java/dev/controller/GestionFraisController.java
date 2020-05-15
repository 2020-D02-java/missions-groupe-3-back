package dev.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.domain.LigneDeFrais;
import dev.domain.NoteDeFrais;
import dev.repository.LigneDeFraisRepo;
import dev.repository.NoteDeFraisRepo;
import dto.NotesDeFraisDto;

@RestController
@RequestMapping("/note")
public class GestionFraisController {
	
	private NoteDeFraisRepo noteDeFraisRepo;
	private LigneDeFraisRepo ligneFraisRepo;

	
	public GestionFraisController(NoteDeFraisRepo noteDeFraisRepo, LigneDeFraisRepo ligneFraiRepo) {
		this.noteDeFraisRepo = noteDeFraisRepo;
		this.ligneFraisRepo = ligneFraiRepo;
		}
	
	  @GetMapping
	  public List<NotesDeFraisDto> gestionNotesDeFrais() {
		  
		  List<NoteDeFrais> notesFrais =  this.noteDeFraisRepo.findAll();
		  List<LigneDeFrais> ligneFrais = this.ligneFraisRepo.findAll();

		  List<NotesDeFraisDto> resultat = new ArrayList<>();
		  Integer sommeFrais = 0;
		  for (NoteDeFrais note : notesFrais ) {
			  for (LigneDeFrais ligne : ligneFrais)

			  {
				  if (note.getId() == ligne.getNote_de_frais().getId())
					  sommeFrais += ligne.getPrix();
			  }
			 
			  resultat.add(new NotesDeFraisDto(note.getId()+"",note.getMission().getId(),note.getMission().getDate_debut(), note.getMission().getDate_fin(), 
					  note.getMission().getNature().getNom(), note.getMission().getVille_depart(), 
					  note.getMission().getVille_arrive(), note.getMission().getTransport(), 
					  sommeFrais));
		  }
		 
		  return resultat;
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
