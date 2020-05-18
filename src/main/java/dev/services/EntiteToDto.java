package dev.services;

import dev.domain.Mission;
import dev.domain.Nature;
import dev.domain.Prime;
import dto.MissionDto;
import dto.PrimeDtoComplet;

public class EntiteToDto {

	public static MissionDto missionToDto(MissionDto missionDto, Mission mission) {
		if (mission.getNature() != null && mission.getPrime() != null) {
			missionDto = new MissionDto(mission.getId(), mission.getCollegue().getId(), mission.getNature(),
					mission.getPrime().getId(), mission.isValidation(), mission.getDate_debut(), mission.getDate_fin(),
					mission.getVille_depart(), mission.getVille_arrive(), mission.getTransport(), mission.getStatut());
		} else if (mission.getNature() == null && mission.getPrime() != null) {
			missionDto = new MissionDto(mission.getId(), mission.getCollegue().getId(), new Nature(),
					mission.getPrime().getId(), mission.isValidation(), mission.getDate_debut(), mission.getDate_fin(),
					mission.getVille_depart(), mission.getVille_arrive(), mission.getTransport(), mission.getStatut());
		} else if (mission.getPrime() == null) {
			missionDto = new MissionDto(mission.getId(), mission.getCollegue().getId(), mission.getNature(), -1,
					mission.isValidation(), mission.getDate_debut(), mission.getDate_fin(), mission.getVille_depart(),
					mission.getVille_arrive(), mission.getTransport(), mission.getStatut());
		} else {
			missionDto = new MissionDto(mission.getId(), mission.getCollegue().getId(), new Nature(), null,
					mission.isValidation(), mission.getDate_debut(), mission.getDate_fin(), mission.getVille_depart(),
					mission.getVille_arrive(), mission.getTransport(), mission.getStatut());
		}
		return missionDto;
	}

	public static PrimeDtoComplet primesToDto(Prime prime) {
		PrimeDtoComplet primeDto = new PrimeDtoComplet(prime.getId(), prime.getDate_debut(), prime.getDate_fin(),
				prime.getMontant(), prime.getDeduction(), prime.getCollegue().getId());
		primeDto.setNature(prime.getNature());
		return primeDto;
	}
}
