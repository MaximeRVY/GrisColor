package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LignePanel extends JPanel{
	JTextField textField;
	JLabel labelColor;
	JLabel labelGris;
	
	
	public LignePanel() {
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(100, 20));
		textField.setMinimumSize(new Dimension(100,20));
		textField.setMaximumSize(new Dimension(100,20));
		
		labelColor = new JLabel();
		labelColor.setPreferredSize(new Dimension(100, 40));
		labelColor.setMinimumSize(new Dimension(100,40));
		labelColor.setMaximumSize(new Dimension(100,40));
		labelColor.setBackground(Color.white);
		
		labelGris = new JLabel();
		labelGris.setPreferredSize(new Dimension(100, 40));
		labelGris.setMinimumSize(new Dimension(100,40));
		labelGris.setMaximumSize(new Dimension(100,40));
		labelGris.setBackground(Color.white);
		
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		this.add(textField);
		this.add(labelColor);
		this.add(labelGris);
	}
}
