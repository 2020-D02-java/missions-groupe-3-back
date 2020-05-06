package dev.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "note_de_frais")
public class NoteDeFrais {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "mission_id")
	private Mission mission;

	private String nom;

	private Integer prix;

	private LocalDate date_saisie;

	/**
	 * Constructor
	 * 
	 */
	public NoteDeFrais() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param nom
	 * @param prix
	 * @param date_saisie
	 */
	public NoteDeFrais(String nom, Integer prix, LocalDate date_saisie) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.date_saisie = date_saisie;
	}

	/**
	 * Getter
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Getter
	 * 
	 * @return the mission
	 */
	public Mission getMission() {
		return mission;
	}

	/**
	 * Setter
	 * 
	 * @param mission the mission to set
	 */
	public void setMission(Mission mission) {
		this.mission = mission;
	}

	/**
	 * Getter
	 * 
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter
	 * 
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter
	 * 
	 * @return the prix
	 */
	public Integer getPrix() {
		return prix;
	}

	/**
	 * Setter
	 * 
	 * @param prix the prix to set
	 */
	public void setPrix(Integer prix) {
		this.prix = prix;
	}

	/**
	 * Getter
	 * 
	 * @return the date_saisie
	 */
	public LocalDate getDate_saisie() {
		return date_saisie;
	}

	/**
	 * Setter
	 * 
	 * @param date_saisie the date_saisie to set
	 */
	public void setDate_saisie(LocalDate date_saisie) {
		this.date_saisie = date_saisie;
	}

}
