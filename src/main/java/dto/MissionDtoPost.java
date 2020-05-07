package dto;

import java.time.LocalDate;

public class MissionDtoPost {

	private String nature;

	private LocalDate date_debut;

	private LocalDate date_fin;

	private String ville_depart;

	private String ville_arrivee;

	private String transport;

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
	public MissionDtoPost(String nature, LocalDate date_debut, LocalDate date_fin, String ville_depart,
			String ville_arrivee, String transport) {
		super();
		this.nature = nature;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.ville_depart = ville_depart;
		this.ville_arrivee = ville_arrivee;
		this.transport = transport;
	}

	/**
	 * Getter
	 * 
	 * @return the nature
	 */
	public String getNature() {
		return nature;
	}

	/**
	 * Setter
	 * 
	 * @param nature the nature to set
	 */
	public void setNature(String nature) {
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

}
