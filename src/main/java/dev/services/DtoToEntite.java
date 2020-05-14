package dev.services;

import dev.domain.Mission;
import dto.MissionDto;
import dto.MissionDtoPost;

public class DtoToEntite {
	public static Mission dtoToMission(Mission mission, MissionDto missionDto) {
		mission.setDate_debut(missionDto.getDate_debut());
		mission.setDate_fin(missionDto.getDate_fin());
		mission.setTransport(missionDto.getTransport());
		mission.setVille_arrive(missionDto.getVille_arrive());
		mission.setVille_depart(missionDto.getVille_depart());
		mission.setStatut(missionDto.getStatut());
		return mission;
	}

	public static Mission dtoPostToMission(Mission mission, MissionDtoPost missionDto) {
		mission.setDate_debut(missionDto.getDate_debut());
		mission.setDate_fin(missionDto.getDate_fin());
		mission.setTransport(missionDto.getTransport());
		mission.setVille_arrive(missionDto.getVille_arrivee());
		mission.setVille_depart(missionDto.getVille_depart());
		mission.setStatut(missionDto.getStatut());
		return mission;
	}
}
