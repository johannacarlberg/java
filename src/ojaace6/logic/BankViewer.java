package ojaace6.logic;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class BankViewer {
	public static void main(String[] args) 
	{
		JFrame frame = new BankFrame(); 
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("A Menu");
		JMenuItem menuItem;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setVisible(true);
		menuBar.add(menu);
		
		//a group of JMenuItems
		menuItem = new JMenuItem("A text-only menu item");
		//menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		//menuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
		menuItem = new JMenuItem("Both text and icon");
		
		menu.add(menuItem);
		frame.setJMenuBar(menuBar);

	}
}
