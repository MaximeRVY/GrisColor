package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBas extends JPanel {
	private JButton buttonAdd;
	private JButton buttonModifAuto;
	private ChoiceColorVue parent;
	
	public PanelBas(ChoiceColorVue parent) {
		this.parent = parent;
		this.setPreferredSize(new Dimension(800, 150));
		this.setMinimumSize(new Dimension(800, 150));
		this.setMaximumSize(new Dimension(800, 150));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Modification"),BorderFactory.createEmptyBorder(10,20,10,10)));

		buttonAdd = new JButton("Ajouter une couleur");
		buttonAdd.addActionListener(new AddLignePanel());
		this.add(buttonAdd);
		this.add(Box.createRigidArea(new Dimension(0,10)));
		buttonModifAuto = new JButton("Modification Automatique");
		buttonModifAuto.setEnabled(false);
		buttonModifAuto.addActionListener(new ModifAuto());
		this.add(buttonModifAuto);
		
	}
	
	public void modButtonModifAuto(boolean b){
		buttonModifAuto.setEnabled(b);
	}
	
	public void modButtonAdd(boolean b){
		buttonAdd.setEnabled(b);
	}

	class AddLignePanel extends AbstractAction{	
		public void actionPerformed(ActionEvent arg0) {
			parent.getPanelHaut().addLine();
		}
	}
	
	class ModifAuto extends AbstractAction{	
		public void actionPerformed(ActionEvent arg0) {
			ArrayList<LignePanel> lines = parent.getPanelHaut().getLines();
			LignePanel line;
			// Tri des lignes par niveau de gris
			Collections.sort(lines, new Comparator<LignePanel>(){
			    public int compare(LignePanel l1, LignePanel l2){
			         return new Integer(l1.getGris(l1.labelColor.getBackground())).compareTo(l2.getGris(l2.labelColor.getBackground()));
			    }
			});
			// Initialisation des valeurs pour une modification automatique et optimale
			int ecartMin = (int) ((255/lines.size()) * 0.8);
			int limInf = 0;
			int limSup = 255 - ecartMin * (lines.size()-1);
			int precedentGris = -ecartMin;
			// Parcourt des couleurs pour verifier le niveau de gris et changer la couleur si elle n'est pas optimale
			for(int i=0 ; i < lines.size() ; i++){
				line = lines.get(i);
				Color newC = line.labelColor.getBackground();
				int valGris = line.getGris(newC);
				int b = newC.getBlue();
				int g = newC.getGreen();
				int r = newC.getRed();
				int realLimInf = Math.max(limInf, precedentGris + ecartMin);
				int cpt=0;
				// Si le niveau de gris est inferieur à la limite optimale
				while(valGris <= realLimInf){
					switch (cpt % 3){
					case 0 : if(r<255)r++;break;
					case 1 : if(g<255)g++;break;
					case 2 : if(b<255)b++;break;
					}
					cpt++;
					newC = new Color(r,g,b);
					valGris = line.getGris(newC);
				}
				// Si le niveau de gris est superieur à la limite optimale
				while(valGris >= limSup){
					switch (cpt % 3){
					case 0 : if(r>0)r--;break;
					case 1 : if(g>0)g--;break;
					case 2 : if(b>0)b--;break;
					}
					cpt++;
					newC = new Color(r,g,b);
					valGris = line.getGris(newC);
				}
				String rgb = Integer.toHexString(newC.getRGB());
				rgb = rgb.substring(2, rgb.length());
				line.codeRGB.setText(rgb);
				line.codeRGB.setVisible(true);
				line.revalidate();
				// On met à jour les infos pour la ligne suivante
				limInf += ecartMin;
				limSup += ecartMin;
				precedentGris= valGris;
				// On ajoute les couleurs modifiees
				line.insertColorMod(newC, new Color(valGris,valGris,valGris));
			}
		}
	}
}
