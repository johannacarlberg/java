package ojaace6.logic;

public class SavingsAccount extends Account 
{
	private String accountType;
	private double interestRate;
	
	public String getAccountType() { return this.accountType; } 
	public double getInterestRate() { return this.interestRate; }    
	
	public SavingsAccount() 
	{
		this.accountType = "Sparkonto";
		this.interestRate = 1.0;
	}
}
