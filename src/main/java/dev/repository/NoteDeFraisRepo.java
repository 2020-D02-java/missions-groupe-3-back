package dev.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.Mission;
import dev.domain.NoteDeFrais;;

public interface NoteDeFraisRepo extends JpaRepository<NoteDeFrais, Long> {

	Optional<NoteDeFrais> findByMission(Mission mission);

}
