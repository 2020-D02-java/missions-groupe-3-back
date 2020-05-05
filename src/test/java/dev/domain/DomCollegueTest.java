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

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
class DomCollegueTest {

	Collegue collegue;
	Collegue manager;
	Prime prime;
	Mission mission;

	@Autowired
	CollegueRepo collegueRepo;
	@Autowired
	PrimeRepo primeRepo;
	@Autowired
	MissionRepo missionRepo;

	@BeforeEach
	void setUp() throws Exception {
		collegue = new Collegue("collegue", "prenom", "email", "superpass");
		collegue.setRoles(Arrays.asList(new RoleCollegue(collegue, Role.ROLE_EMPLOYE)));
		manager = new Collegue("manager", "prenom", "email", "superpass");
		manager.setRoles(Arrays.asList(new RoleCollegue(collegue, Role.ROLE_MANAGER)));
		collegue.setManager(manager);
		manager.setSubordonnes(Arrays.asList(collegue));
		collegueRepo.save(collegue);
		collegueRepo.save(manager);
		prime = new Prime(LocalDate.now(), 10000);
		primeRepo.save(prime);
		mission = new Mission(prime, false, LocalDate.now(), "Paris", "Lille", "train");
		mission.setCollegue(collegue);
		missionRepo.save(mission);

	}

	@Test
	void testManager() {
		assertThat(collegue.getManager()).isEqualTo(manager);
	}

	@Test
	void testSubordonnes() {
		assertThat(manager.getSubordonnes().get(0).getNom()).isEqualTo("collegue");
	}

}
