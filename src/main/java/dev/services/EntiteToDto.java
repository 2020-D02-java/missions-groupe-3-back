package dev.services;

import dev.domain.Mission;
import dev.domain.Nature;
import dto.MissionDto;

public class EntiteToDto {
	public static MissionDto missionToDto(MissionDto missionDto, Mission mission) {
		if (mission.getNature() != null) {
			missionDto = new MissionDto(mission.getId(), mission.getCollegue().getId(), mission.getNature(),
					mission.getPrime(), mission.isValidation(), mission.getDate_debut(), mission.getDate_fin(),
					mission.getVille_depart(), mission.getVille_arrive(), mission.getTransport(), mission.getStatut());
		} else {
			missionDto = new MissionDto(mission.getId(), mission.getCollegue().getId(), new Nature(),
					mission.getPrime(), mission.isValidation(), mission.getDate_debut(), mission.getDate_fin(),
					mission.getVille_depart(), mission.getVille_arrive(), mission.getTransport(), mission.getStatut());
		}
		return missionDto;
	}
}
