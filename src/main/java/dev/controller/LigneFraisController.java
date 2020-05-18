package dev.controller;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.domain.LigneDeFrais;
import dev.domain.NoteDeFrais;
import dev.repository.LigneDeFraisRepo;
import dev.repository.NoteDeFraisRepo;
import dto.LigneDeFraisDto;

@RestController
@RequestMapping("/ligne")
public class LigneFraisController {

	private static final Logger LOG = LoggerFactory.getLogger(LigneFraisController.class);

	private LigneDeFraisRepo ligneFraisRepo;
	private NoteDeFraisRepo noteFraisRepo;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd");

	public LigneFraisController(LigneDeFraisRepo ligneFraisRepo, NoteDeFraisRepo noteFraisRepo) {
		this.ligneFraisRepo = ligneFraisRepo;
		this.noteFraisRepo = noteFraisRepo;
	}
	
	// Get : Récuperation des ligne de frais à partir de l'identifiant d'une note de frais
	@GetMapping("/id")
	public List<LigneDeFraisDto> gestionNotesDeFrais(@RequestParam("idNote") int idNote) {
		Optional<NoteDeFrais> noteFraisOptional = noteFraisRepo.findById(idNote);
		List<LigneDeFraisDto> resultat = new ArrayList<>();
		List<LigneDeFrais> ligneFrais = new ArrayList<>();
		if (noteFraisOptional.isPresent()) {
			NoteDeFrais noteFrais = noteFraisOptional.get();

			ligneFrais = ligneFraisRepo.findByNoteDeFrais(noteFrais);
			for (LigneDeFrais ligne : ligneFrais) {
				resultat.add(new LigneDeFraisDto(ligne.getDate().toString(), ligne.getId(), ligne.getType(),
						ligne.getPrix(), ligne.getNote_de_frais().getId()));

			}
		}
		return resultat;
	}
	
	// POST : creation d'une ligne de frais 
	@PostMapping("/enregistrer")
	@CrossOrigin
	public ResponseEntity<Object> enregistrerLigneDeFrais(@RequestBody LigneDeFraisDto ligneDeFraisDto) {

//		LOG.info("helloooooo" + ligneDeFraisDto.getMontant());
		
		LigneDeFrais ligneDeFrais = new LigneDeFrais(ligneDeFraisDto.getId(), ligneDeFraisDto.getType(),
				ligneDeFraisDto.getMontant()*100);
		Optional<NoteDeFrais> noteFraisOptional = noteFraisRepo.findById(ligneDeFraisDto.getNote_de_frais());
		NoteDeFrais noteFrais = noteFraisOptional.get();

		
		noteFrais.setPrix(noteFrais.getPrix() + ligneDeFraisDto.getMontant() * 100);
		ligneDeFrais.setDate(ligneDeFraisDto.getDate());
		ligneDeFrais.setNote_de_frais(noteFrais);

		ligneFraisRepo.save(ligneDeFrais);
		noteFraisRepo.save(noteFrais);

		return ResponseEntity.status(200).body(ligneDeFraisDto);
	}

	// POST : modification d'une ligne de frais 
	@PostMapping("/modifier")
	@CrossOrigin
	public ResponseEntity<Object> modifierLigneDeFrais(@RequestBody LigneDeFraisDto ligneDeFraisDto) {
		
		int idAModifier = ligneDeFraisDto.getId();
		LOG.info("id "+idAModifier + " new date "+ligneDeFraisDto.getDate().toString());
		Optional<NoteDeFrais> noteFraisOptional = noteFraisRepo.findById(ligneDeFraisDto.getNote_de_frais());
		NoteDeFrais noteFrais = noteFraisOptional.get();
		Optional<LigneDeFrais> ligneAModifierOpt = this.ligneFraisRepo.findById(idAModifier);
		LigneDeFrais ligneAModifier = ligneAModifierOpt.get();

		noteFrais.setPrix((noteFrais.getPrix() - ligneAModifier.getPrix()) + (ligneDeFraisDto.getMontant()*100) );

		ligneAModifier.setDate(ligneDeFraisDto.getDate());
		ligneAModifier.setPrix(ligneDeFraisDto.getMontant()*100);
		ligneAModifier.setType(ligneDeFraisDto.getType());

		ligneFraisRepo.save(ligneAModifier);
		noteFraisRepo.save(noteFrais);

		return ResponseEntity.status(200).body(ligneDeFraisDto);
	}

	


}
