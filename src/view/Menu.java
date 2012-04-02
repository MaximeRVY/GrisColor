package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
/**
 * Classe qui crée le menu de la frame principale
 * @author Maxime Raverdy et Damien Level
 *
 */
public class Menu extends JMenuBar{
	private ChoiceColorVue parent;
	public JMenuItem menuItemAdd;
	public JMenuItem menuItemMod;
	public Menu(final ChoiceColorVue parent){
		this.parent = parent;
		JMenu menu = new JMenu("File");
		this.add(menu);
		menuItemAdd = new JMenuItem("Add a color");
		menuItemAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.getPanelBas().buttonAdd.doClick();
			}
		});
		menu.add(menuItemAdd);
		menuItemMod = new JMenuItem("Automatic modification");
		menuItemMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.getPanelBas().buttonModifAuto.doClick();
			}
		});
		menuItemMod.setEnabled(false);
		menu.add(menuItemMod);
		menu.addSeparator();
		JMenuItem menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menu.add(menuItem);
	}
	
}
