package be.realdolmen.boekenstore.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.realdolmen.boekenstore.domain.Gebruiker;
import be.realdolmen.boekenstore.repository.GebruikerRepository;

@Stateless
@LocalBean
public class GebruikerServiceBean implements GebruikerService {

	@EJB
	GebruikerRepository gebruikerRepository;

	@Override
	public Gebruiker save(Gebruiker gebruiker) {

		return gebruikerRepository.save(gebruiker);
	}

	@Override
	public Gebruiker findByUsernameAndPassword(String username, String password) {

		return gebruikerRepository.findByUsernameAndPassword(username, password);
	}

	@Override
	public List<Gebruiker> findAll() {

		return gebruikerRepository.findAll();
	}

	@Override
	public void remove(long id) {
		gebruikerRepository.remove(id);

	}

}
