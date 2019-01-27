package com.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

//import org.hibernate.validator.constraints.NotBlank;

import com.model.User;


@Named
@RequestScoped
public class SignIn {

	//@NotBlank(message = "username is requird")
	private String username;
//	@NotBlank(message = "password is requird")
	private String password;

	private User currentUser;

//	@Inject
	//private UserService userService;

	public void signIn(String username, String password) {
		FacesContext.getCurrentInstance().addMessage("signInMessage",
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Header", "Sign in"));
	/*	User u = userService.getUser(username);
		if (u != null) {
			if (u.getPassword().equals(password)) {
				currentUser = u;
				// return "index?faces-redirect=true";
			} else {
				FacesContext.getCurrentInstance().addMessage("signInMessage",
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Header", "invalid username or password"));

			}

		}
		// if (u == null || !currentUser.getPassword().equals(u.getPassword()))
		// {
		// return "signIn?faces-redirect=true";
		FacesContext.getCurrentInstance().addMessage("signInMessage",
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Header", "invalid username or password"));
		// return "signIn?faces-redirect=true";
*/
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
