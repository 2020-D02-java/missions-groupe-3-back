package dev.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Nature {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nom;

	private boolean prime;

	private boolean facturation;

	private Integer tjm;

	private float pourcentage;

	private Integer plafond;

	private boolean plafond_depassable;

	private LocalDate date_debut;

	private LocalDate date_fin;

	/**
	 * Constructor
	 * 
	 */
	public Nature() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param nom
	 * @param prime
	 * @param facturation
	 * @param tjm
	 * @param pourcentage
	 * @param plafond
	 * @param plafond_depassable
	 * @param date_debut
	 * @param date_fin
	 */
	public Nature(String nom, boolean prime, boolean facturation, Integer tjm, float pourcentage, Integer plafond,
			boolean plafond_depassable, LocalDate date_debut, LocalDate date_fin) {
		super();
		this.nom = nom;
		this.prime = prime;
		this.facturation = facturation;
		this.tjm = tjm;
		this.pourcentage = pourcentage;
		this.plafond = plafond;
		this.plafond_depassable = plafond_depassable;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
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
	 * @return the prime
	 */
	public boolean isPrime() {
		return prime;
	}

	/**
	 * Setter
	 * 
	 * @param prime the prime to set
	 */
	public void setPrime(boolean prime) {
		this.prime = prime;
	}

	/**
	 * Getter
	 * 
	 * @return the facturation
	 */
	public boolean isFacturation() {
		return facturation;
	}

	/**
	 * Setter
	 * 
	 * @param facturation the facturation to set
	 */
	public void setFacturation(boolean facturation) {
		this.facturation = facturation;
	}

	/**
	 * Getter
	 * 
	 * @return the tjm
	 */
	public Integer getTjm() {
		return tjm;
	}

	/**
	 * Setter
	 * 
	 * @param tjm the tjm to set
	 */
	public void setTjm(Integer tjm) {
		this.tjm = tjm;
	}

	/**
	 * Getter
	 * 
	 * @return the pourcentage
	 */
	public float getPourcentage() {
		return pourcentage;
	}

	/**
	 * Setter
	 * 
	 * @param pourcentage the pourcentage to set
	 */
	public void setPourcentage(float pourcentage) {
		this.pourcentage = pourcentage;
	}

	/**
	 * Getter
	 * 
	 * @return the plafond
	 */
	public Integer getPlafond() {
		return plafond;
	}

	/**
	 * Setter
	 * 
	 * @param plafond the plafond to set
	 */
	public void setPlafond(Integer plafond) {
		this.plafond = plafond;
	}

	/**
	 * Getter
	 * 
	 * @return the plafond_depassable
	 */
	public boolean isPlafond_depassable() {
		return plafond_depassable;
	}

	/**
	 * Setter
	 * 
	 * @param plafond_depassable the plafond_depassable to set
	 */
	public void setPlafond_depassable(boolean plafond_depassable) {
		this.plafond_depassable = plafond_depassable;
	}

	/**
	 * Getter
	 * 
	 * @return the date_debut
	 */
	public LocalDate getDate_debut() {
		return date_debut;
	}

	/**
	 * Setter
	 * 
	 * @param date_debut the date_debut to set
	 */
	public void setDate_debut(LocalDate date_debut) {
		this.date_debut = date_debut;
	}

	/**
	 * Getter
	 * 
	 * @return the date_fin
	 */
	public LocalDate getDate_fin() {
		return date_fin;
	}

	/**
	 * Setter
	 * 
	 * @param date_fin the date_fin to set
	 */
	public void setDate_fin(LocalDate date_fin) {
		this.date_fin = date_fin;
	}

}
