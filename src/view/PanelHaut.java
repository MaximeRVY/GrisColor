package view;

import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelHaut extends JPanel{
	private int compteur;
	private List<JPanel> ligneColors;
	private ChoiceColorVue parent;
	private JPanel lineTitle;
	
public void coucou(){
		
	}
	
	public PanelHaut(ChoiceColorVue parent){
		this.parent = parent;
		compteur = 0;
		ligneColors = new ArrayList<JPanel>();
		JPanel lineTitle = new JPanel();
		
		this.setPreferredSize(new Dimension(800,500));
		this.setMinimumSize(new Dimension(800,500));
		this.setMaximumSize(new Dimension(800,500));
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.setBorder(BorderFactory.createTitledBorder("Choose Color"));
	}
	
	private void AddTitleLine(){
		JLabel name = new JLabel("Name");
		name.setPreferredSize(new Dimension(60, 10));
		name.setMinimumSize(new Dimension(60,10));
		name.setMaximumSize(new Dimension(60,10));
		
		JLabel color = new JLabel("Color");
		color.setPreferredSize(new Dimension(60, 10));
		color.setMinimumSize(new Dimension(60,10));
		color.setMaximumSize(new Dimension(60,10));
		
		JLabel gris = new JLabel("Transform color");
		gris.setPreferredSize(new Dimension(150, 10));
		gris.setMinimumSize(new Dimension(150,10));
		gris.setMaximumSize(new Dimension(150,10));
		
		lineTitle = new JPanel();
		lineTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
		lineTitle.setLayout(new BoxLayout(lineTitle, BoxLayout.X_AXIS));
		
		
		lineTitle.add(Box.createRigidArea(new Dimension(100,0)));
		lineTitle.add(name);
		lineTitle.add(Box.createRigidArea(new Dimension(80,0)));
		lineTitle.add(color);
		lineTitle.add(Box.createRigidArea(new Dimension(10,0)));
		lineTitle.add(gris);
		
		lineTitle.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		this.add(lineTitle);
	
	}

	public void addLine() {
		if(compteur == 0){
			this.AddTitleLine();
		}
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
		}else if (compteur == 0){
			this.remove(lineTitle);
		}
	}
}
