package dev.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.LigneDeFrais;
import dev.domain.Nature;
import dev.domain.NoteDeFrais;

public interface LigneDeFraisRepo extends JpaRepository<LigneDeFrais, Long> {
	
	List<LigneDeFrais> findByNoteDeFrais(NoteDeFrais note_de_frais);
	Optional<LigneDeFrais> findById( int id);

	
}
