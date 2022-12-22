package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Clase AcercaDeActionListener
 * 
 * @author juan.delrio
 * @version 1.L
 * 
 */

public class ListenerAcercaDeAction implements ActionListener {

	private Gui gui;

	public ListenerAcercaDeAction(Gui gui) {
		this.gui = gui;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		ImageIcon icono = new ImageIcon("iconos/ejecuta.png");

		JOptionPane.showMessageDialog(gui,
				"AEC2: \n\n-"				
				+ "para la AEC2 de Paradigmas de Programación.\n\nVersión 2.0 - dic 2022\n\nFuente"
				+ " de los iconos: https:/remixicon.com\n\nAutor: Juan del Río.",
				null, JOptionPane.DEFAULT_OPTION, icono);
		
		gui.requestFocus();

	}

}
