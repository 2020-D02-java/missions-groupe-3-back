package dev.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

	/** GET : all valides par date */
	@GetMapping
	@RequestMapping(value = "/valides")
	public List<Nature> naturesValides() {
		List<Nature> natures = natureRepo.findAll();
		List<Nature> resultat = new ArrayList<>();
		LocalDate date = LocalDate.now();
		for (Nature nature : natures) {
			if (nature.getDate_debut().compareTo(date) <= 0 && nature.getDate_fin().compareTo(date) >= 0) {
				resultat.add(nature);
			}
		}
		return resultat;
	}

}
