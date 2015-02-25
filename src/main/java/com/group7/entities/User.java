package com.group7.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * email is the primary key so therefore will be unique type is an int: 
 * 1. Admin
 * 2. Support Engineer 
 * 3. Customer Service rep
 * 
 */
@Entity
@Table(name = "Users")
public class User {

	@Id
	@Column(name = "Email")
	private String email;
	@Column(name = "Password")
	private String password;
	@Column(name = "Usertype")
	private int usertype;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getType() {
		return usertype;
	}

	public void setType(int type) {
		this.usertype = type;
	}
}