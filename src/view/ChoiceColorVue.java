package view;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class ChoiceColorVue extends JFrame{
	public PanelHaut panelHaut;
	public JPanel panelBas;
	public JMenuBar menu;
	
	public ChoiceColorVue(){
		Container content = this.getContentPane();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		
		menu = new Menu();
		this.setJMenuBar(menu);
		
		panelHaut = new PanelHaut();
		content.add(panelHaut);
		
		panelBas = new PanelBas();
		content.add(panelBas);
		
		this.setSize(new Dimension(800, 600));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
	}
}
