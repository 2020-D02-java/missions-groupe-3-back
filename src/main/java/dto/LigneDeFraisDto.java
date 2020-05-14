package dto;

import java.time.LocalDate;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import dev.domain.NoteDeFrais;

/**Structure modèlisant la ligne des notes de frais
 * @author Salaheddine El Majdoub
 *
 */
public class LigneDeFraisDto {
	
    
    private LocalDate date;
    
	private String nature;

	private Integer montant;
	
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "note_de_frais_id")
	private Integer note_de_frais;

	/**Constructeur
	 * @param date
	 * @param nature
	 * @param montant
	 * @param note_de_frais	 */
	public LigneDeFraisDto(LocalDate date, int id, String nature, Integer montant, NoteDeFrais note_de_frais) {
		super();
		this.date = date;
		this.nature = nature;
		this.montant = montant;
		this.note_de_frais = note_de_frais.getId();
		this.id = id;
	}

	/**Getter
	 * @return datede la ligne de frais
	 */
	public LocalDate getDate() {
		return date;
	}

	/**Setter
	 * @param date de la ligne de frais
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**Getter
	 * @return nature des frais
	 */
	public String getNature() {
		return nature;
	}
	
	
	/**Getter
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**Setter
	 * @param nature des frais
	 */
	public void setNature(String nature) {
		this.nature = nature;
	}

	/**Getter
	 * @return montant 
	 */
	public Integer getMontant() {
		return montant;
	}

	/**Setter
	 * @param montant
	 */
	public void setMontant(Integer montant) {
		this.montant = montant;
	}

	/**Getter
	 * @return
	 */
	public Integer getNote_de_frais() {
		return note_de_frais;
	}

	/**Setter
	 * @param note_de_frais
	 */
	public void setNote_de_frais(NoteDeFrais note_de_frais) {
		this.note_de_frais = note_de_frais.getId();
	}
	
	
	
	

}
