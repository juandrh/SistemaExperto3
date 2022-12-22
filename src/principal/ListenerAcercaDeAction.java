package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Aplicaci�n creadora de sistemas expertos n�tidos o difusos con base de
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
		// Muestra di�logo Acerca de...
		JOptionPane.showMessageDialog(principal,
				"AEC2: Implementaci�n de un sistema inform�tico\n"				
				+ "con diferentes patrones de Dise�o."
				+ "\nAsignatura Patrones de dise�o (UDIMA).\n\nVersi�n 2.0 - dic 2022"		
				+ "\n\nFuente de los iconos: https:/remixicon.com\n\nAutor: Juan del R�o.",
				null, JOptionPane.DEFAULT_OPTION, icono);
		
		principal.requestFocus();

	}

}
