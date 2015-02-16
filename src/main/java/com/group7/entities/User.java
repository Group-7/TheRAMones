package com.group7.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * email is the primary key so therefore will be unique
 * type is an int: 
 * 		1. Admin
 * 		2. Support Engineer
 * 		3. Customer Service rep
 * 
 * @author marc
 *
 */
@Entity
@Table(name="users")
public class User {
	
	//Class variables
	@Id
	private String email;
	private String password;
	private int type;
	
	//Getters and Setters
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
		return type;
	}
	public void setType(int type) {
		this.type = type;
	} 
}
