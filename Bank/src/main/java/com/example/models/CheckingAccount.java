package com.example.models;

public class CheckingAccount extends Account{

	private static double FEE = 3.7;
	
	public CheckingAccount() {
	super();
	}
	
	public CheckingAccount(int accountNumber, int wallId, double fee) {
		super(accountNumber, wallId, fee);
		FEE = fee;
	}
	
	public void deposit(double amount) {
		if( amount > 0) {
            balance += amount;
            System.out.printf("Amount %.2f deposited%n", amount);
            
            balance -= FEE;
            System.out.printf("Fee %.2f Applied%n", FEE);
            System.out.printf("Current balance is: %.2f%n", balance);
            
		} else {
			System.out.println("A negative amount cannot be deposited");
		}
            
            
	}

	
	public void withdraw(double amount) {
		 if(amount > 0) {
	            if((amount+FEE) <= balance) {

	                System.out.printf("An amount of %.2f has been withdrawn from Account%n", amount);
	                balance -= amount;
	                balance -= FEE;
	                System.out.printf("A fee of %.2f applied%n", FEE);
	                System.out.printf("The current balance of the account is: %.2f%n", balance);
	            }
	        } else {
	            System.out.println("Negative amount cannot be withdrawn!");
	        }
	}
	
}
