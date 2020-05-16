package dev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.domain.Mission;
import dev.domain.Prime;
import dto.MissionDto;
import dto.PrimeDtoComplet;

@Service
public class EntiteToDto {

	@Autowired
	LoadPrime loadPrime;

	public EntiteToDto(LoadPrime loadPrime) {
		this.loadPrime = loadPrime;
	}

	public MissionDto missionToDto(Mission mission) {
		MissionDto missionDto = new MissionDto();
		missionDto.setId(mission.getId());
		missionDto.setCollegueId(mission.getCollegue().getId());
		missionDto.setValidation(mission.isValidation());
		missionDto.setDate_debut(mission.getDate_debut());
		missionDto.setDate_fin(mission.getDate_fin());
		missionDto.setVille_depart(mission.getVille_depart());
		missionDto.setVille_arrive(mission.getVille_arrive());
		missionDto.setTransport(mission.getTransport());
		missionDto.setStatut(mission.getStatut());
		mission = loadPrime.loadPrime(mission);
		if (mission.getPrime() != null) {
			missionDto.setPrime(EntiteToDto.primesToDto(mission.getPrime()));
		}
		missionDto.setNature(mission.getNature());
		return missionDto;
	}

	public static PrimeDtoComplet primesToDto(Prime prime) {
		PrimeDtoComplet primeDto = new PrimeDtoComplet(prime.getId(), prime.getDate_debut(), prime.getDate_fin(),
				prime.getMontant(), prime.getDeduction(), prime.getCollegue().getId());
		primeDto.setNature(prime.getNature());
		return primeDto;
	}
}
