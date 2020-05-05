package dev.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Collegue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nom;

	private String prenom;

	private String email;

	private String motDePasse;

	@OneToMany(mappedBy = "collegue", cascade = CascadeType.PERSIST)
	private List<RoleCollegue> roles;

	@ManyToOne
	@JoinColumn(name = "manager_id")
	private Collegue manager;

	@OneToMany(mappedBy = "manager")
	private List<Collegue> subordonnes;

	/**
	 * Constructor
	 * 
	 */
	public Collegue() {
		super();
		subordonnes = new ArrayList<>();
	}

	/**
	 * Constructor
	 * 
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param motDePasse
	 */
	public Collegue(String nom, String prenom, String email, String motDePasse) {
		super();
		subordonnes = new ArrayList<>();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = motDePasse;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public List<RoleCollegue> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleCollegue> roles) {
		this.roles = roles;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Getter
	 * 
	 * @return the manager
	 */
	public Collegue getManager() {
		return manager;
	}

	/**
	 * Setter
	 * 
	 * @param manager the manager to set
	 */
	public void setManager(Collegue manager) {
		this.manager = manager;
	}

	/**
	 * Getter
	 * 
	 * @return the subordonnes
	 */
	public List<Collegue> getSubordonnes() {
		return subordonnes;
	}

	/**
	 * Setter
	 * 
	 * @param subordonnes the subordonnes to set
	 */
	public void setSubordonnes(List<Collegue> subordonnes) {
		this.subordonnes = subordonnes;
	}

}
