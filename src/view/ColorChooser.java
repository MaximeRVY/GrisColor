package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorChooser extends JFrame{
	public ColorChooser(final JPanel colorPanel) {
		super("Choose your color");
	    Container contentPane = this.getContentPane();
	    
	    final JColorChooser colorChooser = new JColorChooser(colorPanel.getBackground());
	    
	    ColorSelectionModel model = colorChooser.getSelectionModel();
	    ChangeListener changeListener = new ChangeListener() {
	      public void stateChanged(ChangeEvent changeEvent) {
	        Color newForegroundColor = colorChooser.getColor();
	        colorPanel.setBackground(newForegroundColor);
	      }
	    };
	    model.addChangeListener(changeListener);
	    contentPane.add(colorChooser, BorderLayout.CENTER);
	    
	    this.pack();
	    this.setVisible(true);
	}
}
