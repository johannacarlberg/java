package ojaace6.logic;
/**
 * @author Johanna Carlberg, ojaace-6
 */
public class Account {

	//private double balance = 0;
	//private double interestRate;
	private int accountNumber;
	private static int lastAssignedNumber = 1000;
	//private String accountType = null;
	public String getAccountType() { return this.getAccountType(); } 

	public double getBalance() { return this.getBalance(); }   
	public double getCurrentInterest() { return this.getCurrentInterest(); }  
	public double getInterestRate() { return this.getInterestRate(); }    
	public void setBalance(double newBalance) { this.setBalance(newBalance); }
	public int getAccountNumber() { return accountNumber; }       

	public Account()
	{
		lastAssignedNumber++;
		accountNumber = lastAssignedNumber;
		
	}
//	
//	public class SavingsAccount extends Account 
//	{
//		private String accountType = "Sparkonto";
//		private double interestRate = 1.0;
//		
//	}
	
//	public class CreditAccount extends Account 
//	{
//		private String accountType = "Kreditkonto";
//		private int creditLimit = 0;
//		private double interestRate = 0.5;
//		
//		//public String getAccountType() { return accountType; } 
//	}
}
