package dev.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.domain.Mission;
import dev.repository.MissionRepo;

/**
 * @author antoinethebault <br/>
 *         TraitementNuit : passage du statut des missions INITIALE a
 *         EN_ATTENTE_VALIDATION <br/>
 *         charge la prime associee si une nature est definie
 */

@Service
public class TraitementNuit {
	@Autowired
	MissionRepo missionRepo;

	@Autowired
	LoadPrime loadPrime;

	public TraitementNuit(MissionRepo missionRepo, LoadPrime loadPrime) {
		this.missionRepo = missionRepo;
		this.loadPrime = loadPrime;
	}

	public void start() {
		List<Mission> missions = missionRepo.findAll();
		for (Mission mission : missions) {
			if (mission.getStatut().equals("INITIALE")) {
				mission.setStatut("EN_ATTENTE_VALIDATION");
				mission = loadPrime.loadPrime(mission);
				missionRepo.save(mission);
			}
		}
	}

}
