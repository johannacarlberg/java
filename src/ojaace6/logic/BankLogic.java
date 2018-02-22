package ojaace6.logic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Johanna Carlberg, ojaace-6
 */
public class BankLogic {
	ArrayList<Customer> allCustomers = new ArrayList<Customer>();

	/**
	 * Funktionen getAllCustomersDb returnerar en arraylist med alla kunder i
	 * banken
	 */
	public ArrayList<Customer> getAllCustomersDb() 
	{
		return allCustomers;
	}

	/**
	 * Funktionen getAllCustomers skapar en array lista med alla kunde,
	 * information om kunderna samt deras konton
	 */
	public ArrayList<String> getAllCustomers() 
	{
		ArrayList<String> listOfAllCustomers = new ArrayList<String>();
		for (int i = 0; i < allCustomers.size(); i++)
			listOfAllCustomers.add(allCustomers.get(i).getName() + " " + allCustomers.get(i).getSurname() + " "
					+ allCustomers.get(i).getPNo());
		return listOfAllCustomers;
	}

	/**
	 * Funktionen createCustomer skapr en ny kund om personnumret inte redan
	 * finns registrerat, Funktionen returnerar ett boolean värde som är true om
	 * kunden skapats och false om ingen kund skapades
	 */
	public boolean createCustomer(String name, String surname, String pNo) 
	{
		boolean result = false;
		if (getAllCustomersDb().size() < 1) 
		{
			Customer customer = new Customer(name, surname, pNo);
			addCustomerToList(customer);
			result = true;
		} else {
			for (int i = 0; i < getAllCustomersDb().size(); i++) 
			{
				if (!getAllCustomersDb().get(i).getPNo().equals(pNo)) 
				{
					Customer customer = new Customer(name, surname, pNo);
					addCustomerToList(customer);
					result = true;
				}
				break;
			}
		}
		return result;
	}

	/**
	 * Funktionen addCustomerToList lagger till alla nya kunder till en array
	 * som heter allCustomers
	 */
	private void addCustomerToList(Customer customer) 
	{
		allCustomers.add(customer);
	}

	/**
	 * Funktionen getCustomer tar argumentet pNo, om kund finns med inmatade
	 * personnumret laggs kundens information in i en arrayList som sen
	 * returneras. Om kund med matchande pNo inte hittas returneras null
	 */
	public ArrayList<String> getCustomer(String pNo) 
	{
		ArrayList<String> customerInfo = new ArrayList<String>();
		Customer selectedCustomer;
		Account selectedAccount;
		double interest;
		// CreditAccount selectedCreditAccount;
		for (int i = 0; i < getAllCustomersDb().size(); i++) 
		{
			if (getAllCustomersDb().get(i).getPNo().equals(pNo)) 
			{
				selectedCustomer = getAllCustomersDb().get(i);
				customerInfo.add(selectedCustomer.getName() + " " + selectedCustomer.getSurname() + " "
						+ selectedCustomer.getPNo());
				if (selectedCustomer.getAccounts().size() > 0) 
				{
					for (int a = 0; a < selectedCustomer.getAccounts().size(); a++) 
					{
						selectedAccount = selectedCustomer.getAccounts().get(a);
						if (selectedAccount.getBalance() < 0) 
						{
							interest = selectedAccount.getLoanInterestRate();
						} else {
							interest = selectedAccount.getInterestRate();
						}
						customerInfo.add(selectedAccount.getAccountNumber() + " " + selectedAccount.getBalance() + " "
								+ selectedAccount.getAccountType() + " " + interest);
					}
				}

				break;
			}
		}
		ArrayList<String> value = (customerInfo.size() > 0) ? customerInfo : null;
		return value;
	}

	/**
	 * Funktionen changeCustomerName kallas med 3 argument, namn, efternamn och
	 * pNo. Om pNo finns uppdateras namnet och efternamnet på kunden i fråga.
	 * funktionen returnerar true om kunden hittats och false annars
	 */
	public boolean changeCustomerName(String name, String surname, String pNo) 
	{
		boolean found = false;
		for (int i = 0; i < getAllCustomersDb().size(); i++) {
			if (getAllCustomersDb().get(i).getPNo().equals(pNo)) {
				getAllCustomersDb().get(i).setName(name, surname);
				found = true;
				break;
			}
		}
		return found;
	}

	/**
	 * Funktionen deleteCustomer gar igenom alla kunder for att hitta kunden som
	 * matchar det inmatade personnumret. Informationen om kunden läggs in i en
	 * ArrayList String som heter customerInfo. Sedan tas kunden bort och
	 * funktionen returnerar info om den borttagna kunden. Hittas ingen kund
	 * returneras null
	 */
	public ArrayList<String> deleteCustomer(String pNo) 
	{
		ArrayList<String> customerInfo = new ArrayList<String>();
		Customer selectedCustomer;
		Account selectedAccount;
		double interest;
		double currentInterest;
		for (int i = 0; i < getAllCustomersDb().size(); i++) 
		{
			if (getAllCustomersDb().get(i).getPNo().equals(pNo)) 
			{
				selectedCustomer = getAllCustomersDb().get(i);
				customerInfo.add(selectedCustomer.getName() + " " + selectedCustomer.getSurname() + " "
						+ selectedCustomer.getPNo());
				for (int a = 0; a < selectedCustomer.getAccounts().size(); a++) 
				{
					selectedAccount = selectedCustomer.getAccounts().get(a);
					if (selectedAccount.getBalance() < 0) 
					{
						interest = selectedAccount.getLoanInterestRate();
						currentInterest = selectedAccount.getCurrentLoanInterest();
					} else {
						interest = selectedAccount.getInterestRate();
						currentInterest = selectedAccount.getCurrentInterest();
					}
					customerInfo.add(selectedAccount.getAccountNumber() + " " + selectedAccount.getBalance() + " "
							+ selectedAccount.getAccountType() + " " + interest + " " + currentInterest);
				}
				getAllCustomersDb().remove(i);
				break;
			}
		}
		ArrayList<String> value = (customerInfo.size() > 0) ? customerInfo : null;
		return value;
	}

	/**
	 * Funktionen createSavingsAccount skapar ett nytt sparkonto till den valda
	 * kunden Om kunden inte hittades returneras -1 annars returneras
	 * kontonumret till nya kontot
	 */
	public int createSavingsAccount(String pNo) 
	{
		Customer selectedCustomer;
		int accountNo = -1;
		for (int i = 0; i < getAllCustomersDb().size(); i++) 
		{
			if (getAllCustomersDb().get(i).getPNo().equals(pNo)) 
			{
				selectedCustomer = getAllCustomersDb().get(i);
				accountNo = selectedCustomer.createSavingsAccount();
				break;
			}
		}
		return accountNo;
	}

	/**
	 * Funktionen getAccount far tva argument, personnummer och kontonummer. Den
	 * går igenom kunderna tills den hittar rätt kund. Därefter går den igenom
	 * kontona som tillhör kunden för att hitta rätt konto. kontoinfromationen
	 * läggs ihop i en string. Om kunden eller kontot inte hittas returneras
	 * null
	 */
	public String getAccount(String pNo, int accountId) 
	{
		Customer selectedCustomer;
		Account selectedAccount;
		String information = "";
		for (int i = 0; i < getAllCustomersDb().size(); i++) 
		{
			if (getAllCustomersDb().get(i).getPNo().equals(pNo)) 
			{
				selectedCustomer = getAllCustomersDb().get(i);
				for (int a = 0; a < selectedCustomer.getAccounts().size(); a++) 
				{
					if (selectedCustomer.getAccounts().get(a).getAccountNumber() == accountId) 
					{
						selectedAccount = selectedCustomer.getAccounts().get(a);
						information = selectedAccount.getAccountNumber() + " " + selectedAccount.getBalance() + " "
								+ selectedAccount.getAccountType() + " " + selectedAccount.getInterestRate();
						break;
					}
				}
				break;
			}
		}
		String value = (information.length() > 0) ? information : null;
		return value;
	}

	/**
	 * Funktionen deposit får tre argument, personnummer, kontonummer och summa
	 * Den går igenom kunderna tills den hittar rätt kund. Därefter går den
	 * igenom kontona som tillhör kunden för att hitta rätt konto. När rött
	 * konto hittats kallas setAmount, vilket adderar summan på befintliga
	 * saldot. Om depositionen görs returneras true, annars returneras false.
	 */
	public boolean deposit(String pNo, int accountId, double amount) 
	{
		Customer selectedCustomer;
		Account selectedAccount;
		boolean depositMade = false;
		String transaction;

		for (int i = 0; i < getAllCustomersDb().size(); i++) 
		{
			if (getAllCustomersDb().get(i).getPNo().equals(pNo)) 
			{
				selectedCustomer = getAllCustomersDb().get(i);
				for (int a = 0; a < selectedCustomer.getAccounts().size(); a++) 
				{
					if (selectedCustomer.getAccounts().get(a).getAccountNumber() == accountId) 
					{
						selectedAccount = selectedCustomer.getAccounts().get(a);
						selectedAccount.setBalance(amount);
						Date myDate = new Date();
						SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
						String date = DATE_FORMAT.format(myDate);
						transaction = date + " " + amount + " " + selectedAccount.getBalance();
						selectedAccount.makeTransaction(transaction);
						depositMade = true;
						break;
					}
				}
				break;
			}
		}
		return depositMade;
	}

	/**
	 * Funktionen withdraw får tre argument, personnummer, kontonummer och summa
	 * Den går igenom kunderna tills den hittar rätt kund. Därefter går den
	 * igenom kontona som tillhör kunden för att hitta rätt konto. När rött
	 * konto hittats kollar funktionen om det finns en högre summan på kontot än
	 * vad uttaget är på isåfall görs uttaget genom att kalla funktionen
	 * setAmount, vilket tar bort summan från befintliga saldot. Om uttaget görs
	 * returneras true, annars returneras false.
	 */
	public boolean withdraw(String pNo, int accountId, double amount) 
	{
		//todo rector this it is horrible
		Customer selectedCustomer;
		Account selectedAccount;
		boolean withdrawn = false;
		String transaction;
		
		for (int i = 0; i < getAllCustomersDb().size(); i++) 
		{
			if (getAllCustomersDb().get(i).getPNo().equals(pNo)) 
			{
				selectedCustomer = getAllCustomersDb().get(i);
				for (int a = 0; a < selectedCustomer.getAccounts().size(); a++) 
				{
					if (selectedCustomer.getAccounts().get(a).getAccountNumber() == accountId) 
					{
						selectedAccount = selectedCustomer.getAccounts().get(a);
						if (selectedAccount.getAccountType().equals("Sparkonto")) 
						{
							amount = (selectedAccount.getNoOfWithdraws() >= 1) ? amount * 1.02 : amount;
						
							if (selectedAccount.getBalance() - amount >= selectedAccount.getCreditLimit()) 
							{
								Date myDate = new Date();
								SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
								String date = DATE_FORMAT.format(myDate);

								selectedAccount.setBalance(-amount);
								transaction = date + " -" + amount + " " + selectedAccount.getBalance();
								selectedAccount.makeTransaction(transaction);
								selectedAccount.setNoOfWithdraws();
								withdrawn = true;
								break;

							}
						} else if (selectedAccount.getAccountType().equals("Kreditkonto")) 
						{
							if (selectedAccount.getBalance() - amount >= selectedAccount.getCreditLimit()) 
							{
								selectedAccount.setBalance(-amount);
								Date myDate = new Date();
								SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
								String date = DATE_FORMAT.format(myDate);
								transaction = date + " -" + amount + " " + selectedAccount.getBalance();
								selectedAccount.makeTransaction(transaction);
								withdrawn = true;
								break;
							}
						}
						break;
					}
				}
				break;
			}
		}
		return withdrawn;
	}

	/**
	 * Funktionen closeAccount får två argument, personnummer och kontonummer
	 * Den går igenom kunderna tills den hittar rätt kund. Därefter går den
	 * igenom kontona som tillhör kunden för att hitta rätt konto. När rätt
	 * konto hittats plockas information fram om kontot och bildar en string.
	 * därefter tas kontot bort. om kontot inte hittas returneras null.
	 */
	public String closeAccount(String pNr, int accountId) 
	{
		Customer selectedCustomer;
		Account selectedAccount;
		String information = "";
		double interest;
		double currentInterest;
		
		for (int i = 0; i < getAllCustomersDb().size(); i++) 
		{
			if (getAllCustomersDb().get(i).getPNo().equals(pNr)) 
			{
				selectedCustomer = getAllCustomersDb().get(i);
				for (int a = 0; a < selectedCustomer.getAccounts().size(); a++) 
				{
					if (selectedCustomer.getAccounts().get(a).getAccountNumber() == accountId) 
					{
						selectedAccount = selectedCustomer.getAccounts().get(a);
						if (selectedAccount.getBalance() < 0) 
						{
							interest = selectedAccount.getLoanInterestRate();
							currentInterest = selectedAccount.getCurrentLoanInterest();
						} else {
							interest = selectedAccount.getInterestRate();
							currentInterest = selectedAccount.getCurrentInterest();
						}
					
						information = selectedAccount.getAccountNumber() + " " + selectedAccount.getBalance() + " "
								+ selectedAccount.getAccountType() + " " + interest + " "
								+ currentInterest;
						selectedCustomer.getAccounts().remove(a);
						break;
					}
				}
			}
		}
		String value = (information.length() > 0) ? information : null;
		return value;
	}

	public int createCreditAccount(String pNr) 
	{
		Customer selectedCustomer;
		int accountNo = -1;
		for (int i = 0; i < getAllCustomersDb().size(); i++) 
		{
			if (getAllCustomersDb().get(i).getPNo().equals(pNr)) 
			{
				selectedCustomer = getAllCustomersDb().get(i);
				accountNo = selectedCustomer.createCreditAccount();
				break;
			}
		}
		return accountNo;
	}

	public ArrayList<String> getTransactions(String pNr, int accountId) 
	{
		ArrayList<String> transactions = new ArrayList<String>();
		Customer selectedCustomer;
		Account selectedAccount;
		for (int i = 0; i < getAllCustomersDb().size(); i++) 
		{
			if (getAllCustomersDb().get(i).getPNo().equals(pNr)) 
			{
				selectedCustomer = getAllCustomersDb().get(i);
				if (selectedCustomer.getAccounts().size() > 0) 
				{
					for (int a = 0; a < selectedCustomer.getAccounts().size(); a++) 
					{
						if (selectedCustomer.getAccounts().get(a).getAccountNumber() == accountId) 
						{
							selectedAccount = selectedCustomer.getAccounts().get(a);
							selectedAccount.getTransactions();
							transactions = selectedAccount.getTransactions();
						}
					}
				}
				break;
			}
		}
		ArrayList<String> transactionList = (transactions.size() > 0) ? transactions : null;
		return transactionList;
	}
}
