package principal;

import nitido.SENitido;

/**
 * Aplicación creadora de sistemas expertos nítidos o difusos
 * con base de conocimiento de ejemplo.
 * Implementa los patrones: Interpreter, Composite y factory
 * 
 * Creador concreto de sistema nítido
 * 
 * 
 * @author Juan Del Rio
 * @version 1.0 Dic-2022
 */


public class CreadorSistemaExpertoNitido extends CreadorSistemaExperto{

	@Override
	public SistemaExperto crearSistemaExperto() {
		System.out.println("Creando sistema experto nítido ...");
		return new SENitido();
		
	}
}
