package view;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelBas extends JPanel {
	
	public PanelBas() {
		this.setPreferredSize(new Dimension(800, 200));
		this.setMinimumSize(new Dimension(800, 200));
		this.setMaximumSize(new Dimension(800, 200));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Ajout"),BorderFactory.createEmptyBorder(10,10,10,10)));

		JButton buttonAdd = new JButton("Ajouter");
		this.add(buttonAdd);
		
	}

}
