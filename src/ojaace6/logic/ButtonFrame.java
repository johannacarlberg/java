package ojaace6.logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonFrame extends JFrame {
	private JButton button;
	private JLabel label;
	
	private static final int FRAME_WIDTH = 100;
	private static final int FRAME_HEIGHT = 60;
	
	public ButtonFrame()
	{
		createComponents();
		setSize(FRAME_WIDTH, FRAME_HEIGHT); 
	}
	
	class ClickListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event) 
		{
			label.setText("I was clicked."); 
		}
	}
	
	private void createComponents() 
	{
		button = new JButton("Click me!");
		ActionListener listener = new ClickListener();
		button.addActionListener(listener);
		label = new JLabel("Hello World!");
		JPanel panel = new JPanel(); 
		panel.add(button);
		panel.add(label);
		add(panel);
	}
}
