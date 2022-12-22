package principal;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Aplicación creadora de sistemas expertos nítidos o difusos con base de
 * conocimiento de ejemplo. 
 * Implementa los patrones: Interpreter, Composite y factory.
 * 
 * Manejo eventos de la ventana principal
 * 
 * @author juan.delrio
 * @version 2.0 dic-2022
 * 
 */

public class ListenerGuiAction implements WindowListener {

	private Principal principal;
	
	public ListenerGuiAction(Principal principal) {
		this.principal = principal;
	}

	public void windowClosing(WindowEvent e) {
		// cierra la ventana principal
		principal.setVisible(false);
		principal.dispose();
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
