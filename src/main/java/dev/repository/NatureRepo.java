package dev.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.Nature;

public interface NatureRepo extends JpaRepository<Nature, Integer> {

	Optional<Nature> findByNom(String nature);

	Optional<Nature> findById(Integer id);

}
