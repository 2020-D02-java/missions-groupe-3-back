package dev.services;

import java.time.Duration;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import dev.domain.Mission;
import dev.domain.Nature;
import dev.domain.NoteDeFrais;
import dev.domain.Prime;
import dev.repository.NoteDeFraisRepo;
import dev.repository.PrimeRepo;

/**
 * @author antoinethebault <br/>
 *         LoadPrime calcul des primes : <br/>
 *         Prime = (nombre de jours travaillés)* TJM * %Prime/100 -
 *         déduction<br/>
 *         association d'une prime a une nature active au moment de la date de
 *         debut<br/>
 *         Si le plafond de frais a été dépassé alors une déduction s'applique:
 *         déduction = somme des frais - (plafond de frais)*(nombre de jours de
 *         la mission)
 */
public class LoadPrime {

	@Autowired
	NoteDeFraisRepo noteDeFraisRepo;

	@Autowired
	PrimeRepo primeRepo;

	Logger logger = Logger.getLogger("logger");

	public Mission loadPrime(Mission mission) {
		Nature nature = mission.getNature();
		if (nature == null)
			logger.log(Level.INFO, "LoadPrime : Aucune nature n'est definie pour la mission " + mission.getId());
		if (mission.getDate_fin() == null)
			logger.log(Level.INFO, "LoadPrime : Aucune date de fin n'est definie pour la mission " + mission.getId());
		if (nature != null && mission.getDate_fin() != null && nature.isPrime()) {
			long nbJours = Duration.between(mission.getDate_fin(), mission.getDate_debut()).toDays();
			int TJM = nature.getTjm();
			float pourcentage = nature.getPourcentage();
			int deduction = 0;
			Optional<NoteDeFrais> noteDeFrais = noteDeFraisRepo.findByMission(mission);
			if (noteDeFrais.isPresent() && noteDeFrais.get().getPrix() > nature.getPlafond()) {
				deduction = noteDeFrais.get().getPrix() - nature.getPlafond();
			}
			int montant = (int) ((nbJours * TJM * pourcentage - deduction) * 100);
			Prime prime = mission.getPrime();
			if (prime == null)
				prime = new Prime(mission.getDate_debut(), mission.getDate_fin(), montant, deduction);
			else {
				prime.setDate_debut(mission.getDate_debut());
				prime.setDate_fin(mission.getDate_fin());
				prime.setMontant(montant);
				prime.setDeduction(deduction);
			}
			prime.setCollegue(mission.getCollegue());
			prime.setNature(mission.getNature());
			primeRepo.save(prime);
			mission.setPrime(prime);
		}
		return mission;
	}
}
