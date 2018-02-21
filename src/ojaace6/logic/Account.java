package ojaace6.logic;

import java.util.ArrayList;

/**
 * @author Johanna Carlberg, ojaace-6
 */
public class Account {
	private int accountNumber;
	private static int lastAssignedNumber = 1000;
	
	public String getAccountType() { return this.getAccountType(); } 
	public double getBalance() { return this.getBalance(); }   
	public double getCurrentInterest() { return this.getCurrentInterest(); }  
	public double getInterestRate() { return this.getInterestRate(); }   
	public double getLoanInterestRate() { return this.getLoanInterestRate(); }   
	public double getCreditLimit() { return this.getCreditLimit(); }    
	public void setBalance(double newBalance) { this.setBalance(newBalance); }
	public int getAccountNumber() { return accountNumber; }   
	public ArrayList<String> getTransactions() { return this.getTransactions(); } 
	public void makeTransaction(String transaction) { this.makeTransaction(transaction); }

	public Account()
	{
		lastAssignedNumber++;
		accountNumber = lastAssignedNumber;
		
	}
}
