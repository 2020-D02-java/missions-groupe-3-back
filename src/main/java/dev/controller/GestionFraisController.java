package dev.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.domain.Collegue;
import dev.domain.LigneDeFrais;
import dev.domain.Mission;
import dev.domain.Nature;
import dev.domain.NoteDeFrais;
import exception.UuidIntrouvableException;
import dev.repository.LigneDeFraisRepo;
import dev.repository.NoteDeFraisRepo;
import dev.services.DtoToEntite;
import dev.services.EntiteToDto;
import dto.LigneDeFraisDto;
import dto.MissionDto;
import dto.NotesDeFraisDto;

@RestController
@RequestMapping("/notes")
public class GestionFraisController {

	private NoteDeFraisRepo noteDeFraisRepo;
	private LigneDeFraisRepo ligneFraisRepo;

	public GestionFraisController(NoteDeFraisRepo noteDeFraisRepo, LigneDeFraisRepo ligneFraiRepo) {
		this.noteDeFraisRepo = noteDeFraisRepo;
		this.ligneFraisRepo = ligneFraiRepo;
	}
		//Get: methode renvoie les différents notes de frais 
	@GetMapping
	public List<NotesDeFraisDto> gestionNotesDeFrais() {

		List<NoteDeFrais> notesFrais = this.noteDeFraisRepo.findAll();

		List<NotesDeFraisDto> resultat = new ArrayList<>();
		for (NoteDeFrais note : notesFrais) {
			resultat.add(new NotesDeFraisDto(note.getId() + "", note.getMission().getId(),
					note.getMission().getDate_debut(), note.getMission().getDate_fin(),
					note.getMission().getNature().getNom(), note.getMission().getVille_depart(),
					note.getMission().getVille_arrive(), note.getMission().getTransport(), note.getPrix()));
		}

		return resultat;
	}
	
	
	//Get: methode renvoie une  note de frais grace à son identifiant  

	@GetMapping("/id")

	public NotesDeFraisDto gestionNotesDeFrais(@RequestParam("idNote") int idNote) {
		
		Optional<NoteDeFrais> noteFraisOptional = noteDeFraisRepo.findById(idNote);
			NoteDeFrais note = noteFraisOptional.get();
			return new NotesDeFraisDto(note.getId() + "", note.getMission().getId(),
					note.getMission().getDate_debut(), note.getMission().getDate_fin(),
					note.getMission().getNature().getNom(), note.getMission().getVille_depart(),
					note.getMission().getVille_arrive(), note.getMission().getTransport(), note.getPrix());
				
	}
		



}
