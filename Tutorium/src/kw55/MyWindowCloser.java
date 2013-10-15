package kw55;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

public class MyWindowCloser extends WindowAdapter {
	
	@Override
	public void windowClosing(WindowEvent e) {
		
		final int rc = JOptionPane.showConfirmDialog(e.getWindow(), "Quit?!", "Realy Quit?!", JOptionPane.YES_NO_OPTION);
		
		if (rc == JOptionPane.YES_OPTION){
			e.getWindow().setVisible(false);
			e.getWindow().dispose();
		}
		
		// TODO Auto-generated method stub
		super.windowClosing(e);
	}
}
