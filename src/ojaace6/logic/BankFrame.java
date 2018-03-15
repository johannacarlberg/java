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

public class BankFrame extends JFrame {
	
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
	
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	//private JLabel resultLabel;
	private JTextArea resultArea;
	//private double balance;
	BankLogic bank = new BankLogic();
	
	public BankFrame() 
	{
		//balance = INITIAL_BALANCE;
		//resultLabel = new JLabel("Balance: " + balance);
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
		menuLabel = new JLabel("What would you like to do? \n\n");
		nameLabel = new JLabel("Förnamn? \n\n");
		lastNameLabel = new JLabel("Efternamn? \n\n");
		pNoLabel = new JLabel("Personnummer? \n\n");
		accountNoLabel = new JLabel("Konto Nummer? \n\n");
		
		final int FIELD_WIDTH = 10;
		nameField = new JTextField(FIELD_WIDTH); 
		//nameField.setText("");
		lastNameField = new JTextField(FIELD_WIDTH); 
		//lastNameField.setText("");
		pNoField = new JTextField(FIELD_WIDTH); 
		//pNoField.setText("");
		accountNoField = new JTextField(FIELD_WIDTH); 
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
				System.out.println(allCustomers);
			}
			if(event.getSource() == button2)
			{
				boolean created = bank.createCustomer(nameField.getText(), lastNameField.getText(), pNoField.getText());
				if(created == true)
				{
					resultArea.append("Ny kund har skapats \n");

				} else {
					resultArea.append("Personnummret finns redan tillagt \n");
				}
			}
			
			if(event.getSource() == button3)
			{
				resultArea.append("button3");
			}
			
			if(event.getSource() == button4)
			{
				resultArea.append("button4");
			}
			
			if(event.getSource() == button5)
			{
				resultArea.append("button5");
			}
			
			if(event.getSource() == button6)
			{
				int accountNo = bank.createSavingsAccount(pNoField.getText());
				if(accountNo < 0)
				{
					resultArea.append("Inget nytt konto skapades \n");				  
				} else {
					resultArea.append("Nytt sparkonto skapats: " + accountNo + "\n");				  
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
		panel.add(button1); 
		panel.add(button2); 
		panel.add(button3); 
		panel.add(button4); 
		panel.add(button5); 
		panel.add(button6); 
		JScrollPane scrollPane = new JScrollPane(resultArea);
		panel.add(scrollPane);
		//panel.add(resultLabel);
		add(panel);
	}
}
