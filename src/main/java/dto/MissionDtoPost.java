package dto;

import java.time.LocalDate;

import dev.domain.Nature;

public class MissionDtoPost {

	private Integer id;

	private Nature nature;

	private LocalDate date_debut;

	private LocalDate date_fin;

	private String ville_depart;

	private String ville_arrivee;

	private String transport;

	private String collegue_email;

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
	 * @param collegue_email
	 */
	public MissionDtoPost(Integer id, Nature nature, LocalDate date_debut, LocalDate date_fin, String ville_depart,
			String ville_arrivee, String transport, String collegue_email) {
		super();
		this.nature = nature;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.ville_depart = ville_depart;
		this.ville_arrivee = ville_arrivee;
		this.transport = transport;
		this.collegue_email = collegue_email;
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
	public String getVille_arrivee() {
		return ville_arrivee;
	}

	/**
	 * Setter
	 * 
	 * @param ville_arrive the ville_arrive to set
	 */
	public void setVille_arrive(String ville_arrivee) {
		this.ville_arrivee = ville_arrivee;
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
	 * @return the collegue_email
	 */
	public String getCollegue_email() {
		return collegue_email;
	}

	/**
	 * Setter
	 * 
	 * @param collegue_email the collegue_email to set
	 */
	public void setCollegue_email(String collegue_email) {
		this.collegue_email = collegue_email;
	}

	/**
	 * Setter
	 * 
	 * @param ville_arrivee the ville_arrivee to set
	 */
	public void setVille_arrivee(String ville_arrivee) {
		this.ville_arrivee = ville_arrivee;
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
