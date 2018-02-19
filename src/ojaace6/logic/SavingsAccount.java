package ojaace6.logic;
/**
 * @author Johanna Carlberg, ojaace-6
 */
public class SavingsAccount {

	private double balance = 0;
	private double interestRate = 1.0;
	private String accountType = "Sparkonto";
	private int accountNumber;
	private static int lastAssignedNumber = 1000;

	public double getBalance() { return balance; }   
	public double getCurrentInterest() { return balance * interestRate/100; }  
	public double getInterestRate() { return interestRate; }    
	public void setBalance(double newBalance) { balance += newBalance; }
	public int getAccountNumber() { return accountNumber; }    
	public String getAccountType() { return accountType; }    

	public SavingsAccount()
	{
		lastAssignedNumber++;
		accountNumber = lastAssignedNumber;
	}
}
