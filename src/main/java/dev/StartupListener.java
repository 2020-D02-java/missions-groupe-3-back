package dev;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import dev.domain.Collegue;
import dev.domain.LigneDeFrais;
import dev.domain.Mission;
import dev.domain.Nature;
import dev.domain.NoteDeFrais;
import dev.domain.Prime;
import dev.domain.Role;
import dev.domain.RoleCollegue;
import dev.domain.Version;
import dev.repository.CollegueRepo;
import dev.repository.LigneDeFraisRepo;
import dev.repository.MissionRepo;
import dev.repository.NatureRepo;
import dev.repository.NoteDeFraisRepo;
import dev.repository.PrimeRepo;
import dev.repository.VersionRepo;

/**
 * Code de démarrage de l'application. Insertion de jeux de données.
 */
@Component
public class StartupListener {

	private String appVersion;
	private VersionRepo versionRepo;
	private PasswordEncoder passwordEncoder;
	private CollegueRepo collegueRepo;
	private PrimeRepo primeRepo;
	private MissionRepo missionRepo;
	private NatureRepo natureRepo;
	private NoteDeFraisRepo noteDeFraisRepo;
	private LigneDeFraisRepo ligneDeFraisRepo;

	public StartupListener(@Value("${app.version}") String appVersion, VersionRepo versionRepo,
			PasswordEncoder passwordEncoder, CollegueRepo collegueRepo, PrimeRepo primeRepo, MissionRepo missionRepo,
			NatureRepo natureRepo, NoteDeFraisRepo noteDeFraisRepo, LigneDeFraisRepo ligneDeFraisRepo) {
		this.appVersion = appVersion;
		this.versionRepo = versionRepo;
		this.passwordEncoder = passwordEncoder;
		this.collegueRepo = collegueRepo;
		this.primeRepo = primeRepo;
		this.missionRepo = missionRepo;
		this.natureRepo = natureRepo;
		this.noteDeFraisRepo = noteDeFraisRepo;
		this.ligneDeFraisRepo = ligneDeFraisRepo;
	}

	@EventListener(ContextRefreshedEvent.class)
	public void onStart() {
		this.versionRepo.save(new Version(appVersion));

		// Création de deux utilisateurs

		Collegue col1 = new Collegue();
		col1.setNom("Admin");
		col1.setPrenom("DEV");
		col1.setEmail("admin@dev.fr");
		col1.setMotDePasse(passwordEncoder.encode("superpass"));
		col1.setRoles(Arrays.asList(new RoleCollegue(col1, Role.ROLE_ADMINISTRATEUR)));
		this.collegueRepo.save(col1);

		Collegue col2 = new Collegue();
		col2.setNom("User");
		col2.setPrenom("DEV");
		col2.setEmail("user@dev.fr");
		col2.setMotDePasse(passwordEncoder.encode("superpass"));
		col2.setRoles(Arrays.asList(new RoleCollegue(col2, Role.ROLE_EMPLOYE)));

		Collegue col3 = new Collegue();
		col3.setNom("Manager");
		col3.setPrenom("DEV");
		col3.setEmail("manager@dev.fr");
		col3.setMotDePasse(passwordEncoder.encode("superpass"));
		col3.setRoles(
				Arrays.asList(new RoleCollegue(col3, Role.ROLE_MANAGER), new RoleCollegue(col3, Role.ROLE_EMPLOYE)));
		col3.setSubordonnes(Arrays.asList(col2));
		this.collegueRepo.save(col3);

		col2.setManager(col3);
		this.collegueRepo.save(col2);
		Prime prime = new Prime(LocalDate.now(), 10000);
		this.primeRepo.save(prime);
		Nature nature = new Nature("Conseil", false, false, 10000, 7, 50000, false, LocalDate.now(),
				LocalDate.of(2021, 5, 1));
		this.natureRepo.save(nature);
		Mission mission = new Mission(prime, false, LocalDate.of(2020, 05, 20), "Paris", "Lille", "train");
		mission.setDate_fin(LocalDate.of(2020, 05, 25));
		mission.setCollegue(col2);
		mission.setNature(nature);
		mission.setPrime(prime);
		this.missionRepo.save(mission);

		NoteDeFrais noteDeFrais = new NoteDeFrais("facture1", 10000, LocalDate.now());
		noteDeFrais.setMission(mission);
		noteDeFraisRepo.save(noteDeFrais);

		LigneDeFrais ligneDeFrais = new LigneDeFrais("restaurant", 1500);
		ligneDeFrais.setNote_de_frais(noteDeFrais);
		ligneDeFraisRepo.save(ligneDeFrais);

	}

}
