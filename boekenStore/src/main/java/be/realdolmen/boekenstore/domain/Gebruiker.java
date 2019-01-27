package be.realdolmen.boekenstore.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Gebruiker {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstaname;
	private String lastname;
	private String password;
	private String role;

	@OneToMany(mappedBy = "gebruiker")
	private List<Bestelling> bestelling = new ArrayList<>();

	@OneToMany(mappedBy = "gebruiker")
	private List<Beoordeling> Beoordelingen = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Bestelling> getBestelling() {
		return bestelling;
	}

	public void setBestelling(List<Bestelling> bestelling) {
		this.bestelling = bestelling;
	}

	public List<Beoordeling> getBeoordelingen() {
		return Beoordelingen;
	}

	public void setBeoordelingen(List<Beoordeling> beoordelingen) {
		Beoordelingen = beoordelingen;
	}

	public String getFirstaname() {
		return firstaname;
	}

	public void setFirstaname(String firstaname) {
		this.firstaname = firstaname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstaname == null) ? 0 : firstaname.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		Gebruiker other = (Gebruiker) obj;
		if (firstaname == null) {
			if (other.firstaname != null)
				return false;
		} else if (!firstaname.equals(other.firstaname))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Gebruiker [id=" + id + ", firstaname=" + firstaname + ", lastname=" + lastname + ", password="
				+ password + ", role=" + role + "]";
	}

}
