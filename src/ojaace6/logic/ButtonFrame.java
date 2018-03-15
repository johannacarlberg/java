package ojaace6.logic;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonFrame extends JFrame {
	private static final int FRAME_WIDTH = 100;
	private static final int FRAME_HEIGHT = 60;
	
	public ButtonFrame()
	{
		createComponents();
		setSize(FRAME_WIDTH, FRAME_HEIGHT); 
	}
	
	private void createComponents() 
	{
		JButton button = new JButton("Click me!"); JPanel panel = new JPanel(); panel.add(button);
		add(panel);
		ActionListener listener = new ClickListener();
		button.addActionListener(listener); 
	}
}
