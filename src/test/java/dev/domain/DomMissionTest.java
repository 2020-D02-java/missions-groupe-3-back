package dev.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import dev.repository.CollegueRepo;
import dev.repository.MissionRepo;
import dev.repository.PrimeRepo;


@DataJpaTest
public class DomMissionTest {
	@Autowired
	CollegueRepo collegueRepo;
	@Autowired
	PrimeRepo primeRepo;
	@Autowired
	MissionRepo missionRepo;
	Collegue collegue;
	Prime prime;
	Mission mission;
	Nature nature;
	NoteDeFrais noteDeFrais;

	@BeforeEach
	void setUp() throws Exception {
		collegue = new Collegue("collegue", "prenom", "email", "superpass");
		collegue.setRoles(Arrays.asList(new RoleCollegue(collegue, Role.ROLE_EMPLOYE)));
		collegueRepo.save(collegue);
		prime = new Prime(LocalDate.now(), 10000);
		primeRepo.save(prime);
		nature = new Nature("Conseil", false, false, 10000, 7, 50000, false, LocalDate.now(), LocalDate.of(2021, 5, 1));
		noteDeFrais = new NoteDeFrais("facture1", 10000, LocalDate.now());
		mission = new Mission(prime, false, LocalDate.now(), "Paris", "Lille", "train");
		mission.setPrime(prime);
		mission.setNature(nature);
		mission.setCollegue(collegue);
		missionRepo.save(mission);

	}

	@Test
	void testPrime() {
		assertThat(mission.getPrime()).isEqualTo(prime);
	}

	@Test
	void testNature() {
		assertThat(mission.getNature()).isEqualTo(nature);
	}

}
