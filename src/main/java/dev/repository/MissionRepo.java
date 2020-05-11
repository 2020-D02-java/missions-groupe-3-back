package dev.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.domain.Collegue;
import dev.domain.Mission;

public interface MissionRepo extends JpaRepository<Mission, Integer> {

	List<Mission> findByCollegue(Collegue collegue);

	@Query("SELECT m FROM Mission m WHERE m.collegue.id = ?1 AND m.date_debut = ?2 AND m.date_fin = ?3")
	Mission findByCollegueAndDates(Long id, LocalDate date_debut, LocalDate date_fin);

	List<Mission> findByCollegue(Collegue collegue, Sort by);

	@Query("SELECT m FROM Mission m WHERE m.collegue.id = ?1 ORDER BY m.date_debut ASC")
	List<Mission> findByCollegueDateDebutAsc(long id);

	@Query("SELECT m FROM Mission m WHERE m.collegue.id = ?1 ORDER BY m.date_debut DESC")
	List<Mission> findByCollegueDateDebutDesc(long id);

	@Query("SELECT m FROM Mission m WHERE m.collegue.id = ?1 ORDER BY m.date_fin ASC")
	List<Mission> findByCollegueDateFinAsc(long id);

	@Query("SELECT m FROM Mission m WHERE m.collegue.id = ?1 ORDER BY m.date_fin DESC")
	List<Mission> findByCollegueDateFinDesc(long id);

	@Query("SELECT m FROM Mission m, Collegue c WHERE m.statut = 'EN_ATTENTE_VALIDATION' AND m.collegue.id = c.id AND c.manager.id = ?1")
	List<Mission> findAttenteByManager(long id);

	@Query("SELECT m FROM Mission m, Collegue c WHERE m.statut = 'EN_ATTENTE_VALIDATION' AND m.collegue.id = c.id AND c.manager.id = ?1 ORDER BY m.date_debut ASC")
	List<Mission> findAttenteByManagerDateDebutAsc(long id);

	@Query("SELECT m FROM Mission m, Collegue c WHERE m.statut = 'EN_ATTENTE_VALIDATION' AND m.collegue.id = c.id AND c.manager.id = ?1 ORDER BY m.date_debut DESC")
	List<Mission> findAttenteByManagerDateDebutDesc(long id);

	@Query("SELECT m FROM Mission m, Collegue c WHERE m.statut = 'EN_ATTENTE_VALIDATION' AND m.collegue.id = c.id AND c.manager.id = ?1 ORDER BY m.date_fin ASC")
	List<Mission> findAttenteByManagerDateFinAsc(long id);

	@Query("SELECT m FROM Mission m, Collegue c WHERE m.statut = 'EN_ATTENTE_VALIDATION' AND m.collegue.id = c.id AND c.manager.id = ?1 ORDER BY m.date_fin DESC")
	List<Mission> findAttenteByManagerDateFinDesc(long id);

}
