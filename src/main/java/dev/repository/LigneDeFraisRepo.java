package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.LigneDeFrais;

public interface LigneDeFraisRepo extends JpaRepository<LigneDeFrais, Long> {

}
