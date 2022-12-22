package principal;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
* Aplicaci�n creadora de sistemas expertos n�tidos o difusos con base de
* conocimiento de ejemplo. 
* Implementa los patrones: Interpreter, Composite y factory.
* 
* Manejo eventos de los deslizadores
* 
* @author juan.delrio
* @version 2.0 dic-2022
* 
*/

public class ListenerSlider implements ChangeListener {

	private Principal principal;

	public ListenerSlider(Principal principal) {
		this.principal = principal;
	}

	@Override
	public void stateChanged(ChangeEvent e) {	
		// Actualiza los par�metros del sistema difuso en base a los valores de los deslizadores
	    principal.actualizaParametros();
		principal.requestFocus();     
		
	}

}
