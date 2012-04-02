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
	private JTextField textField;
	public JPanel labelColor;
	public JPanel labelGris;
	public JPanel labelColorMod;
	public JPanel labelGrisMod;
	private JButton moins;
	private ChoiceColorVue parent;
	private JPanel ligne;
	
	public LignePanel(ChoiceColorVue parent, Color color) {
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
		
		labelColor.addMouseListener(new ColorListener());
		
		addColor(color);
		
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
	
	public void addColor(Color color){
			labelColor.setBackground(color);
			int niveaugris = getGris(labelColor.getBackground());
			labelGris.setBackground(new Color(niveaugris,niveaugris,niveaugris));
	}
	
	public int getGris(Color c){
		return (int) (0.3*c.getRed() + 0.59*c.getGreen() + 0.11*c.getBlue());
	}
	
	public void modColor(){
		Color color = JColorChooser.showDialog(new JFrame(), "Dialog Title", labelColor.getBackground());
		if(color !=null)
			addColor(color);
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
