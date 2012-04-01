package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LignePanel extends JPanel{
	JTextField textField;
	final JPanel labelColor;
	JPanel labelGris;
	JButton moins;
	ChoiceColorVue parent;
	JPanel ligne;
	
	public LignePanel(ChoiceColorVue parent) {
		this.parent = parent;
		
		moins = new JButton("-");
		moins.addActionListener(new SupLignePanel());
		
		textField = new JTextField();
		textField.setMinimumSize(new Dimension(100,20));
		textField.setMinimumSize(new Dimension(100,20));
		textField.setMaximumSize(new Dimension(100,20));
		
		labelColor = new JPanel();
		labelColor.setPreferredSize(new Dimension(35, 35));
		labelColor.setMinimumSize(new Dimension(35,35));
		labelColor.setMaximumSize(new Dimension(35,35));
		labelColor.setBackground(Color.white);
		
		labelGris = new JPanel();
		labelGris.setPreferredSize(new Dimension(35, 35));
		labelGris.setMinimumSize(new Dimension(35,35));
		labelGris.setMaximumSize(new Dimension(35,35));
		labelGris.setBackground(Color.black);
		
		this.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		labelColor.addMouseListener(new ColorListener());
		
		this.add(Box.createRigidArea(new Dimension(20,0)));
		this.add(moins);
		this.add(Box.createRigidArea(new Dimension(40,0)));
		this.add(textField);
		this.add(Box.createRigidArea(new Dimension(40,0)));
		this.add(labelColor);
		this.add(Box.createRigidArea(new Dimension(40,0)));
		this.add(labelGris);
		
		this.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		
		this.ligne = this;
	}
	
	class SupLignePanel extends AbstractAction{	
		public void actionPerformed(ActionEvent arg0) {
			parent.getPanelHaut().supLigne(ligne);
		}
	}
	
	class ColorListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			//new ColorChooser(labelColor);
			labelColor.setBackground(JColorChooser.showDialog(new JFrame(), "Dialog Title", Color.white));
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
