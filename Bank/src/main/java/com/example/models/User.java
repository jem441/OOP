package com.example.models;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class User {

	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String password;
	private String eclevel;
	private List<Account> account;
	
	public User() {
		account = new ArrayList<Account>();
	}
	
	public User(int id, String firstName, String lastName, String email, String username, String password, String eclevel) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username; 
		this.password = password;
		this.eclevel = eclevel;
		this.account = new ArrayList<Account>();
	}

	public User(String firstName, String lastName, String email, String username, String password, String eclevel) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.eclevel = eclevel;
		this.account = new ArrayList<Account>();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
	
	public String getEclevel() {
		return eclevel;
	}

	public void setEclevel(String EcLevel) {
		this.eclevel = EcLevel;
	}

	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", email=" + email + ", password=" + password + ", eclevel=" + eclevel + ", accounts=" + account + "]";
	}
	
}
