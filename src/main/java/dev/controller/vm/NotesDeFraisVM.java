package dev.controller.vm;

import java.time.LocalDate;

import dev.domain.Nature;


/**Structure modèlisant la Gestion des notes de frais à communiquer avec l'extérieur (WEB API).
 * @author Salaheddine El Majdoub
 *
 */
public class NotesDeFraisVM {
	
	private LocalDate dateDebut;
    private LocalDate dateFin;
    private String nature;
    private String depart;
    private String arrivee;
    private String transport;
    private Integer frais;
    
	/*** Constructeur
	 * @param dateDebut
	 * @param dateFin
	 * @param nature
	 * @param depart
	 * @param arrivee
	 * @param transport
	 * @param frais
	 */
	public NotesDeFraisVM(LocalDate dateDebut, LocalDate dateFin, String nature, String depart, String arrivee,
			String transport, Integer frais) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.nature = nature;
		this.depart = depart;
		this.arrivee = arrivee;
		this.transport = transport;
		this.frais = frais;
	}

	/**Getter
	 * @return date de debut
	 */
	public LocalDate getDateDebut() {
		return dateDebut;
	}

	/**Setter
	 * @param dateDebut
	 */
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**Getter
	 * @return date de fin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}

	/**Setter
	 * @param dateFin
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	/**Getter
	 * @return nature de mission
	 */
	public String getNature() {
		return nature;
	}

	/**Setter
	 * @param nature de mission
	 */
	public void setNature(String nature) {
		this.nature = nature;
	}

	/**Getter
	 * @return ville de depart
	 */
	public String getDepart() {
		return depart;
	}

	/**Setter
	 * @param ville de depart
	 */
	public void setDepart(String depart) {
		this.depart = depart;
	}

	/**Getter
	 * @return ville d'arrivée
	 */
	public String getArrivee() {
		return arrivee;
	}

	/**Setter
	 * @param  ville d'arrivée
	 */
	public void setArrivee(String arrivee) {
		this.arrivee = arrivee;
	}

	/**Getter
	 * @return moyen de transport
	 */
	public String getTransport() {
		return transport;
	}

	/**Setter
	 * @param moyen de transport
	 */
	public void setTransport(String transport) {
		this.transport = transport;
	}

	/**Getter
	 * @return frais
	 */
	public Integer getFrais() {
		return frais;
	}

	/**Setter
	 * @param frais
	 */
	public void setFrais(Integer frais) {
		this.frais = frais;
	}


}
