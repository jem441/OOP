package com.example.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.example.models.Account;
import com.example.models.AccountDisplay;
import com.example.models.User;
import com.example.utils.ConnectionUtil;

public class AccountDaoDB implements AccountDao{
	
	private ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();

	@Override
	public void createAccount(Account a) {
		try {
			Connection con = conUtil.getConnection();
			con.setAutoCommit(false);
			String sql = "call create_account(?,?)";
			CallableStatement cs = con.prepareCall(sql);
			
			cs.setInt(1, a.getAccountNumber());
			cs.setDouble(2, a.getBalance());
			
			cs.execute();
			
			con.setAutoCommit(true);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<AccountDisplay> getAllAccounts() {
		List<AccountDisplay> aList = new ArrayList<AccountDisplay>();
		
		try {
			Connection con = conUtil.getConnection();
			con.setAutoCommit(false);
			String sql = "{?=call get_all_accounts()}";
			
			CallableStatement cs = con.prepareCall(sql);
					
			cs.registerOutParameter(1, Types.OTHER);
			
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			while(rs.next()) {
				AccountDisplay account = new AccountDisplay(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDouble(5));
				aList.add(account);
			}
			con.setAutoCommit(true);
			return aList;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUsersAccounts(User u) {
		List<Account> account = new ArrayList<Account>();
		try {
			Connection con = conUtil.getConnection();
			con.setAutoCommit(false);
			String sql = "{?=call get_user_accounts(?)}";
			
			CallableStatement cs = con.prepareCall(sql);
			
			cs.registerOutParameter(1, Types.OTHER);
			cs.setInt(2, u.getId());
			
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			while(rs.next()) {
				Account a = new Account(rs.getInt(1), rs.getInt(2), rs.getDouble(3));
				account.add(a);
			}
			u.setAccount(account);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
