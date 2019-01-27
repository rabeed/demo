package be.realdolmen.boekenstore.service;

import be.realdolmen.boekenstore.domain.Artikel;

import java.util.List;

import javax.ejb.Local;

@Local
public interface ArtikelService {
	
	Artikel save(Artikel art);

	Artikel findById(Long id);

	List<Artikel> findAll();

	void remove(long id);
}
