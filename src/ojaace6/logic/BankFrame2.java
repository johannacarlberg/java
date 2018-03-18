package ojaace6.logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BankFrame2 extends JFrame {
	
	private static final int FRAME_WIDTH = 650;
	private static final int FRAME_HEIGHT = 400;
	
	private static final int AREA_ROWS = 10;
	private static final int AREA_COLUMNS = 30;
	
//	private static final double DEFAULT_RATE = 5;
//	private static final double INITIAL_BALANCE = 1000;
//	
	private JLabel menuLabel;
	private JLabel nameLabel;
	private JTextField nameField;
	private JLabel lastNameLabel;
	private JTextField lastNameField;
	private JLabel pNoLabel;
	private JTextField pNoField;
	private JLabel accountNoLabel;
	private JTextField accountNoField;
	private JLabel amountNoLabel;
	private JTextField amountNoField;
	
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	private JButton button8;
	private JButton button9;
	private JButton button10;
	private JButton button11;
	private JButton button12;
	private JLabel resultLabel;
	private JTextArea resultArea;
	//private double balance;
	BankLogic bank = new BankLogic();
	
	public BankFrame2() 
	{
		//balance = INITIAL_BALANCE;
		resultLabel = new JLabel("Hello");
		resultArea = new JTextArea(AREA_ROWS, AREA_COLUMNS);
		bank.createCustomer("Johanna", "Carlberg", "9010061506");		
		bank.createCustomer("Jo", "Jo", "jo");
	
		//resultArea.setText(balance + "\n");
		resultArea.setEditable(false);
		
		createTextField();
		createButtons();
		createPanel();
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	private void createTextField() 
	{
		menuLabel = new JLabel("Meny \n\n");
		nameLabel = new JLabel("Förnamn? \n\n");
		lastNameLabel = new JLabel("Efternamn? \n\n");
		pNoLabel = new JLabel("Personnummer? \n\n");
		accountNoLabel = new JLabel("Konto Nummer? \n\n");
		amountNoLabel = new JLabel("Summa? \n\n");
		
		final int FIELD_WIDTH = 10;
		nameField = new JTextField(FIELD_WIDTH); 
		//nameField.setText("");
		lastNameField = new JTextField(FIELD_WIDTH); 
		//lastNameField.setText("");
		pNoField = new JTextField(FIELD_WIDTH); 
		//pNoField.setText("");
		accountNoField = new JTextField(FIELD_WIDTH); 
		//accountNoField.setText("");
		amountNoField = new JTextField(FIELD_WIDTH); 
		//accountNoField.setText("");
	}
	
//	Adds interest to the balance and updates the display.
	class AddInterestListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event) 
		{
			
			if(event.getSource() == button1)
			{
				ArrayList<String> allCustomers = bank.getAllCustomers();
				resultArea.append(allCustomers + "\n");

			}
			
			if(event.getSource() == button2)
			{
				boolean created = bank.createCustomer(nameField.getText(), lastNameField.getText(), pNoField.getText());
				if(created == true)
				{
					resultLabel.setText("Ny kund har skapats \n");

				} else {
					resultLabel.setText("Personnummret finns redan tillagt \n");
				}
			}
			
			if(event.getSource() == button3)
			{
				ArrayList<String> customerInfo = bank.getCustomer(pNoField.getText());
				if(customerInfo == null)
				{
					resultLabel.setText("Ingen kund hittades med det personnumret \n");
				} else {
					resultArea.append("" + customerInfo + " \n");
				}
			}
			
			if(event.getSource() == button4)
			{
				boolean changed = bank.changeCustomerName(nameField.getText(), lastNameField.getText(), pNoField.getText());
				if(changed == true)
				{
					resultLabel.setText("Namnet har uppdaterats \n"); 
				} else {
					resultLabel.setText("Hittade ingen kund med det personnumret \n"); 
				}
			}
			
			if(event.getSource() == button5)
			{
				ArrayList<String> customerInfo = bank.deleteCustomer(pNoField.getText());
				if(customerInfo == null)
				{
					resultLabel.setText("Ingen kunde hittades med det personnumret \n");
				} else {
					resultLabel.setText("Kunden har raderats");
					resultArea.append(customerInfo + " \n"); 
				}
			}
			
			if(event.getSource() == button6)
			{
				int accountNo = bank.createSavingsAccount(pNoField.getText());
				if(accountNo < 0)
				{
					resultLabel.setText("Inget nytt konto skapades \n");				  
				} else {
					resultLabel.setText("Nytt sparkonto skapats: " + accountNo + "\n");				  
				}
			}
			
			if(event.getSource() == button7)
			{
				int accountNo = Integer.parseInt(accountNoField.getText());
				String accountInfo = bank.getAccount(pNoField.getText(), accountNo);
				if(accountInfo == null)
				{
					resultLabel.setText("Kan inte hitta kund och/eller konto \n");
				} else {
					resultLabel.setText(accountInfo + " \n");
				}
			}
			
			if(event.getSource() == button8)
			{
				int accountNo = Integer.parseInt(accountNoField.getText());
				double amount = Integer.parseInt(amountNoField.getText());
				boolean deposit = bank.deposit(pNoField.getText(), accountNo, amount);
				if(deposit == true)
				{
					resultLabel.setText("Pengarna har nu satts in på kontot \n");  
				} else {
					resultLabel.setText("Insättningen misslyckades \n");
				}
			}
			
			if(event.getSource() == button9)
			{
				int accountNo = Integer.parseInt(accountNoField.getText());
				double amount = Integer.parseInt(amountNoField.getText());
				boolean withdraw = bank.withdraw(pNoField.getText(), accountNo, amount);
				if(withdraw == true)
				{
					resultLabel.setText("Pengarna har nu tagits ut från kontot \n");  
				} else {
					resultLabel.setText("Uttag misslyckades \n");
				}
			}
			
			if(event.getSource() == button10)
			{
				int accountNo = Integer.parseInt(accountNoField.getText());
				String accountInfo = bank.closeAccount(pNoField.getText(), accountNo);
				if(accountInfo == null)
				{
					resultLabel.setText("Kan inte hitta kund och/eller konto \n");
				} else {
					resultLabel.setText(accountInfo + " \n");
				}
			}
			
			if(event.getSource() == button11)
			{
				int accountNo = bank.createCreditAccount(pNoField.getText());
				if(accountNo < 0)
				{
					resultLabel.setText("Inget nytt konto skapades \n");				  
				} else {
					resultLabel.setText("Nytt kreditkonto skapats: " + accountNo + " \n");				  
				}
			}
			
			if(event.getSource() == button12)
			{
				int accountNo = Integer.parseInt(accountNoField.getText());
				ArrayList<String> transactions = bank.getTransactions(pNoField.getText(), accountNo);
				if(transactions == null)
				{
					resultLabel.setText("Finns inga transaktioner for detta konto \n");				  
				} else {
					resultLabel.setText("" + transactions);				  
				}
			}

		}
	}
	
	private void createButtons() 
	{
		ActionListener listener = new AddInterestListener();
		button1 = new JButton("Hämta kundlista");
		button1.addActionListener(listener); 
		
		button2 = new JButton("Ny kund");
		button2.addActionListener(listener); 
		
		button3 = new JButton("Information om kund");
		button3.addActionListener(listener); 
		
		button4 = new JButton("Ändra Namn på kund");
		button4.addActionListener(listener); 
		
		button5 = new JButton("Ta bort kund");
		button5.addActionListener(listener); 
		
		button6 = new JButton("Skapa Sparkonto");
		button6.addActionListener(listener); 
		
		button7 = new JButton("Se konto information");
		button7.addActionListener(listener); 
		
		button8 = new JButton("Gör insättning");
		button8.addActionListener(listener); 
		
		button9 = new JButton("Ta ut pengar");
		button9.addActionListener(listener); 
		
		button10 = new JButton("Stäng konto");
		button10.addActionListener(listener); 
		
		button11 = new JButton("Skapa kredit konto");
		button11.addActionListener(listener); 
		
		button12 = new JButton("Se transaktioner");
		button12.addActionListener(listener); 
	}
	
	private void createPanel() 
	{
		JPanel panel = new JPanel(); 
		panel.add(menuLabel); 
		panel.add(nameLabel); 
		panel.add(nameField); 
		panel.add(lastNameLabel); 
		panel.add(lastNameField); 
		panel.add(pNoLabel); 
		panel.add(pNoField); 
		panel.add(accountNoLabel); 
		panel.add(accountNoField); 
		panel.add(amountNoLabel); 
		panel.add(amountNoField); 
		panel.add(button1); 
		panel.add(button2); 
		panel.add(button3); 
		panel.add(button4); 
		panel.add(button5); 
		panel.add(button6); 
		panel.add(button7); 
		panel.add(button8); 
		panel.add(button9); 
		panel.add(button10); 
		panel.add(button11); 
		panel.add(button12);
		JScrollPane scrollPane = new JScrollPane(resultArea);
		panel.add(scrollPane);
		panel.add(resultLabel);
		add(panel);
	}
}
