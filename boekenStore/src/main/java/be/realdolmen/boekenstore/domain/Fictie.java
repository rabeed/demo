package be.realdolmen.boekenstore.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Size;

@Entity
@DiscriminatorValue(value = "fictie")
public class Fictie extends Boek {

	@Enumerated(EnumType.STRING)
	private FictieBoekGenre genere;

	@Column(length = 255)
	@Size(max = 255, message = "korteInhoud must be max 255 characters")
	String korteInhoud;

	public FictieBoekGenre getGenere() {
		return genere;
	}

	public void setGenere(FictieBoekGenre genere) {
		this.genere = genere;
	}

	public String getKorteInhoud() {
		return korteInhoud;
	}

	public void setKorteInhoud(String korteInhoud) {
		this.korteInhoud = korteInhoud;
	}

}
