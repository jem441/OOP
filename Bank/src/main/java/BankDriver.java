import java.util.List;
import java.util.Scanner;


import com.example.dao.UserDao;
import com.example.dao.UserDaoDB;
import com.example.models.AccountDisplay;
import com.example.models.User;
import com.example.services.UserService;
import com.example.services.AccountService;
import com.example.dao.AccountDao;
import com.example.dao.AccountDaoDB;

public class BankDriver {

	private static AccountDao aDao = new AccountDaoDB();
	private static UserDao uDao = new UserDaoDB();
	private static UserService uServ = new UserService(uDao);
	private static AccountService aServ = new AccountService(aDao);
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		User u = null;
		boolean done = false;

		UserDao uDao = new UserDaoDB();
		UserService uServ = new UserService(uDao);
		AccountService aServ = new AccountService(aDao);
		
		System.out.println("Welcome to JMBanking, as a user you can either log in or sign up.");
		
		while (!done) {
			if(u == null) {
				System.out.println("Enter 1 to Login or enter 2 to Signup.");
				int choice = Integer.parseInt(scan.nextLine());
				if(choice == 1) {
					System.out.println("Please enter your username: ");
					String username = scan.nextLine();
					System.out.println("Please enter your password: ");
					String password = scan.nextLine();
					
					try {
						u = uServ.signIn(username, password);
						System.out.println("Welcome " + u.getFirstName() + " we are happy to have you today.");
					} catch(Exception e) {
						System.out.println("Your username or password was incorrect, please try again later.");
						done= true;
				}
			} else {
					System.out.println("Please enter your first name: ");
					String first = scan.nextLine();
					System.out.println("Please enter your last name: ");
					String last = scan.nextLine();
					System.out.println("Please enter your email: ");
					String email = scan.nextLine();
					System.out.println("Please enter your username: ");
					String username = scan.nextLine();
					System.out.println("Please enter a secure password: ");
					String password = scan.nextLine();
					
					try {
						u = uServ.signUp(first, last, email, username, password, u.getEclevel());
						System.out.println("You now have the login username of: " + u.getUsername());
					} catch (Exception e) {
						System.out.println("Sorry, we could not process your request");
						System.out.println("Please try again later");
						done = true;
					}
				}
		} else {
			if(u.getEclevel().equals("employee")) {
				System.out.println("As an employee, you can view your a customer checkings and savings account, view a transaction log, approve or deny a customer account, and log out.");
				int choice = Integer.parseInt(scan.nextLine());
			while(choice != 4) {
				System.out.println("Select an option from below: ");
				System.out.println("1- View a customers accounts");
				System.out.println("2- View a transaction log");
				System.out.println("3- Approve or deny customer account");
				System.out.println("4- Log out");
				
				switch(choice) {
				case 1: 
				{
					System.out.println("Which customer account would you like to look at?");
					System.out.println("Enter a customer username: ");
					String cuser = scan.nextLine();
					List<AccountDisplay> accounts = aServ.getAllAccounts();
					for(AccountDisplay account: accounts) {
						System.out.println(account.getUsername().contains(cuser));
						System.out.println(account.getBalance());
						System.out.println();
					}
				} break;
				case 2:
				{
					
				}
				}
			}
			System.out.println("To view your customer checking account press 1, to view your savings account press 2");
			//If the user chooses 1, we will show them the list of posts
			if(choice == 1) {
				List<AccountDisplay> accounts = aServ.getAllAccounts();
				for(AccountDisplay account: accounts) {
					System.out.println(account.getUsername() + ":");
					System.out.println(account.getBalance());
					System.out.println();
				}
				System.out.println("Are you finished? Press 1 for yes, press 2 for no");
				choice = Integer.parseInt(scan.nextLine());
				done = (choice == 1) ? true : false;
			} else {
				System.out.println("Please enter your content below:");
				String content = scan.nextLine();
				//pServ.addPost(u.getId(), u.getId(), content);
				System.out.println("Post was received, are you finished? Press 1 for yes, press 2 for no");
				choice = Integer.parseInt(scan.nextLine());
				done = (choice == 1) ? true : false;
			} 
		}
		}
		}
		System.out.println("Thank you for joining us today, goodbye.");
		scan.close();
	}
}