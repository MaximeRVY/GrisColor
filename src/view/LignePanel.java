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
	JPanel labelColor;
	JPanel labelGris;
	JPanel labelColorMod;
	JPanel labelGrisMod;
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
		
		labelGris = new JPanel();
		labelGris.setPreferredSize(new Dimension(35, 35));
		labelGris.setMinimumSize(new Dimension(35,35));
		labelGris.setMaximumSize(new Dimension(35,35));
		
		labelColorMod = new JPanel();
		labelColorMod.setPreferredSize(new Dimension(35, 35));
		labelColorMod.setMinimumSize(new Dimension(35,35));
		labelColorMod.setMaximumSize(new Dimension(35,35));
		
		labelGrisMod = new JPanel();
		labelGrisMod.setPreferredSize(new Dimension(35, 35));
		labelGrisMod.setMinimumSize(new Dimension(35,35));
		labelGrisMod.setMaximumSize(new Dimension(35,35));
		
		this.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		modColor();
		labelColor.addMouseListener(new ColorListener());
		
		this.add(Box.createRigidArea(new Dimension(20,0)));
		this.add(moins);
		this.add(Box.createRigidArea(new Dimension(40,0)));
		this.add(textField);
		this.add(Box.createRigidArea(new Dimension(40,0)));
		this.add(labelColor);
		this.add(Box.createRigidArea(new Dimension(40,0)));
		this.add(labelGris);
		this.add(Box.createRigidArea(new Dimension(60,0)));
		this.add(labelColorMod);
		this.add(Box.createRigidArea(new Dimension(40,0)));
		this.add(labelGrisMod);
		
		this.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		
		this.ligne = this;
	}
	
	class SupLignePanel extends AbstractAction{	
		public void actionPerformed(ActionEvent arg0) {
			parent.getPanelHaut().supLigne(ligne);
		}
	}
	
	public void modColor(){
		Color color = JColorChooser.showDialog(new JFrame(), "Dialog Title", labelColor.getBackground());
		if(color != null){
			labelColor.setBackground(color);
			int niveaugris = (int) (0.3 * color.getRed() + 0.59*color.getGreen() + 0.11*color.getBlue());
			labelGris.setBackground(new Color(niveaugris,niveaugris,niveaugris));
		}
	}
	
	public void insertColorMod(Color cc, Color cg){
		labelColorMod.setBackground(cc);
		labelGrisMod.setBackground(cg);
	}
	
	class ColorListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			modColor();
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
