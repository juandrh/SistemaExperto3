package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Aplicación creadora de sistemas expertos nítidos o difusos con base de
 * conocimiento de ejemplo. 
 * Implementa los patrones: Interpreter, Composite y factory.
 * 
 * Manejo evento Ejecutar
 * 
 * @author juan.delrio
 * @version 2.0 dic-2022
 * 
 */


public class ListenerEjecutarAction implements ActionListener  {

	private Principal principal;
	
	public ListenerEjecutarAction(Principal principal) {
		this.principal = principal;		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Intenta ejecutar el sistema 		
		principal.ejecutaSistema(principal.getCreador());
		// Muestra los resultados si hay un sistema creado
		if(principal.getCreador()!=null) {
			principal.setTexto(principal.getCreador().mostrarResultado());
		}
	}


}
