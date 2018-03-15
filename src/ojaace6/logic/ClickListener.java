package ojaace6.logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ClickListener implements ActionListener {
	public void actionPerformed(ActionEvent event) 
	{
		System.out.println("I was clicked."); 
		ActionListener listener = new ClickListener(); 
//		JButton button = new JButton("Click me!");
//
//		button.addActionListener(listener);
//		listener.actionPerformed(event);
	}
}
