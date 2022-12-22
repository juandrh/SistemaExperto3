package principal;

import difuso.SEDifuso;
/**
 * Aplicaci�n creadora de sistemas expertos n�tidos o difusos
 * con base de conocimiento de ejemplo.
 * Implementa los patrones: Interpreter, Composite y factory
 * 
 * Creador concreto de sistema difuso
 * Clase creador concreto del patr�n factor�a
 * 
 * 
 * @author Juan Del Rio
 * @version 1.0 Dic-2022
 */
public class CreadorSistemaExpertoDifuso extends CreadorSistemaExperto{

	@Override
	public SistemaExperto crearSistemaExperto() {
		System.out.println("Creando sistema experto difuso ...");
		return new SEDifuso();
		
	}

	

}
