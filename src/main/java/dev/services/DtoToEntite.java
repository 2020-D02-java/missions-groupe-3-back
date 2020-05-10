package dev.services;

import dev.domain.Mission;
import dto.MissionDto;

public class DtoToEntite {
	public static Mission dtoToMission(Mission mission, MissionDto missionDto) {
		mission.setDate_debut(missionDto.getDate_debut());
		mission.setDate_fin(missionDto.getDate_fin());
		mission.setTransport(missionDto.getTransport());
		mission.setVille_arrive(missionDto.getVille_arrive());
		mission.setVille_depart(missionDto.getVille_depart());
		return mission;
	}
}
