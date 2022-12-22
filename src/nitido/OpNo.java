package nitido;

import java.util.List;

/**
 * Aplicaci�n creadora de sistemas expertos n�tidos o difusos con base de
 * conocimiento de ejemplo. 
 * Implementa los patrones: Interpreter, Composite y factory.
 * 
 * Sistema Experto N�tido 
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
	// implementaci�n de la gestion de compuestos del patr�n composite
	public void anadir(Expresion e) {
		// Operador unario, s�lo admite una expresi�n
		if (expresiones.size() == 0) {
			expresiones.add(e);
		}
	}
	// implementaci�n de la evaluaci�n del patr�n interpreter
	public boolean evaluar(List<Expresion> hechos) {
		return !expresiones.get(0).evaluar(hechos);
	}

	public String toString() {
		return "No " + expresiones.get(0).toString();
	}

}
