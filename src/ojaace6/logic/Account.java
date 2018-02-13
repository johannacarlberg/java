package ojaace6.logic;
/**
 * @author Johanna Carlberg, ojaace-6
 */
public class Account {

	private double balance = 0;
	private double interestRate;
	private int accountNumber;
	private static int lastAssignedNumber = 1000;
	private String accountType;
	public double getBalance() { return balance; }   
	public double getCurrentInterest() { return balance * interestRate/100; }  
	public double getInterestRate() { return interestRate; }    
	public void setBalance(double newBalance) { balance += newBalance; }
	public int getAccountNumber() { return accountNumber; }    
	public String getAccountType() { return accountType; }    

	public Account()
	{
		lastAssignedNumber++;
		accountNumber = lastAssignedNumber;
	}
	
	public class SavingsAccount extends Account 
	{
		private String accountType = "Sparkonto";
		private double interestRate = 1.0;
	}
	
	public class creditAccount extends Account 
	{
		private String accountType = "Kreditkonto";
		private int creditLimit = 0;
		private double interestRate = 0.5;
		
	}
}
