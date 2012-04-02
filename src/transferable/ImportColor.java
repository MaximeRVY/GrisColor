package transferable;

import java.awt.Color;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.TransferHandler;

public class ImportColor extends TransferHandler {
	public int getSourceActions(JComponent c) {
		return COPY;
	}

	public boolean canImport(TransferHandler.TransferSupport support) {
		return true;
	}
	
	public boolean importData(TransferHandler.TransferSupport support) {
		if(support.isDataFlavorSupported(DataFlavor.stringFlavor)){
			JPanel panel = (JPanel) support.getComponent();
			
			Transferable t = support.getTransferable();
			String data;
			try {
				data = (String) t.getTransferData(DataFlavor.stringFlavor);
			} catch (Exception e) {
				return false;
			}
			
			String[] tabData = data.split("#");
			if(tabData.length > 1)
				data = tabData[1];
			Color color;
			try{
				color = new Color(Integer.valueOf( data.substring(0, 2), 16 ),
		            Integer.valueOf( data.substring( 2, 4 ), 16 ),
		            Integer.valueOf( data.substring( 4, 6 ), 16 ) );
				System.out.println(data);
			}catch(Exception e){
				return false;
			}
			
			panel.setBackground(color);
			return true;
		}
		return false;
	}
}
