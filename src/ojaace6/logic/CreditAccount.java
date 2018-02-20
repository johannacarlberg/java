package ojaace6.logic;

public class CreditAccount extends Account
{
	private String accountType;
	private int creditLimit;
	private double interestRate;
	
	public String getAccountType() { return this.accountType; } 
	public double getInterestRate() { return this.interestRate; }    

	
	public CreditAccount() 
	{
		this.accountType = "Kreditkonto";
		this.interestRate = 0.5;
		this.creditLimit = 0;
	}
}
