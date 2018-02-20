package ojaace6.logic;

import java.util.ArrayList;

/**
 * @author Johanna Carlberg, ojaace-6
 */
public class Customer {
	private String name;
	private String surname;
	private String pNo;
	//private ArrayList<Account> accounts = new ArrayList<Account>();
	private ArrayList<SavingsAccount> savingsAccounts = new ArrayList<SavingsAccount>();
	private ArrayList<CreditAccount> creditAccounts = new ArrayList<CreditAccount>();
	
	public String getName() { return name; }  
	public void setName(String newName, String newSurname) { name = newName; surname = newSurname; }
	public String getSurname() { return surname; }  
	public ArrayList<SavingsAccount> getSavingsAccounts() { return savingsAccounts; }  
	public ArrayList<CreditAccount> getCreditAccounts() { return creditAccounts; }  

	public int createSavingsAccount() 
	{ 
		Account savingsAccount;
		savingsAccounts.add((SavingsAccount) (savingsAccount = new SavingsAccount())); 
		System.out.println(((SavingsAccount) savingsAccount ).getAccountType());
		return savingsAccount.getAccountNumber();
	}
	
//	public int createAccount() 
//	{ 
//		Account account;
//		accounts.add(account = new Account()); 
//		return account.getAccountNumber();
//	}
//	
	public int createCreditAccount() 
	{ 
		Account creditAccount;
		creditAccounts.add((CreditAccount) (creditAccount = new CreditAccount())); 
		return creditAccount.getAccountNumber();
	}

	public String getPNo() { return pNo; }  
	public void setPNo(String newPNo) { pNo = newPNo; }

	public Customer(String name, String surname, String pNo)
	{
		this.name = name;
		this.surname = surname;
		this.pNo = pNo;
	}
}
