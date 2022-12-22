package nitido;

import java.util.List;

/**
 * Aplicación creadora de sistemas expertos nítidos o difusos con base de
 * conocimiento de ejemplo. 
 * Implementa los patrones: Interpreter, Composite y factory.
 * 
 * Sistema Experto Nítido 
 * Operador NO
 * 
 * Clase compuesto concreto del patron composite
 * Clase operador concreto del patron interpreter
 * 
 * @author Juan Del Rio
 * @version 1.0 Dic-2022
 */
public class OpNo extends Operador {

	public OpNo(String descripcion) {
		super(descripcion);
	}
	// implementación de la gestion de compuestos del patrón composite
	public void anadir(Expresion e) {
		// Operador unario, sólo admite una expresión
		if (expresiones.size() == 0) {
			expresiones.add(e);
		}
	}
	// implementación de la evaluación del patrón interpreter
	public boolean evaluar(List<Expresion> hechos) {
		return !expresiones.get(0).evaluar(hechos);
	}

	public String toString() {
		return "No " + expresiones.get(0).toString();
	}

}
