package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.Prime;

public interface PrimeRepo extends JpaRepository<Prime, Long> {

}
