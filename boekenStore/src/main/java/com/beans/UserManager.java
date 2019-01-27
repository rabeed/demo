package com.beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;

import com.model.User;


@Named
@SessionScoped
public class UserManager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	///@Inject
	//private UserService userService;

	private User currentUser;
	private User user;

	public UserManager() {

		user = new User();
	}

	public boolean isSignedIn() {
		return currentUser != null;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	
	public void signIn() {
		
		FacesContext.getCurrentInstance().addMessage("signInMessage",
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Header", "Sign in"));
		//User u = userService.getUser(user.getUserName());
	/*	if (u != null) {
			if (user.getPassword().equals(u.getPassword())) {
				currentUser = u;
			//	return "index?faces-redirect=true";
			} else {
				FacesContext.getCurrentInstance().addMessage("signInMessage",
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Header", "invalid username or password"));
				
			}

		}*/
		// if (u == null || !currentUser.getPassword().equals(u.getPassword()))
		// {
		// return "signIn?faces-redirect=true";
		FacesContext.getCurrentInstance().addMessage("signInMessage",
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Header", "invalid username or password"));
	//	return "signIn?faces-redirect=true";

	}

	public String signOut() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "index?faces-redirect=true";

	}

	public String save(User u) {
	//	userService.saveUser(u);
		return "index.jsf?faces-redirect=true";

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
