package view;


import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar{
	public Menu(){
		JMenu menu = new JMenu("File");
		this.add(menu);
		menu = new JMenu("Edit");
		this.add(menu);
		JMenuItem menuItem = new JMenuItem("Undo");
		menu.add(menuItem);
		menuItem = new JMenuItem("Redo");
		menu.add(menuItem);
	}
	
}