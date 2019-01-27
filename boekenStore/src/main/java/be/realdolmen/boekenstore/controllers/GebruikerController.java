package be.realdolmen.boekenstore.controllers;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.beans.UserManager;
import com.model.User;

import be.realdolmen.boekenstore.domain.Gebruiker;
import be.realdolmen.boekenstore.service.GebruikerService;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Named
@RequestScoped
public class GebruikerController implements Serializable {

	private static final long serialVersionUID = 1L;

	Logger Logger = LoggerFactory.getLogger(getClass());

	@EJB
	private GebruikerService gebruikerService;

	private ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
	private Validator validator = vf.getValidator();
	private Set<ConstraintViolation<User>> violations;

	private Gebruiker gebruiker;
	private Gebruiker selectedGebruiker;

	public GebruikerController() {
		gebruiker = new Gebruiker();
		selectedGebruiker = new Gebruiker();
	}

	public void submit() {
		Logger.info("register a new user:");
		// violations = validator.validate(user);
		/*
		 * if (violations.size() > 0) throw new
		 * ConstraintViolationException(violations);
		 */

		gebruikerService.save(gebruiker);
	}

	public void validateEmail(FacesContext context, UIComponent c, Object o) {
		String e = (String) o;
		if (e != null && e.length() > 0 && !e.contains("@")) {
			// FacesContext.getCurrentInstance().addMessage("validateEmail",
			// new FacesMessage(FacesMessage.SEVERITY_ERROR, "Header", "invalid
			// email"));
			throw new ValidatorException(new FacesMessage("invalid email"));

		}
		// new FacesMessage(FacesMessage.SEVERITY_ERROR, "Header", "Sign in"));
	}

	public String login() {
		return "artikelenList?faces-redirect=true";
	}

	public List<Gebruiker> getAllUsers() {
		return gebruikerService.findAll();
	}

	public Gebruiker getGebruiker() {
		return gebruiker;
	}

	public void setGebruiker(Gebruiker gebruiker) {
		this.gebruiker = gebruiker;
	}

	public Gebruiker getSelectedGebruiker() {
		return selectedGebruiker;
	}

	public void setSelectedGebruiker(Gebruiker selectedGebruiker) {
		this.selectedGebruiker = selectedGebruiker;
	}

}
