package be.realdolmen.boekenstore.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue(value = "nonfictie")
public class NonFictieBoek extends Boek {

	@Enumerated(EnumType.STRING)
	private Onderwerp onderwerp;

	public Onderwerp getOnderwerp() {
		return onderwerp;
	}

	public void setOnderwerp(Onderwerp onderwerp) {
		this.onderwerp = onderwerp;
	}

}
