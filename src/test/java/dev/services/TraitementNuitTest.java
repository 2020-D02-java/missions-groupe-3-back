package dev.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.domain.Collegue;
import dev.domain.NoteDeFrais;
import dev.repository.CollegueRepo;
import dev.repository.MissionRepo;
import dev.repository.PrimeRepo;

@SpringJUnitConfig(TraitementNuit.class)
class TraitementNuitTest {

	LoadPrime loadPrime;

	@MockBean
	CollegueRepo collegueRepo;

	@MockBean
	MissionRepo missionRepo;

	@MockBean
	NoteDeFrais noteDeFrais;

	@MockBean
	PrimeRepo primeRepo;

	@BeforeEach
	void setUp() throws Exception {
		Collegue col2 = new Collegue();

	}

	@Test
	void test() {

	}

}
