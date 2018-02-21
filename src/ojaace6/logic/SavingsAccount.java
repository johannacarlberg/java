package ojaace6.logic;

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

	
	public SavingsAccount() 
	{
		this.accountType = "Sparkonto";
		this.interestRate = 1.0;
	}
}
