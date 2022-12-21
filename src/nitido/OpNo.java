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
 * @author Juan Del Rio
 * @version 1.0 Dic-2022
 */
public class OpNo extends Operador {

	public OpNo(String descripcion) {
		super(descripcion);
	}

	public void anadir(Expresion e) {

		// Operador unario, sólo admite una expresión
		if (expresiones.size() == 0) {
			expresiones.add(e);
		}
	}

	public boolean evaluar(List<Expresion> hechos) {
		return !expresiones.get(0).evaluar(hechos);
	}

	public String toString() {
		return "No " + expresiones.get(0).toString();
	}

}
