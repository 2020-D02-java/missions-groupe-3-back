package dev.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dev.domain.Mission;
import dev.repository.MissionRepo;

/**
 * @author antoinethebault <br/>
 *         TraitementNuit : passage du statut des missions INITIALE a
 *         EN_ATTENTE_VALIDATION <br/>
 *         charge la prime associee si une nature est definie
 */
public class TraitementNuit {
	@Autowired
	MissionRepo missionRepo;

	public void traitementNuit() {
		List<Mission> missions = missionRepo.findAll();
		LoadPrime loadPrime = new LoadPrime();
		for (Mission mission : missions) {
			if (mission.getStatut().equals("INITIALE")) {
				mission.setStatut("EN_ATTENTE_VALIDATION");
				mission = loadPrime.loadPrime(mission);
				missionRepo.save(mission);
			}
		}
	}

}
