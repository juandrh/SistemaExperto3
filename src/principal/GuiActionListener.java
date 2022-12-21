package principal;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Clase GuiActionListener
 * 
 * @author juan.delrio
 * @version 1.L
 * 
 */

public class GuiActionListener implements WindowListener {

	private Gui gui;
	
	public GuiActionListener(Gui gui) {
		this.gui = gui;
	}

	public void windowClosing(WindowEvent e) {
		
		gui.setVisible(false);
		gui.dispose();

	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

}
