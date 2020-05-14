package dev.services;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.domain.Collegue;
import dev.domain.Mission;
import dev.domain.Nature;
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
		col2.setNom("nom");

		// une nature sans prime
		Nature nature = new Nature("Conseil", false, false, 10000, 7, 50000, false, LocalDate.of(2020, 5, 1),
				LocalDate.of(2021, 5, 1));

		// une nature avec prime avec plafond
		Nature nature2 = new Nature("Formation", true, false, 10000, 7, 50000, false, LocalDate.of(2020, 5, 1),
				LocalDate.of(2021, 5, 1));

		// une nature avec prime sans plafond
		Nature nature3 = new Nature("Expertise_technique", true, false, 10000, 7, 50000, false,
				LocalDate.of(2020, 5, 1), LocalDate.of(2021, 5, 10));

		Mission mission = new Mission(null, false, LocalDate.of(2020, 05, 20), "Paris", "Lille", "train");
		mission.setDate_fin(LocalDate.of(2020, 05, 25));
		mission.setCollegue(col2);
		mission.setStatut("INITIALE");

	}

	@Test
	void test() {

	}

}
