package ojaace6.logic;

import java.util.ArrayList;

public class SavingsAccount extends Account 
{
	private String accountType;
	private double interestRate;
	private int creditLimit;
	private double balance = 0;
	ArrayList<String> accountTransactions = new ArrayList<String>();
	private int noOfwidthdraws = 0;

	public String getAccountType() { return this.accountType; } 
	public double getInterestRate() { return this.interestRate; }   
	public double getCurrentInterest() { return balance * interestRate/100; }  
	public void setBalance(double newBalance) { balance += newBalance; }
	public double getBalance() { return balance; }   
	public void setNoOfWithdraws() { noOfwidthdraws+=1; }
	public double getNoOfWithdraws() { return noOfwidthdraws; } 
	public ArrayList<String> getTransactions() { return accountTransactions; } 
	public void makeTransaction(String transaction) { accountTransactions.add(transaction); }
	public double getCreditLimit() { return creditLimit; }  
	
	public SavingsAccount() 
	{
		this.accountType = "Sparkonto";
		this.interestRate = 1.0;
		this.creditLimit = 0;
	}
}
