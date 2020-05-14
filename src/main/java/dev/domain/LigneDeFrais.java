package dev.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "ligne_de_frais")
public class LigneDeFrais {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String type;

	private Integer prix;
	
	private Integer noteFraisID;

	@ManyToOne
	@JoinColumn(name = "note_de_frais_id")
	private NoteDeFrais note_de_frais;

	/**
	 * Constructor
	 * 
	 */
	public LigneDeFrais() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param type
	 * @param prix
	 */
	public LigneDeFrais(String type, Integer prix) {
		super();
		this.type = type;
		this.prix = prix;
	}
	public LigneDeFrais(String type, Integer prix, Integer noteFraisID) {
		super();
		this.type = type;
		this.prix = prix;
		this.noteFraisID = noteFraisID;
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Setter
	 * 
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
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
	 * @return the note_de_frais
	 */
	public NoteDeFrais getNote_de_frais() {
		return note_de_frais;
	}

	/**
	 * Setter
	 * 
	 * @param note_de_frais the note_de_frais to set
	 */
	public void setNote_de_frais(NoteDeFrais note_de_frais) {
		this.note_de_frais = note_de_frais;
	}


}
