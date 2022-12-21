package principal;


import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
/**
 * Clase MousseListener
 * 
 * @author juan.delrio
 * @version 1.L
 * 
 */
public class MousseListener implements MouseMotionListener {

	private Gui gui;


	public MousseListener(Gui gui) {
		this.gui = gui;

	}



	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		// Al situarse sobre una entidad muestra su nombre 
		
		try {
			
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		
	}

	


}
