package be.realdolmen.boekenstore.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Size;
//import org.hibernate.validator.constraints.NotBlank;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Artikel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, length = 100)
	//@NotBlank
	@Size(max = 100, message = "title must be max 100 characters")
	private String titel;

	@Column(nullable = false, length = 100)
	@Size(max = 100, message = "price must be max 100 characters")
	//@NotBlank(message = "prijs is required")
	private double prijs;

	@Column(nullable = false, length = 100)
	@Size(max = 100, message = "leverancierId must be max 100 characters")
	//@NotBlank(message = "leverancierId is required")
	private String leverancierId;

	@OneToMany(mappedBy = "artikel")
	private List<BestellingItem> bestellingItems = new ArrayList<>();

	@OneToMany(mappedBy = "artikel")
	private List<Beoordeling> beoordelingen = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public double getPrijs() {
		return prijs;
	}

	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}

	public String getLeverancierId() {
		return leverancierId;
	}

	public void setLeverancierId(String leverancierId) {
		this.leverancierId = leverancierId;
	}

	public List<Beoordeling> getBeoordelingen() {
		return beoordelingen;
	}

	public void setBeoordelingen(List<Beoordeling> beoordelingen) {
		this.beoordelingen = beoordelingen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((titel == null) ? 0 : titel.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artikel other = (Artikel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (titel == null) {
			if (other.titel != null)
				return false;
		} else if (!titel.equals(other.titel))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Artikel [id=" + id + ", titel=" + titel + ", prijs=" + prijs + ", leverancierId=" + leverancierId + "]";
	}

}
