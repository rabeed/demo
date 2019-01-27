package be.realdolmen.boekenstore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Size;

@Entity
public class Game extends Artikel {

	@Enumerated(EnumType.STRING)
	private GameGenere genere;

	@Column(length = 100)
	@Size(max = 100, message = "uitgever must be max 100 characters")
	private String uitgever;

	private int minimumLeeftijd;

	public GameGenere getGenere() {
		return genere;
	}

	public void setGenere(GameGenere genere) {
		this.genere = genere;
	}

	public String getUitgever() {
		return uitgever;
	}

	public void setUitgever(String uitgever) {
		this.uitgever = uitgever;
	}

	public int getMinimumLeeftijd() {
		return minimumLeeftijd;
	}

	public void setMinimumLeeftijd(int minimumLeeftijd) {
		this.minimumLeeftijd = minimumLeeftijd;
	}

}
