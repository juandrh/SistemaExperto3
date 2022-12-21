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
				"Test en 2D del metaverso (implementado parcialmente).\n\nCaracter�sticas:\n\n-"
				+ " Movimiento aleatorio de los personajes.\n\n- Identificaci�n de las entidades s�lo con posarse con el rat�n.\n\n-"
				+ " Chocar con �rboles o rocas resta vida a los seres animados.\n\n\n\nDesarrollado "
				+ "para la AEC2 de Paradigmas de Programaci�n.\n\nVersi�n 1.L - mayo 2022\n\nFuente"
				+ " de los iconos: https:/remixicon.com\n\nAutor: Juan del R�o.",
				null, JOptionPane.DEFAULT_OPTION, icono);
		
		gui.requestFocus();

	}

}
