package ojaace6.logic;

import java.util.ArrayList;
import java.util.Scanner; 

/**
 * Inlämningsuppgift 2 - Fiktiv Bank
 * Ett enkelt system för en fiktiv bank.
 * @author Johanna Carlberg, ojaace-6
 */
public class Uppgift2 {
	private static Scanner in = new Scanner(System.in);

	/**
	 * Funktionen main skapar ett nytt bank Objekt så att vi kan kalla 
	 * funkationerna i BankLogic.java filen. Den kallar sen selectMenu() funktionen
	 * med bank objektet som argument
	 */
	public static void main(String[] args)
	{
		BankLogic bank = new BankLogic();
		selectMenu(bank);
	}

	/**
	 * Funktionen selectMenu presenterar en lista dar anvandaren kan valja nummer 
	 * 1 till 10. Beroende på vilket nummer användaren matar in kallas respektive 
	 * funktion. 
	 */
	public static void selectMenu(BankLogic bank) 
	{
		System.out.println("\n1. Kundlista \n2. Ny Kund \n3. Information om kund \n4. Uppdatera kundnamn \n5. Ta bort kund \n6. Skapa sparkonto \n7. Hamta sparkonto \n8. Gor insattning \n9. Ta ut pengar \n10. Avsluta konto \n11. Skapa Kreditkonto \n12. Se transaktionslista \n13. Avsluta \nDitt val:");
		int choiceentry = in.nextInt();

		switch (choiceentry) {
		case 1:
			getAllCustomers(bank);
			break;
		case 2:
			createCustomer(bank);
			break;
		case 3:
			getCustomerInfo(bank); 
			break;
		case 4:
			changeCustomerName(bank);
			break;
		case 5:
			deleteCustomer(bank);
			break;
		case 6:
			createSavingsAccount(bank);
			break;
		case 7:
			getAccount(bank);
			break;
		case 8:
			makeDeposit(bank);
			break;
		case 9:
			withdrawMoney(bank);
			break;
		case 10:
			closeAccount(bank);
			break;
		case 11:
			createCreditAccount(bank);
			break;
		case 12:
			getTransactions(bank);
			break;
		default: 
			System.out.println("Enter \"1\", \"2\", \"3\", \"4\", \"5\", \"6\", \"7\", \"8\", \"9\", \"10\", \"11\" or \"12\"");
			choiceentry = in.nextInt();
		}
	}

	/**
	*Funktionen getAllCustomers kallar funktionen bank.getAllCustomers() och skapar
	*en arraylista med alla kunder som visas upp till anvandaren.
	*/
	public static void getAllCustomers(BankLogic bank) 
	{
		ArrayList<String> allCustomers = bank.getAllCustomers();
		System.out.println(allCustomers);
		selectMenu(bank);
	}

	/**
	 * Funktionen createCustomer ber användaren skriva i förnamn, efternamn
	 * samt personnummer på nya kunden. sedan kallas funktionen bank.createCustomer
	 * med dessa 3 argument. om en kund skapas returneras värdet true, annars returneras
	 * värdet false
	 * 
	 */
	public static void createCustomer(BankLogic bank) 
	{
		System.out.println("Namn på ny kund?");
		String name = in.next();
		System.out.println("Efternamn på ny kund?");
		String surname = in.next();
		System.out.println("Kundens Personnummer?");
		String pNo = in.next();
		boolean created = bank.createCustomer(name, surname, pNo);
		if(created == true)
		{
			System.out.println("Ny kund har skapats");
		} else {
			System.out.println("Personnummret finns redan tillagt");  
		}
		selectMenu(bank);
	}
	
	/**
	 * Funktionen getCustomerInfo ber användaren skriva in sitt personnummer
	 * sen kallas funktionen bank.getCustomer med argumentet personnummer
	 * om kunden finns presenteras information om kunden i en string, är värdet
	 * null skrivs felmeddelande ut
	 */
	public static void getCustomerInfo(BankLogic bank) 
	{
		System.out.println("Personnummer?");
		String pNo = in.next();
		ArrayList<String> customerInfo = bank.getCustomer(pNo);
		if(customerInfo == null)
		{
			System.out.println("Ingen kund hittades med det personnumret");
		} else {
			System.out.println(customerInfo);
		}
		selectMenu(bank);
	}

	/**
	 * Funktionen changeCustomerName ber användaren skriva in sitt personnummer
	 * sen får kunden skriva i sitt nya förnamn och nya efternamn. därefter
	 * kallas funktionen bank.changeCustomerName med de 3 argumenten. Om kundens
	 * information uppdateras returneras true, annars returneras false och ett 
	 * felmeddelande skrivs ut
	 */
	public static void changeCustomerName(BankLogic bank) 
	{
		System.out.println("Vad är ditt personnummer?");
		String pNo = in.next();
		System.out.println("Nytt Namn?");
		String newName = in.next();
		System.out.println("Nytt Efternamn?");
		String newSurname = in.next();
		boolean changed = bank.changeCustomerName(newName, newSurname, pNo);
		if(changed == true)
		{
			System.out.println("Namnet har uppdaterats"); 
		} else {
			System.out.println("Hittade ingen kund med det personnumret"); 
		}
		selectMenu(bank);
	}

	/** Funktionen deleteCustomer ber användaren skriva in sitt personnummer
	 * Om kunden hittas raderas den och customerInfo visar upp en arrayList med
	 * kontots stängningsinformation. Om kunden inte hittas visas ett felmeddelande
	 */
	public static void deleteCustomer(BankLogic bank) 
	{
		System.out.println("Vad är ditt personnummer?");
		String pNo = in.next();
		ArrayList<String> customerInfo = bank.deleteCustomer(pNo);
		if(customerInfo == null)
		{
			System.out.println("Ingen kunde hittades med det personnumret");
		} else {
			System.out.println(customerInfo); 
		}
		selectMenu(bank);
	}

	/**
	* Funktionen createSavingsAccount ber användaren skriva in sitt personnummer
	* sen kallas funktionen bank.createSavingsAccount med personnummret som argument
	* Om kontonumret returneras skrivs det ut, annars visas ett felmeddelande upp
	*/
	public static void createSavingsAccount(BankLogic bank)
	{
		System.out.println("Vad är ditt personnummer?");
		String pNo = in.next();
		int accountNo = bank.createSavingsAccount(pNo);
		if(accountNo < 0)
		{
			System.out.println("Inget nytt konto skapades");				  
		} else {
			System.out.println("Nytt sparkonto skapats: " + accountNo);				  
		}
		selectMenu(bank);
	}

	/**
	* Funktionen getAccount ber användaren skriva in sitt personnummer och kontonummer
	* en kallas funktionen bank.getAccount med personnummret och kontonumret som argument
	* Om kontoinformationen returneras skrivs det ut, annars visas ett felmeddelande upp
	*/
	public static void getAccount(BankLogic bank)
	{
		System.out.println("Vad är ditt personnummer?");
		String pNo = in.next();
		System.out.println("Vad är ditt kontonummer?");
		int accountNo = in.nextInt();
		String accountInfo = bank.getAccount(pNo, accountNo);
		if(accountInfo == null)
		{
			System.out.println("Kan inte hitta kund och/eller konto");
		} else {
			System.out.println(accountInfo);
		}
		selectMenu(bank);
	}

	/**
	*Funktionen makeDeposit ber användaren skriva in sitt personnummer och kontonummer
	*sen ber den om insättningssumma. och då kallas funktionen bank.deposit med dessa 3 argument
	*Om true returneras skrivs det ut att insättning genomförts, annars visas ett felmeddelande upp
	*/
	public static void makeDeposit(BankLogic bank)
	{
		System.out.println("Var är ditt personnummer?");
		String pNo = in.next();
		System.out.println("Var är ditt kontonummer?");
		int accountNo = in.nextInt();
		System.out.println("Hur mycket vill du sätta in?");
		double amount = in.nextInt();
		boolean deposit = bank.deposit(pNo, accountNo, amount);
		if(deposit == true)
		{
			System.out.println("Pengarna har nu satts in på kontot");  
		} else {
			System.out.println("Insättningen misslyckades");
		}
		selectMenu(bank);
	}

	/**
	* Funktionen withdrawMoney ber användaren skriva in sitt personnummer och kontonummer
	* sen ber den om uttagsssumma. och då kallas funktionen bank.withdraw med dessa 3 argument
	* Om true returneras skrivs det ut att uttaget genomförts, annars visas ett felmeddelande upp
	*/
	public static void withdrawMoney(BankLogic bank)
	{
		
		System.out.println("Vad är ditt personnummer?");
		String pNo = in.next();
		System.out.println("Vad är ditt kontonummer?");
		int accountNo = in.nextInt();
		System.out.println("Hur mycket vill du ta ut?");
		double amount = in.nextInt();
		boolean withdraw = bank.withdraw(pNo, accountNo, amount);
		if(withdraw == true)
		{
			System.out.println("Pengarna har nu tagits ut från kontot");  
		} else {
			System.out.println("Uttag misslyckades");
		}
		selectMenu(bank);
	}

	/**
	* Funktionen closeAccount ber användaren skriva in sitt personnummer och kontonummer
	* på kontot den vill avsluta. sen kallas funktionen bank.closeAccount med dessa 2 argument
	* Om en string med kontoinformationen returneras skrivs det ut, annars visas ett felmeddelande upp
	*/
	public static void closeAccount(BankLogic bank)
	{
		System.out.println("Vad är ditt personnummer?");
		String pNo = in.next();
		System.out.println("Vilket kontonummer vill du avsluta?");
		int accountNo = in.nextInt();
		String accountInfo = bank.closeAccount(pNo, accountNo);
		if(accountInfo == null)
		{
			System.out.println("Kan inte hitta kund och/eller konto");
		} else {
			System.out.println(accountInfo);
		}
		selectMenu(bank);
	}
	
	/**
	* Funktionen createCreditAccount ber användaren skriva in sitt personnummer.
	* sen kallas funktionen bank.createCreditAccount med detta argument
	* Om en int med kontonumret returneras skrivs det ut, annars visas ett felmeddelande upp
	*/
	public static void createCreditAccount(BankLogic bank)
	{
		System.out.println("Vad är ditt personnummer?");
		String pNo = in.next();
		int accountNo = bank.createCreditAccount(pNo);
		if(accountNo < 0)
		{
			System.out.println("Inget nytt konto skapades");				  
		} else {
			System.out.println("Nytt kreditkonto skapats: " + accountNo);				  
		}
		selectMenu(bank);
	}
	
	/**
	* Funktionen getTransactions ber användaren skriva in sitt personnummer och kontonummer.
	* sen kallas funktionen bank.getTransactions med dessa två argument
	* Om värdet som returneras är null visas ett felmeddelande upp, annars visas en lista med
	* de gjorda transaktionerna
	*/
	public static void getTransactions(BankLogic bank)
	{
		System.out.println("Vad är ditt personnummer?");
		String pNo = in.next();
		System.out.println("Vilket kontonummer?");
		int accountNo = in.nextInt();
		ArrayList<String> transactions = bank.getTransactions(pNo, accountNo);
		if(transactions == null)
		{
			System.out.println("Finns inga transaktioner for detta konto");				  
		} else {
			System.out.println(transactions);				  
		}
		selectMenu(bank);
	}

}
