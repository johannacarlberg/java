package ojaace6.logic;

import java.util.ArrayList;

public class SavingsAccount extends Account 
{
	private String accountType;
	private double interestRate;
	private double balance = 0;
	
	public String getAccountType() { return this.accountType; } 
	public double getInterestRate() { return this.interestRate; }   
	public double getCurrentInterest() { return balance * interestRate/100; }  
	public void setBalance(double newBalance) { balance += newBalance; }
	public double getBalance() { return balance; }   
	ArrayList<String> accountTransactions = new ArrayList<String>();
	public ArrayList<String> getTransactions() { return accountTransactions; } 
	public void makeTransaction(String transaction) { accountTransactions.add(transaction); }
	
	public SavingsAccount() 
	{
		this.accountType = "Sparkonto";
		this.interestRate = 1.0;
	}
}
