package principal;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Clase SliderListener
 * 
 * @author juan.delrio
 * @version 1.L
 * 
 */

public class ListenerSlider implements ChangeListener {

	private Gui gui;

	public ListenerSlider(Gui gui) {
		this.gui = gui;

	}

	@Override
	public void stateChanged(ChangeEvent e) {
			
	    
	        gui.actualizaParametros();
	        gui.requestFocus();
	       
		
	}

	

}
