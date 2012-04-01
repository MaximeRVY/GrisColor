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
			LignePanel panel = new LignePanel();
			this.add(panel);
			this.add(Box.createRigidArea(new Dimension(0,10)));
			this.ligneColors.add(panel);
			compteur ++;
			if(compteur >= 2){
				// rendre le bouton modifAuto de panel bas enable
			}else{
				// rendre le bouton pas enable
			}
				
		}
	}	
}
