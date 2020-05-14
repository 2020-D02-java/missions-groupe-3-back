package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.NoteDeFrais;;

public interface NoteDeFraisRepo extends JpaRepository<NoteDeFrais, Long> {
	
	

}
