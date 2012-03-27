
import model.*;
import controller.*;
import view.*;

public class ChoiceColor {
	public ChoiceColor(){
		ChoiceColorModel ccmodel = new ChoiceColorModel();
		ChoiceColorController cccontroller = new ChoiceColorController(ccmodel);
		ChoiceColorVue ccvue = new ChoiceColorVue();
		
	}
	
	public static void main(String args[]) {
		//Schedule a job for the event-dispatching thread:
    //creating and showing this application's GUI.
	    javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					new ChoiceColor();
				}
	    });
	}
	
}
