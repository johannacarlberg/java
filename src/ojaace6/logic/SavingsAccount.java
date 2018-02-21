package ojaace6.logic;

import java.util.ArrayList;

public class SavingsAccount extends Account 
{
	private String accountType;
	private double interestRate;
	private int creditLimit;
	private double balance = 0;
	ArrayList<String> accountTransactions = new ArrayList<String>();
	
	//todo  Uttag efter det första fria uttaget beläggs med en uttagsränta på 2% av uttaget belopp. 
	//Tar man ut 500 kr så dras 510 kr från kontot (eftersom 2% av 500 är 0.02*500).

	public String getAccountType() { return this.accountType; } 
	public double getInterestRate() { return this.interestRate; }   
	public double getCurrentInterest() { return balance * interestRate/100; }  
	public void setBalance(double newBalance) { balance += newBalance; }
	public double getBalance() { return balance; }   
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
