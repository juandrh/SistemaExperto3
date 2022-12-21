package principal;

import nitido.SENitido;

/**
 * Aplicaci�n creadora de sistemas expertos n�tidos o difusos
 * con base de conocimiento de ejemplo.
 * Implementa los patrones: Interpreter, Composite y factory
 * 
 * Creador concreto de sistema n�tido
 * 
 * 
 * @author Juan Del Rio
 * @version 1.0 Dic-2022
 */


public class CreadorSistemaExpertoNitido extends CreadorSistemaExperto{

	@Override
	public SistemaExperto crearSistemaExperto() {
		System.out.println("Creando sistema experto n�tido ...");
		return new SENitido();
		
	}
}
