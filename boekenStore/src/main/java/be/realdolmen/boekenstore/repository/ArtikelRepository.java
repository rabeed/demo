package be.realdolmen.boekenstore.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.realdolmen.boekenstore.domain.Artikel;

@Stateless
public class ArtikelRepository {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Inject
	EntityManager em;

	public Artikel save(Artikel artikel) {
		em.persist(artikel);
		return artikel;
	}

	public Artikel findById(Long id) {
		return em.find(Artikel.class, id);
	}

	public List<Artikel> findAll() {
		return em.createQuery("select a from Artikel a", Artikel.class).getResultList();
	}

	public void remove(long id) {
		logger.info("Removing artikel with id " + id);
		em.remove(em.getReference(Artikel.class, id));
	}
}
