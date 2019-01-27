package com.beans;

import java.io.Serializable;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;

import com.model.User;


@Named
@ViewScoped
public class UserDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
	private Validator validator = vf.getValidator();
	private Set<ConstraintViolation<User>> violations;


	@Inject
	private UserManager userManager;

	private User user;

	public UserDetails() {
		user = new User();
	}

	public void onLoad() {
		user = userManager.isSignedIn() ? userManager.getCurrentUser() : new User();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String submit() {
		System.out.println("register a new user:");
		violations = validator.validate(user);
		if (violations.size() > 0)
			throw new ConstraintViolationException(violations);

		return userManager.save(user);
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

}
