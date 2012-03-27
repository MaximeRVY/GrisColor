package view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class PanelHaut extends JPanel{
	private int compteur;
	private List<JPanel> ligneColors;
	
	public PanelHaut(){
		compteur = 0;
		ligneColors = new ArrayList<JPanel>();
		
		this.setPreferredSize(new Dimension(800,400));
		this.setMinimumSize(new Dimension(800,400));
		this.setMaximumSize(new Dimension(800,400));
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.setBorder(BorderFactory.createTitledBorder("Choose Color"));
		
		addLine();
	}

	private void addLine() {
		LignePanel panel = new LignePanel();
		panel.add(panel);
		compteur ++;
	}	
}
