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


public class EjecutarActionListener implements ActionListener  {

	private Gui gui;

	
	public EjecutarActionListener(Gui gui) {
		this.gui = gui;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		gui.ejecutaSistema(gui.getCreador());
		gui.setTexto(gui.getCreador().mostrarResultado());
		
	}

	
		

}
