package be.realdolmen.boekenstore.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.realdolmen.boekenstore.domain.Gebruiker;

@Stateless
public class GebruikerRepository {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Inject
	EntityManager em;

	public Gebruiker save(Gebruiker gebruiker) {
		em.persist(gebruiker);
		return gebruiker;
	}

	public Gebruiker findByUsernameAndPassword(String username, String password) {
		Query q = em.createQuery("select g from Gebruiker g where g.username=:username and g.password=:password",
				Gebruiker.class);
		q.setParameter("username", username);
		q.setParameter("password", password);
		return (Gebruiker) q.getSingleResult();

	}

	public Gebruiker findById(Long id) {
		return em.find(Gebruiker.class, id);
	}

	public List<Gebruiker> findAll() {
		return em.createQuery("select g from Gebruiker g", Gebruiker.class).getResultList();
	}

	public void remove(long id) {
		logger.info("Removing Gebruiker with id " + id);
		em.remove(em.getReference(Gebruiker.class, id));
	}
}
