package be.realdolmen.boekenstore.service;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.realdolmen.boekenstore.domain.Artikel;
import be.realdolmen.boekenstore.repository.ArtikelRepository;

import java.util.List;

@Stateless
@LocalBean
public class ArtikelServiceBean implements ArtikelService {

	@EJB
	ArtikelRepository artikelRepository;

	@Override
	public Artikel save(Artikel person) {
		return artikelRepository.save(person);
	}

	@Override
	public Artikel findById(Long id) {
		return artikelRepository.findById(id);
	}

	@Override
	public List<Artikel> findAll() {
		return artikelRepository.findAll();
	}

	@Override
	public void remove(long personId) {
		artikelRepository.remove(personId);
	}
}
