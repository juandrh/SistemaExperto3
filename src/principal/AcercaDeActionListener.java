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

public class AcercaDeActionListener implements ActionListener {

	private Gui gui;

	public AcercaDeActionListener(Gui gui) {
		this.gui = gui;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		ImageIcon icono = new ImageIcon("iconos/agenda.png");

		JOptionPane.showMessageDialog(gui,
				"Test en 2D del metaverso (implementado parcialmente).\n\nCaracterísticas:\n\n-"
				+ " Movimiento aleatorio de los personajes.\n\n- Identificación de las entidades sólo con posarse con el ratón.\n\n-"
				+ " Chocar con árboles o rocas resta vida a los seres animados.\n\n\n\nDesarrollado "
				+ "para la AEC2 de Paradigmas de Programación.\n\nVersión 1.L - mayo 2022\n\nFuente"
				+ " de los iconos: https:/remixicon.com\n\nAutor: Juan del Río.",
				null, JOptionPane.DEFAULT_OPTION, icono);
		
		gui.requestFocus();

	}

}
