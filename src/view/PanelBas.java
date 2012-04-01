package view;

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
			         return new Integer(l1.getGris()).compareTo(l2.getGris());
			    }
			});
			for(int i=0 ; i < lines.size() ; i++){
				int ecartMin = (int) ((255/lines.size()) * 0.8);
				line = lines.get(i);
				System.out.println(line.getGris());
				line.insertColorMod(line.labelColor.getBackground(), line.labelGris.getBackground());
			}
		}
	}
}
