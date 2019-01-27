package be.realdolmen.boekenstore.service;

import be.realdolmen.boekenstore.domain.Gebruiker;

import java.util.List;

import javax.ejb.Local;

@Local
public interface GebruikerService {

	Gebruiker save(Gebruiker gebruiker);

	Gebruiker findByUsernameAndPassword(String username, String password);

	List<Gebruiker> findAll();

	void remove(long id);
}
