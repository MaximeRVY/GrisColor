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
	
public void coucou(){
		
	}
	
	public PanelHaut(ChoiceColorVue parent){
		this.parent = parent;
		compteur = 0;
		ligneColors = new ArrayList<JPanel>();
		
		this.setPreferredSize(new Dimension(800,500));
		this.setMinimumSize(new Dimension(800,500));
		this.setMaximumSize(new Dimension(800,500));
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.setBorder(BorderFactory.createTitledBorder("Choose Color"));
	}

	public void addLine() {
		LignePanel panel = new LignePanel(parent);
		
		this.add(panel);
		this.ligneColors.add(panel); 
		this.revalidate();
		compteur ++;
		if(compteur == 2){
			parent.getPanelBas().modButtonModifAuto(true);
		}else if(compteur == 10){
			parent.getPanelBas().modButtonAdd(false);
		}
	}
	
	public void supLigne(JPanel ligne){
		this.remove(ligne);
		ligneColors.remove(ligne);
		this.revalidate();
		this.repaint();
		compteur--;
		if(compteur == 1){
			parent.getPanelBas().modButtonModifAuto(false);
		}else if(compteur == 9){
			parent.getPanelBas().modButtonAdd(true);
		}
	}
}
