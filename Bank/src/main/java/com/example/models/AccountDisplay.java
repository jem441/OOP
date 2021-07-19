package com.example.models;

public class AccountDisplay {

	private String username;
	private int accountNumber;
	private int authorId;
	private int wallId;
	private double balance;
	
	public AccountDisplay() {
		super();
	}
	
	public AccountDisplay(String username, int accountNumber, int authorId, int wallId, double balance) {
		super();
		this.username = username;
		this.accountNumber = accountNumber;
		this.authorId = authorId;
		this.wallId = wallId;
		this.balance = balance;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getWallId() {
		return wallId;
	}

	public void setWallId(int wallId) {
		this.wallId = wallId;
	}

	public double getBalance() {
		balance = 0;
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "AccountDisplay [username=" + username + ", accountNumber=" + accountNumber + ", authorId=" + authorId
				+ ", wallId=" + wallId + ", balance=" + balance + "]";
	}



	
	
}
