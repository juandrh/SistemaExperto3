package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
* Aplicación creadora de sistemas expertos nítidos o difusos con base de
* conocimiento de ejemplo. 
* Implementa los patrones: Interpreter, Composite y factory.
* 
* Manejo eventos de crear nuevo
* 
* @author juan.delrio
* @version 2.0 dic-2022
* 
*/


public class ListenerNuevoAction implements ActionListener  {

	private Principal principal;

	
	public ListenerNuevoAction(Principal principal) {
		this.principal = principal;		
	}

	@Override
	public void actionPerformed(ActionEvent e) {		
		// llama a la función crear nuevo
		principal.crearNuevo();
		
	}

	
		

}
