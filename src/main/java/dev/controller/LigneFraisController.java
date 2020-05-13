package dev.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.domain.LigneDeFrais;
import dev.domain.NoteDeFrais;
import dev.repository.LigneDeFraisRepo;
import dev.repository.NoteDeFraisRepo;
import dto.LigneDeFraisDto;
import dto.NotesDeFraisDto;


@RestController
@RequestMapping("/ligne")
public class LigneFraisController {

	private LigneDeFraisRepo ligneFraisRepo;

	public LigneFraisController(LigneDeFraisRepo ligneFraisRepo) {
		this.ligneFraisRepo = ligneFraisRepo;
		}

	@GetMapping("{UUID}")
	public List<LigneDeFraisDto> gestionLignesDeFrais(@PathVariable String UUID) {

		  List<LigneDeFrais> ligneFrais =  this.ligneFraisRepo.findAll();
		  List<LigneDeFraisDto> resultat = new ArrayList<>();
		  for (LigneDeFrais ligne : ligneFrais ) {
			  if (ligne.getNote_de_frais().getId() == Integer.parseInt(UUID.replace("UUID=", "")))
			  resultat.add(new LigneDeFraisDto(ligne.getNote_de_frais().getDate_saisie(), ligne.getId(),ligne.getType(), ligne.getPrix(), ligne.getNote_de_frais()));
		  }
		  return resultat;		  
	  }
	
	@PostMapping
	
	public void enregistrerLigneFrais(@RequestBody LigneDeFrais ligneDeFrais) {
		this.ligneFraisRepo.save(ligneDeFrais);
		
	}
	

}
