package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
* Aplicación creadora de sistemas expertos nítidos o difusos con base de
* conocimiento de ejemplo. 
* Implementa los patrones: Interpreter, Composite y factory.
* 
* Manejo eventos salir
* 
* @author juan.delrio
* @version 2.0 dic-2022
* 
*/

public class ListenerSalir implements ActionListener {

	private Principal principal;
	
	public ListenerSalir(Principal principal) {
		this.principal = principal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// cierra ventana principal
		principal.setVisible(false);
		principal.dispose();

	}

}
