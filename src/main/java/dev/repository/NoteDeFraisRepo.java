package dev.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.domain.Mission;
import dev.domain.NoteDeFrais;

public interface NoteDeFraisRepo extends JpaRepository<NoteDeFrais, Integer> {

	Optional<NoteDeFrais> findById( int id);
	
	Optional<NoteDeFrais> findByMission(Mission mission);

	@Query("SELECT n FROM note_de_frais n WHERE n.mission.id = ?1")
	Optional<NoteDeFrais> findByMissionId(Integer id);

}
