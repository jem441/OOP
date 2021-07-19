package com.example.services;

import java.util.List;

import com.example.dao.AccountDao;
import com.example.models.Account;
import com.example.models.AccountDisplay;
import com.example.models.User;

public class AccountService {

	private AccountDao aDao;
	
	public AccountService(AccountDao a) {
		this.aDao = a;
	}
	
	public void addAccount(int accountNumber, int wallId, double balance) {
		Account a = new Account(accountNumber, wallId, balance);
		aDao.createAccount(a);
	}
	
	public List<AccountDisplay> getAllAccounts() {
		return aDao.getAllAccounts();
	}
	
	public User loadUserAccounts(User u) {
		return aDao.getUsersAccounts(u);
	}
}
