package dev.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DomPrimeTest {

	Prime prime;
	Collegue collegue;
	Mission mission;

	@BeforeEach
	void setUp() throws Exception {
		mission = new Mission(prime, false, LocalDate.now(), "Paris", "Lille", "train");
		prime = new Prime(LocalDate.now(), 10000);
		collegue = new Collegue("collegue", "prenom", "email", "superpass");
		prime.setCollegue(collegue);
		prime.setMission(mission);
	}

	@Test
	void testMission() {
		assertThat(prime.getMission()).isEqualTo(mission);
	}

	@Test
	void testCollegue() {
		assertThat(prime.getCollegue()).isEqualTo(collegue);
	}

}
