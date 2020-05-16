package dev.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.domain.Collegue;
import dev.domain.Mission;
import dev.domain.NoteDeFrais;
import dev.domain.Prime;
import dev.repository.CollegueRepo;
import dev.repository.MissionRepo;
import dev.repository.NoteDeFraisRepo;
import dev.repository.PrimeRepo;
import dev.services.EntiteToDto;
import dto.PrimeDto;
import dto.PrimeDtoComplet;

/**
 * @author Salaheddine El Majdoub
 *
 */
/**
 * @author antoinethebault ajout de primesCollegue, primesAnnees
 */
@RestController
@RequestMapping("/prime")
public class PrimeController {

	private NoteDeFraisRepo noteDeFraisRepo;
	private MissionRepo missionRepo;
	private CollegueRepo collegueRepo;
	private PrimeRepo primeRepo;

	/**
	 * Constructeur
	 * 
	 * @param noteDeFraisRepo
	 * @param missionRepo
	 */
	public PrimeController(NoteDeFraisRepo noteDeFraisRepo, MissionRepo missionRepo, CollegueRepo collegueRepo,
			PrimeRepo primeRepo) {

		this.noteDeFraisRepo = noteDeFraisRepo;
		this.missionRepo = missionRepo;
		this.collegueRepo = collegueRepo;
		this.primeRepo = primeRepo;
	}

	// Methode retourne une liste de prime (ou un seul) qui correspond à la note de
	// frais d'une mission donnée

	@GetMapping("{UUID}")
	public List<PrimeDto> getPrime(@PathVariable String UUID) {
		List<NoteDeFrais> notesFrais = this.noteDeFraisRepo.findAll();
		List<Mission> missions = this.missionRepo.findAll();
		int idNote = Integer.parseInt(UUID.replace("UUID=", ""));
		int idMission = -1;
		for (NoteDeFrais note : notesFrais) {
			if (note.getId() == idNote)
				idMission = note.getMission().getId();
		}

		List<PrimeDto> resultat = new ArrayList<>();
		for (Mission mission : missions)
			if (mission.getId() == idMission)

				resultat.add(new PrimeDto(mission.getPrime().getId(), mission.getPrime().getDate_debut(),
						mission.getPrime().getMontant()));

		return resultat;
	}

	/**
	 * GET : primes/collegue?email=xxx@dev.fr recupere les primes d'un collegue
	 */
	@GetMapping
	@RequestMapping(value = "/collegue")
	public List<PrimeDtoComplet> primesCollegue(@RequestParam("email") String email,
			@RequestParam("tri_date") String tri_date, @RequestParam("annee") Integer annee) {
		Optional<Collegue> collegueOptional = collegueRepo.findByEmail(email);
		List<PrimeDtoComplet> primesDto = new ArrayList<>();
		if (collegueOptional.isPresent()) {
			Collegue collegue = collegueOptional.get();
			List<Prime> primes = new ArrayList<>();
			if (tri_date.equals(""))
				primes = primeRepo.findByCollegue(collegue);
			else if (tri_date.equals("true"))
				primes = primeRepo.findByCollegueAsc(collegue);
			else if (tri_date.equals("false"))
				primes = primeRepo.findByCollegueDesc(collegue);
			for (Prime prime : primes) {
				System.out.println(prime.getDate_debut() + " " + prime.getId());
				int anneePrime = prime.getDate_debut().getYear();
				if (anneePrime == annee)
					primesDto.add(EntiteToDto.primesToDto(prime));
			}
		}
		return primesDto;
	}

	/**
	 * GET : primes/annees?email=xxx@dev.fr recupere les annees des primes d'un
	 * collegue
	 */
	@GetMapping
	@RequestMapping(value = "/annees")
	public List<Integer> primesAnnees(@RequestParam("email") String email) {
		Optional<Collegue> collegueOptional = collegueRepo.findByEmail(email);
		List<Integer> annees = new ArrayList<>();
		if (collegueOptional.isPresent()) {
			Collegue collegue = collegueOptional.get();
			List<Prime> primes = primeRepo.findByCollegueAsc(collegue);
			for (Prime prime : primes) {
				int annee = prime.getDate_debut().getYear();
				if (!annees.contains(annee))
					annees.add(annee);
			}
		}
		return annees;
	}

}
