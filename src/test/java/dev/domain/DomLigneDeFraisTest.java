package dev.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DomLigneDeFraisTest {

	NoteDeFrais noteDeFrais;
	LigneDeFrais ligneDeFrais;

	@BeforeEach
	void setUp() throws Exception {
		noteDeFrais = new NoteDeFrais("facture1", 10000, LocalDate.now());
		ligneDeFrais = new LigneDeFrais(1, "restaurant", 1500);
		ligneDeFrais.setNote_de_frais(noteDeFrais);
	}

	@Test
	void testLigneDeFrais() {
		assertThat(ligneDeFrais.getNote_de_frais()).isEqualTo(noteDeFrais);
	}

}
