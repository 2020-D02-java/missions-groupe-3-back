package dto;

import java.time.LocalDate;

import dev.domain.Nature;
import dev.domain.Prime;

public class MissionDto {
	private Integer id;

	private long collegueId;

	private Nature nature;

	private Prime prime;

	private boolean validation;

	private LocalDate date_debut;

	private LocalDate date_fin;

	private String ville_depart;

	private String ville_arrive;

	private String transport;

	private String statut;

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param collegueId
	 * @param nature
	 * @param prime
	 * @param validation
	 * @param date_debut
	 * @param date_fin
	 * @param ville_depart
	 * @param ville_arrive
	 * @param transport
	 */
	public MissionDto(Integer id, long collegueId, Nature nature, Prime prime, boolean validation, LocalDate date_debut,
			LocalDate date_fin, String ville_depart, String ville_arrive, String transport, String statut) {
		super();
		this.id = id;
		this.collegueId = collegueId;
		this.nature = nature;
		this.prime = prime;
		this.validation = validation;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.ville_depart = ville_depart;
		this.ville_arrive = ville_arrive;
		this.transport = transport;
		this.statut = statut;
		this.nature = nature;
	}

	public MissionDto() {
		// TODO Auto-generated constructor stub
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
	 * @return the collegueId
	 */
	public long getCollegueId() {
		return collegueId;
	}

	/**
	 * Setter
	 * 
	 * @param collegueId the collegueId to set
	 */
	public void setCollegueId(long collegueId) {
		this.collegueId = collegueId;
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

	/**
	 * Getter
	 * 
	 * @return the prime
	 */
	public Prime getPrime() {
		return prime;
	}

	/**
	 * Setter
	 * 
	 * @param prime the prime to set
	 */
	public void setPrime(Prime prime) {
		this.prime = prime;
	}

	/**
	 * Getter
	 * 
	 * @return the validation
	 */
	public boolean isValidation() {
		return validation;
	}

	/**
	 * Setter
	 * 
	 * @param validation the validation to set
	 */
	public void setValidation(boolean validation) {
		this.validation = validation;
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
	 * @return the ville_depart
	 */
	public String getVille_depart() {
		return ville_depart;
	}

	/**
	 * Setter
	 * 
	 * @param ville_depart the ville_depart to set
	 */
	public void setVille_depart(String ville_depart) {
		this.ville_depart = ville_depart;
	}

	/**
	 * Getter
	 * 
	 * @return the ville_arrive
	 */
	public String getVille_arrive() {
		return ville_arrive;
	}

	/**
	 * Setter
	 * 
	 * @param ville_arrive the ville_arrive to set
	 */
	public void setVille_arrive(String ville_arrive) {
		this.ville_arrive = ville_arrive;
	}

	/**
	 * Getter
	 * 
	 * @return the transport
	 */
	public String getTransport() {
		return transport;
	}

	/**
	 * Setter
	 * 
	 * @param transport the transport to set
	 */
	public void setTransport(String transport) {
		this.transport = transport;
	}

	/**
	 * Getter
	 * 
	 * @return the statut
	 */
	public String getStatut() {
		return statut;
	}

	/**
	 * Setter
	 * 
	 * @param statut the statut to set
	 */
	public void setStatut(String statut) {
		this.statut = statut;
	}

}
