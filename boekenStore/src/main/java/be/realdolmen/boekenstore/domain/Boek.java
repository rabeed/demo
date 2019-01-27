package be.realdolmen.boekenstore.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//import org.hibernate.validator.constraints.NotBlank;

import be.realdolmen.boekenstore.constraints.Isbn;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "boek_type")
public abstract class Boek extends Artikel {

	@Column(length = 100)
	@Size(max = 100, message = "auteur must be max 100 characters")
	private String auteur;
	//@NotBlank(message = "isbn is required")
	@Isbn(message = "Isbn is not valid")
	private String isbn;
	private int aantalPaginas;

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getAantalPaginas() {
		return aantalPaginas;
	}

	public void setAantalPaginas(int aantalPaginas) {
		this.aantalPaginas = aantalPaginas;
	}

	@Override
	public String toString() {
		return "Boek [auteur=" + auteur + ", isbn=" + isbn + ", aantalPaginas=" + aantalPaginas + "]";
	}

}
