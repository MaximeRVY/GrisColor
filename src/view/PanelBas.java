package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

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
			
		}
	}
}
