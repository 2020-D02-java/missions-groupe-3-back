package dto;

import java.time.LocalDate;

import dev.domain.Nature;

public class PrimeDtoComplet {
	private Integer id;

	private LocalDate date_debut;

	private LocalDate date_fin;

	private Integer montant;

	private Integer deduction;

	private long collegue_id;

	private Nature nature;

	/**
	 * Constructor
	 * 
	 */
	public PrimeDtoComplet() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param date_debut
	 * @param date_fin
	 * @param montant
	 * @param deduction
	 * @param collegue_id
	 * @param mission_id
	 */
	public PrimeDtoComplet(Integer id, LocalDate date_debut, LocalDate date_fin, Integer montant, Integer deduction,
			long collegue_id) {
		super();
		this.id = id;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.montant = montant;
		this.deduction = deduction;
		this.collegue_id = collegue_id;
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
	 * Setter
	 * 
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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
	 * @return the collegue_id
	 */
	public long getCollegue_id() {
		return collegue_id;
	}

	/**
	 * Setter
	 * 
	 * @param collegue_id the collegue_id to set
	 */
	public void setCollegue_id(long collegue_id) {
		this.collegue_id = collegue_id;
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
