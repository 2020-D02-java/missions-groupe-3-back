package dev.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DomNoteDeFraisTest {

	Prime prime;
	NoteDeFrais noteDeFrais;
	Mission mission;
	LigneDeFrais ligneDeFrais;

	@BeforeEach
	void setUp() throws Exception {
		prime = new Prime(LocalDate.now(), 10000);
		noteDeFrais = new NoteDeFrais("facture1", 10000, LocalDate.now());
		mission = new Mission(prime, false, LocalDate.now(), "Paris", "Lille", "train");
		noteDeFrais.setMission(mission);
	}

	@Test
	void testMission() {
		assertThat(noteDeFrais.getMission()).isEqualTo(mission);
	}

}
