package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase NuevoActionListener
 * 
 * @author juan.delrio
 * @version 1.L
 * 
 */


public class ListenerNuevoAction implements ActionListener  {

	private Gui gui;

	
	public ListenerNuevoAction(Gui gui) {
		this.gui = gui;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		gui.crearNuevo();
		
	}

	
		

}
