package ojaace6.logic;

public class CreditAccount extends Account
{
	private String accountType;
	private int creditLimit;
	private double interestRate;
	private double balance = 0;
	
	public String getAccountType() { return this.accountType; } 
	public double getInterestRate() { return this.interestRate; }    
	//todo tis, this is not right
	public double getCurrentInterest() { return balance * interestRate/50; }  
	public void setBalance(double newBalance) { balance += newBalance; }
	public double getBalance() { return balance; }   

	
	public CreditAccount() 
	{
		this.accountType = "Kreditkonto";
		this.interestRate = 0.5;
		this.creditLimit = 0;
	}
}
