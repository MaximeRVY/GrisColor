package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LignePanel extends JPanel{
	JTextField textField;
	JPanel labelColor;
	JPanel labelGris;
	JButton moins;
	
	
	public LignePanel() {
		moins = new JButton("-");
		textField = new JTextField();
		textField.setMinimumSize(new Dimension(100,20));
		textField.setMinimumSize(new Dimension(100,20));
		textField.setMaximumSize(new Dimension(100,20));
		
		labelColor = new JPanel();
		labelColor.setPreferredSize(new Dimension(40, 40));
		labelColor.setMinimumSize(new Dimension(40,40));
		labelColor.setMaximumSize(new Dimension(40,40));
		labelColor.setBackground(Color.white);
		
		labelGris = new JPanel();
		labelGris.setPreferredSize(new Dimension(40, 40));
		labelGris.setMinimumSize(new Dimension(40,40));
		labelGris.setMaximumSize(new Dimension(40,40));
		labelGris.setBackground(Color.black);
		
		this.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		this.add(Box.createRigidArea(new Dimension(20,0)));
		this.add(moins);
		this.add(Box.createRigidArea(new Dimension(40,0)));
		this.add(textField);
		this.add(Box.createRigidArea(new Dimension(40,0)));
		this.add(labelColor);
		this.add(Box.createRigidArea(new Dimension(40,0)));
		this.add(labelGris);
	}
}
