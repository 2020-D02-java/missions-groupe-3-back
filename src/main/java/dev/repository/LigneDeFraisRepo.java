package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.domain.LigneDeFrais;
import dev.domain.NoteDeFrais;

public interface LigneDeFraisRepo extends JpaRepository<LigneDeFrais, Long> {

	List<LigneDeFrais> findByNoteFraisID(Integer id);

	@Query("SELECT l FROM ligne_de_frais l WHERE l.note_de_frais=?1")
	List<LigneDeFrais> findByNote_de_frais(NoteDeFrais noteDeFrais);

}
