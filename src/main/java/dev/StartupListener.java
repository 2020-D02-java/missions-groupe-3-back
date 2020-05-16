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

		Nature nature = new Nature("Conseil", false, true, 10000, 0, 50000, false, LocalDate.of(2020, 5, 1),
				LocalDate.of(2021, 5, 1));
		this.natureRepo.save(nature);

		Nature nature2 = new Nature("Formation", true, true, 10000, 2, 50000, false, LocalDate.of(2020, 5, 1),
				LocalDate.of(2021, 5, 1));
		this.natureRepo.save(nature2);
		Nature nature3 = new Nature("Expertise_technique", false, true, 100, 0, 50000, false,
				LocalDate.of(2020, 5, 1), LocalDate.of(2021, 5, 10));
		this.natureRepo.save(nature3);
		Nature nature4 = new Nature("Conseil", true, true, 950, 4, 50000, false, LocalDate.of(2019, 5, 1),
				LocalDate.of(2020, 4, 30));
		this.natureRepo.save(nature4);

		Prime prime = new Prime(LocalDate.now(), LocalDate.now(), 10000, 0);
		prime.setNature(nature);
		prime.setCollegue(col2);
		this.primeRepo.save(prime);

		Prime prime2 = new Prime(LocalDate.of(2019, 5, 1), LocalDate.of(2019, 5, 1), 12000, 0);
		prime2.setNature(nature2);
		prime2.setCollegue(col2);
		this.primeRepo.save(prime2);

		Prime prime3 = new Prime(LocalDate.of(2019, 5, 1), LocalDate.of(2019, 5, 1), 22000, 0);
		prime3.setNature(nature2);
		prime3.setCollegue(col2);
		this.primeRepo.save(prime3);

		Mission mission = new Mission(prime, false, LocalDate.of(2020, 05, 20), "Paris", "Lille", "train");
		mission.setDate_fin(LocalDate.of(2020, 05, 25));
		mission.setCollegue(col2);
		mission.setNature(nature);
		mission.setStatut("INITIALE");
		this.missionRepo.save(mission);

		Mission mission2 = new Mission(prime2, false, LocalDate.of(2020, 05, 26), "Paris", "Lyon", "train");
		mission2.setDate_fin(LocalDate.of(2020, 05, 27));
		mission2.setCollegue(col2);
		mission2.setNature(nature);
		mission2.setPrime(prime);
		mission2.setStatut("VALIDEE");
		this.missionRepo.save(mission2);

		Mission mission3 = new Mission(prime3, false, LocalDate.of(2020, 05, 28), "Paris", "Bordeaux", "covoiturage");
		mission3.setDate_fin(LocalDate.of(2020, 05, 28));
		mission3.setCollegue(col2);
		mission3.setNature(nature2);
		mission3.setPrime(prime);
		mission3.setStatut("EN_ATTENTE_VALIDATION");
		this.missionRepo.save(mission3);

		Mission mission4 = new Mission(prime, false, LocalDate.of(2020, 05, 29), "Paris", "Nantes", "covoiturage");
		mission4.setDate_fin(LocalDate.of(2020, 05, 29));
		mission4.setCollegue(col2);
		mission4.setNature(nature3);
		mission4.setStatut("EN_ATTENTE_VALIDATION");
		this.missionRepo.save(mission4);

		NoteDeFrais noteDeFrais = new NoteDeFrais("facture1", 10000, LocalDate.now());
		noteDeFrais.setMission(mission);
		noteDeFraisRepo.save(noteDeFrais);

		LigneDeFrais ligneDeFrais = new LigneDeFrais("restaurant", 1500);
		ligneDeFrais.setNote_de_frais(noteDeFrais);
		ligneDeFraisRepo.save(ligneDeFrais);

		// Création de deux utilisateurs

//		 prime = new Prime(LocalDate.now(), 15000);
//		this.primeRepo.save(prime);
//		 nature = new Nature("Diplomatie", false, false, 10000, 7, 50000, false, LocalDate.now(),
//				LocalDate.of(2021, 5, 1));
//		this.natureRepo.save(nature);
//		 mission = new Mission(prime, false, LocalDate.now(), "Casa", "Marseille", "train");
//		mission.setCollegue(col2);
//		mission.setNature(nature);
//		mission.setPrime(prime);
//		this.missionRepo.save(mission);
//
//		 NoteDeFrais noteDeFrais2 = new NoteDeFrais("facture2", 10000, LocalDate.now());
//		noteDeFrais2.setMission(mission);
//		noteDeFraisRepo.save(noteDeFrais2);
//
//		 ligneDeFrais = new LigneDeFrais("Hôtel", 150000);
//		ligneDeFrais.setNote_de_frais(noteDeFrais);
//		ligneDeFraisRepo.save(ligneDeFrais);

	}

}
