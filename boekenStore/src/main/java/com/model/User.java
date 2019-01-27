package com.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

//import org.hibernate.validator.constraints.Email;

public class User {

	@NotNull
	@Size(min=4,max=20,message="username size is invalid")
	private String userName;
	@NotNull
	@Size(min=4,max=20,message="firstname size is invalid")
	private String firstName;
	@NotNull
	@Size(min=4,max=20,message="lasntname size is invalid")
	private String lastName;
	@NotNull
	@Size(min=4,max=20,message="password size is invalid")
	private String password;
	@Past
	private Date birthdate ;
	@NotNull
	//@Email
	private String email;

	public User() {

		// TODO Auto-generated constructor stub
	}

	private User(UserBuilder u) {
		this.userName = u.userName;
		this.lastName = u.lastName;
		this.password = u.password;
		this.firstName = u.firstName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// public User getUser() {
	// return new User.UserBuilder("Jhon", "Doe", "").build();
	// }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}


	private static class UserBuilder {

		private String userName;
		private String lastName;
		private String firstName;
		private String password;

		public UserBuilder(String userName, String lastName, String password) {

			this.userName = userName;
			this.lastName = lastName;
			this.password = password;
		}

		public UserBuilder setUserName(String s) {
			this.userName = s;
			return this;
		}

		public UserBuilder setLastName(String s) {
			this.lastName = s;
			return this;
		}

		public UserBuilder setPassword(String s) {
			this.password = s;
			return this;
		}

		public UserBuilder setFirstName(String s) {
			this.firstName = s;
			return this;
		}

		public User build() {
			User u = new User(this);
			return u;
		}

	}

}
