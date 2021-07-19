package com.example.models;

import java.util.List;

public class Account {

	private int accountNumber;
	private int wallUserId;
	protected double balance;
	
	public Account() {
		
	}
	
	public Account(int accountNumber, int wallUserId, double balance) {
		this.accountNumber = accountNumber;
		this.wallUserId = wallUserId;
		balance = 0;
		this.balance = balance;
	}
	
	public Account(int wallUserId, double balance) {
		this.wallUserId = wallUserId;
		this.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getWallUserId() {
		return wallUserId;
	}

	public void setWallUserId(int wallUserId) {
		this.wallUserId = wallUserId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", wallUserId=" + wallUserId
				+ ", balance=" + balance + "]";
	}


}
