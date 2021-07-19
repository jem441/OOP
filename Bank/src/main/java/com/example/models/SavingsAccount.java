package com.example.models;

public class SavingsAccount extends Account{

	private double interestRate;
	
	public SavingsAccount() {
		super();
	}
	
	public SavingsAccount(int accountNumber, int wallId, double interestRate) {
		super(accountNumber, wallId, interestRate);
		this.interestRate = interestRate;
	}
	
	public double getInterestRate() {
		return this.interestRate;
	}
	
	public void setInterestRate() {
		this.interestRate = interestRate;
		interestRate = 0.7;
	}
	
	public double calcInterest() {
		return balance * interestRate;
	}
	
	public void applyInterest() {
		double interest = calcInterest();
		System.out.printf("The interest amount %.2f added to the account balance%n", interest);
		deposit(interest);
	}
	
	public void deposit(double amount) {
		
		if(amount > 0) {
            balance += amount;
            System.out.printf("Amount %.2f deposited%n", amount);
            System.out.printf("Current Balance is: %.2f%n", balance);

        } else {
            System.out.println("A negative amount cannot be deposited");
        }
		
	}


	public void withdraw(double amount) {
		
		if (amount > 0) {
            if ((amount) <= balance) {
                System.out.printf("Amount of %.2f withdrawn from Account%n", amount);
                balance -= amount;
                System.out.printf("Current Balance is: %.2f%n", balance);
            }
        } else {
            System.out.println("Negative amount cannot be withdrawn!");
        }
		
	}

	
	
}
