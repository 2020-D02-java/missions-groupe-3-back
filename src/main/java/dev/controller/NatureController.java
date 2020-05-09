package dev.controller;

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

}
