package be.realdolmen.boekenstore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Size;

@Entity
public class Lp extends Artikel {

	@Enumerated(EnumType.STRING)
	private LpGenere genere;

	@Column(length = 100)
	@Size(max = 100, message = "uitvoerder must be max 100 characters")
	private String uitvoerder;

	public LpGenere getGenere() {
		return genere;
	}

	public void setGenere(LpGenere genere) {
		this.genere = genere;
	}

	public String getUitvoerder() {
		return uitvoerder;
	}

	public void setUitvoerder(String uitvoerder) {
		this.uitvoerder = uitvoerder;
	}

}
