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

public class SliderListener implements ChangeListener {

	private Gui gui;

	public SliderListener(Gui gui) {
		this.gui = gui;

	}

	@Override
	public void stateChanged(ChangeEvent e) {
			
	    
	        gui.actualizaParametros();
	        gui.requestFocus();
	       
		
	}

	

}
