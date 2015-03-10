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
	private Integer usertype;

//	public User(String email2, String password2, int position) {
//		// TODO Auto-generated constructor stub
//		email=email2;
//		password=password2;
//		usertype=position;
//	}
	
	public User(){}

	public User(String email, String password, int position) {
		// TODO Auto-generated constructor stub
		this.email=email;
		this.password=password;
		this.usertype=position;
	}

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