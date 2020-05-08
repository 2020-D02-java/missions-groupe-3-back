package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.Collegue;
import dev.domain.Mission;

public interface MissionRepo extends JpaRepository<Mission, Long> {

	List<Mission> findByCollegue(Collegue collegue);

}
