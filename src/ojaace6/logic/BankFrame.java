package ojaace6.logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BankFrame extends JFrame {
	
	private static final int FRAME_WIDTH = 450;
	private static final int FRAME_HEIGHT = 250;
	
	private static final int AREA_ROWS = 10;
	private static final int AREA_COLUMNS = 30;
	
	private static final double DEFAULT_RATE = 5;
	private static final double INITIAL_BALANCE = 1000;
	

	private JLabel rateLabel;
	private JTextField rateField;
	private JButton button;
	//private JLabel resultLabel;
	private JTextArea resultArea;
	private double balance;
	
	
	public BankFrame() 
	{
		balance = INITIAL_BALANCE;
		//resultLabel = new JLabel("Balance: " + balance);
		resultArea = new JTextArea(AREA_ROWS, AREA_COLUMNS);
		
		resultArea.setText(balance + "\n");
		resultArea.setEditable(false);
		
		createTextField();
		createButton();
		createPanel();
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	private void createTextField() 
	{
		rateLabel = new JLabel("Interest Rate: ");
		
		final int FIELD_WIDTH = 10;
		rateField = new JTextField(FIELD_WIDTH); 
		rateField.setText("" + DEFAULT_RATE);
	}
	
//	Adds interest to the balance and updates the display.
	class AddInterestListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event) 
		{
			double rate = Double.parseDouble(rateField.getText()); 
			double interest = balance * rate / 100;
			balance = balance + interest; 
			//resultLabel.setText("Balance: " + balance);
			resultArea.append(balance + "\n");
		}
	}
	
	private void createButton() 
	{
		button = new JButton("Add Interest");
		ActionListener listener = new AddInterestListener();
		button.addActionListener(listener); 
	}
	
	private void createPanel() 
	{
		JPanel panel = new JPanel(); 
		panel.add(rateLabel); 
		panel.add(rateField); 
		panel.add(button); 
		JScrollPane scrollPane = new JScrollPane(resultArea);
		panel.add(scrollPane);
		//panel.add(resultLabel);
		add(panel);
	}
}
