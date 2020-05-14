package dto;

import java.time.LocalDate;

/**Structure modèlisant un prime lié à une mission avec une note de frais donnée à communiquer avec l'extérieur (WEB API).
 * @author Salaheddine El Majdoub
 *
 */
public class PrimeDto {
	
	private Integer id;

    private LocalDate date;
    
	private Integer montant;

	/**Constructeur
	 * @param id
	 * @param date
	 * @param montant
	 */
	public PrimeDto(Integer id, LocalDate date, Integer montant) {
		super();
		this.id = id;
		this.date = date;
		this.montant = montant;
	}

	/**Getter
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**Setter
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**Getter
	 * @return date de prime
	 */
	public LocalDate getDate() {
		return date;
	}

	/**Setter
	 * @param date de prime
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**Getter
	 * @return montant de prime
	 */
	public Integer getMontant() {
		return montant;
	}

	/**Setter
	 * @param montant de prime
	 */
	public void setMontant(Integer montant) {
		this.montant = montant;
	}
	
	

}
