package com.example.userTests;

import com.example.dao.UserDao;
import com.example.exceptions.InvalidCredentialsException;
import com.example.exceptions.UserDoesNotExistException;
import com.example.models.User;
import com.example.services.UserService;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UserServiceTest {

	@InjectMocks
	public UserService uServ;
	
	@Mock
	public UserDao uDao;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testValidLogin() throws UserDoesNotExistException, InvalidCredentialsException {
		User u1 = new User("test", "user", "test@mail.com", "testusername", "testpass", "customer");
		User not = new User(1, "test", "user", "tuser@mail.com","testusername", "testpass", "customer");
		
		when(uDao.getUserByUsername(anyString())).thenReturn(u1);
		
		User loggedIn = uServ.signIn("testusername", "testpass");
		
		assertEquals(u1.getId(), loggedIn.getId());
	}
	
	@Test(expected = UserDoesNotExistException.class)
	public void testInvalidUsername() throws UserDoesNotExistException, InvalidCredentialsException {
		User u1 = new User("test", "user", "test@mail.com", "testusername", "testpass", "customer");
		User not = new User(1, "test", "user", "tuser@mail.com", "testusername" , "testpass", "customer");
		
		when(uDao.getUserByUsername(anyString())).thenReturn(not);
		
		User loggedIn = uServ.signIn("testusername", "testpass");
	}
	
	@Test(expected = InvalidCredentialsException.class)
	public void testInvalidPassword() throws UserDoesNotExistException, InvalidCredentialsException {
		User u1 = new User(1, "test", "user", "testuser", "testusername" , "test@mail.com", "testpass");
		User not = new User(0, "test", "user", "testuser", "testusername" , "tuser@mail.com", "testpass");
		
		when(uDao.getUserByUsername(anyString())).thenReturn(not);
		
		User loggedIn = uServ.signIn("testusername", "testpass");
	}
}
