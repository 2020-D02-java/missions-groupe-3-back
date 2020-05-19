package dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.repository.MissionRepo;
import dev.services.LoadPrime;
import dev.services.TraitementNuit;

@RestController
@RequestMapping(value = "/trtmnt_nuit")
public class TraitementNuitController {

	@Autowired
	MissionRepo missionRepo;

	@Autowired
	LoadPrime loadPrime;

	@GetMapping
	public ResponseEntity<String> trtmtNuit() {
		TraitementNuit traitementNuit = new TraitementNuit(missionRepo, loadPrime);
		traitementNuit.start();
		return ResponseEntity.status(200).body("\"traitement de nuit lance\"");
	}

}
