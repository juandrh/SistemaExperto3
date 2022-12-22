package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase SalirListener
 * 
 * @author juan.delrio
 * @version 1.L
 * 
 */

public class ListenerSalir implements ActionListener {

	private Gui gui;
	
	public ListenerSalir(Gui gui) {
		this.gui = gui;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		gui.setVisible(false);
		gui.dispose();

	}

}
