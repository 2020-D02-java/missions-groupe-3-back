package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.domain.Collegue;
import dev.domain.Prime;

public interface PrimeRepo extends JpaRepository<Prime, Integer> {

	List<Prime> findByCollegue(Collegue collegue);

	@Query("SELECT p FROM Prime p WHERE p.collegue = ?1 ORDER BY p.date_debut ASC")
	List<Prime> findByCollegueAsc(Collegue collegue);

	@Query("SELECT p FROM Prime p WHERE p.collegue = ?1 ORDER BY p.date_debut DESC")
	List<Prime> findByCollegueDesc(Collegue collegue);

}
