package view;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
/**
 * Classe de la Frame principale
 * @author Maxime Raverdy et Damien Level
 * 
 *
 */
public class ChoiceColorVue extends JFrame{
	/**
	 * panelHaut : variable pour enregistrer le haut de la frame 
	 * panelBas : variable pour enregister le bas de la frame
	 * menu : variable pour enregister le menu
	 */
	PanelHaut panelHaut;
	PanelBas panelBas;
	Menu menu;
	
	/**
	 * 
	 * @return le panel haut
	 */
	public PanelHaut getPanelHaut() {
		return panelHaut;
	}

	/**
	 * 
	 * @return le panel Bas
	 */
	public PanelBas getPanelBas() {
		return panelBas;
	}

	/**
	 * 
	 * @return retourne le menu
	 */
	public Menu getMenu() {
		return menu;
	}

	/**
	 * Construit les differentes vue dans la frame principal
	 */
	public ChoiceColorVue(){
		Container content = this.getContentPane();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		
		menu = new Menu(this);
		this.setJMenuBar(menu);
		
		panelHaut = new PanelHaut(this);
		content.add(panelHaut);
		
		panelBas = new PanelBas(this);
		content.add(panelBas);
		
		this.setSize(new Dimension(800, 600));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
	}


}
