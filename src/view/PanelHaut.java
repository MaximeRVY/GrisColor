package view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class PanelHaut extends JPanel{
	private int compteur;
	private List<JPanel> ligneColors;
	private ChoiceColorVue parent;
	
	public PanelHaut(ChoiceColorVue parent){
		this.parent = parent;
		compteur = 0;
		ligneColors = new ArrayList<JPanel>();
		
		this.setPreferredSize(new Dimension(800,400));
		this.setMinimumSize(new Dimension(800,400));
		this.setMaximumSize(new Dimension(800,400));
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.setBorder(BorderFactory.createTitledBorder("Choose Color"));
		
		addLine();
	}

	public void addLine() {
		if(compteur < 10){
			LignePanel panel = new LignePanel(parent);
			this.add(panel);
			this.ligneColors.add(panel); 
			this.revalidate();
			compteur ++;
			if(compteur >= 2){
				
			}else{
				// rendre le bouton pas enable
			}
				
		}
	}
	
	public void supLigne(JPanel ligne){
		this.remove(ligne);
		this.
		ligneColors.remove(ligne);
		this.revalidate();
		this.repaint();
	}
}
