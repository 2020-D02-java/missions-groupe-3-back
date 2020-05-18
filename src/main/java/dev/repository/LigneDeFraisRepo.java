package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.LigneDeFrais;

public interface LigneDeFraisRepo extends JpaRepository<LigneDeFrais, Long> {

	List<LigneDeFrais> findByNoteFraisID(Integer id);

}
