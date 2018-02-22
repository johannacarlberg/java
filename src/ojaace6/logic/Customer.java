package ojaace6.logic;

import java.util.ArrayList;

/**
 * @author Johanna Carlberg, ojaace-6
 */
public class Customer {
	private String name;
	private String surname;
	private String pNo;
	private ArrayList<Account> accounts = new ArrayList<Account>();

	public String getName() { return name; }  
	public void setName(String newName, String newSurname) { name = newName; surname = newSurname; }
	public String getSurname() { return surname; }  
	public ArrayList<Account> getAccounts() { return accounts; } 
	public String getPNo() { return pNo; }  
	public void setPNo(String newPNo) { pNo = newPNo; }

	public int createSavingsAccount() 
	{ 
		Account savingsAccount;
		accounts.add((SavingsAccount) (savingsAccount = new SavingsAccount())); 
		System.out.println(((SavingsAccount) savingsAccount ).getAccountType());
		return savingsAccount.getAccountNumber();
	}
	
	public int createCreditAccount() 
	{ 
		Account creditAccount;
		accounts.add((CreditAccount) (creditAccount = new CreditAccount())); 
		return creditAccount.getAccountNumber();
	}

	public Customer(String name, String surname, String pNo)
	{
		this.name = name;
		this.surname = surname;
		this.pNo = pNo;
	}
}
