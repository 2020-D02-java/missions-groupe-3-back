package dev.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Prime {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private LocalDate date_debut;

	private LocalDate date_fin;

	private Integer montant;

	private Integer deduction;

	@ManyToOne
	@JoinColumn(name = "collegue_id")
	private Collegue collegue;

	@ManyToOne
	@JoinColumn(name = "nature_id")
	private Nature nature;

	/**
	 * Constructor
	 * 
	 */
	public Prime() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param deduction
	 * @param date
	 * @param montant
	 */
	public Prime(Integer deduction, LocalDate date, Integer montant) {
		super();
		this.deduction = deduction;
		this.date_debut= date;
		this.montant = montant;
	}
	
	/**
	 * Constructor
	 * 
	 * @param date
	 * @param montant
	 */
	public Prime(LocalDate date, Integer montant) {
		super();
		this.date_debut = date;
		this.montant = montant;
	}

	/**
	 * Constructor
	 * 
	 * @param date
	 * @param montant
	 * @param deduction
	 */
	public Prime(LocalDate date_debut, LocalDate date_fin, Integer montant, Integer deduction) {
		super();
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.montant = montant;
		this.deduction = deduction;
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
	 * @return the date
	 */
	public LocalDate getDate_debut() {
		return date_debut;
	}

	/**
	 * Setter
	 * 
	 * @param date the date to set
	 */
	public void setDate_debut(LocalDate date_debut) {
		this.date_debut = date_debut;
	}

	/**
	 * Getter
	 * 
	 * @return the montant
	 */
	public Integer getMontant() {
		return montant;
	}

	/**
	 * Setter
	 * 
	 * @param montant the montant to set
	 */
	public void setMontant(Integer montant) {
		this.montant = montant;
	}

	/**
	 * Getter
	 * 
	 * @return the collegue
	 */
	public Collegue getCollegue() {
		return collegue;
	}

	/**
	 * Setter
	 * 
	 * @param collegue the collegue to set
	 */
	public void setCollegue(Collegue collegue) {
		this.collegue = collegue;
	}

	/**
	 * Getter
	 * 
	 * @return the deduction
	 */
	public Integer getDeduction() {
		return deduction;
	}

	/**
	 * Setter
	 * 
	 * @param deduction the deduction to set
	 */
	public void setDeduction(Integer deduction) {
		this.deduction = deduction;
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

	/**
	 * Getter
	 * 
	 * @return the nature
	 */
	public Nature getNature() {
		return nature;
	}

	/**
	 * Setter
	 * 
	 * @param nature the nature to set
	 */
	public void setNature(Nature nature) {
		this.nature = nature;
	}

}
