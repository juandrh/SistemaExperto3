package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Aplicación creadora de sistemas expertos nítidos o difusos con base de
 * conocimiento de ejemplo. 
 * Implementa los patrones: Interpreter, Composite y factory.
 * 
 * Manejo evento AcercaDe
 * 
 * @author juan.delrio
 * @version 2.0 dic-2022
 * 
 */

public class ListenerAcercaDeAction implements ActionListener {

	private Principal principal;

	public ListenerAcercaDeAction(Principal principal) {
		this.principal = principal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		ImageIcon icono = new ImageIcon("iconos/ejecuta.png");
		// Muestra diálogo Acerca de...
		JOptionPane.showMessageDialog(principal,
				"AEC2: Implementación de un sistema informático\n"				
				+ "con diferentes patrones de Diseño."
				+ "\nAsignatura Patrones de diseño (UDIMA).\n\nVersión 2.0 - dic 2022"		
				+ "\n\nFuente de los iconos: https:/remixicon.com\n\nAutor: Juan del Río.",
				null, JOptionPane.DEFAULT_OPTION, icono);
		
		principal.requestFocus();

	}

}
