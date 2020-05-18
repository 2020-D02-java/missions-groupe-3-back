package dev.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.Collegue;
import dev.domain.LigneDeFrais;
import dev.domain.Mission;
import dev.domain.NoteDeFrais;;

public interface NoteDeFraisRepo extends JpaRepository<NoteDeFrais, Long> {


	Optional<NoteDeFrais> findById( int id);

	Optional<NoteDeFrais> findByMission(Mission mission);


	

}
