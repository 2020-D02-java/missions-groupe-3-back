package dev.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.domain.Nature;
import dev.repository.NatureRepo;

@RestController
@RequestMapping(value = "/natures")
public class NatureController {

	@Autowired
	NatureRepo natureRepo;

	/** GET : all */
	@GetMapping
	public List<Nature> natures() {
		List<Nature> natures = natureRepo.findAll();
		return natures;
	}
	
	/** PATCH :  mis à jour d'une nature de mission **/
	
	@PatchMapping
	@RequestMapping(value="/modification")
	public ResponseEntity<String> updateClient(@RequestBody Nature nature){
		Nature currentNature = natureRepo.findById(nature.getId());
			currentNature.setNom(nature.getNom());
			currentNature.setPrime(nature.isPrime());
			currentNature.setFacturation(nature.isFacturation());
			currentNature.setTjm(nature.getTjm());
			currentNature.setPourcentage(nature.getPourcentage());
			currentNature.setPlafond(nature.getPlafond());
			currentNature.setPlafond_depassable(nature.isPlafond_depassable());
				
		return
	}

}
