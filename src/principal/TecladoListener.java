package principal;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



/**
 * Clase TecladoListener
 * 
 * @author juan.delrio
 * @version 1.L
 * 
 */
public class TecladoListener implements KeyListener {

	private Gui gui;

	public TecladoListener (Gui gui) {
		this.gui = gui;

	}


	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {			
			
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {		
			
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {			
			
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {			
			
		}
		
		e.consume();
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	


}
