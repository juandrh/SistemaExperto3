package nitido;

import java.util.List;

/**
 * Aplicaci�n creadora de sistemas expertos n�tidos o difusos con base de
 * conocimiento de ejemplo. 
 * Implementa los patrones: Interpreter, Composite y factory.
 * 
 * Sistema Experto N�tido 
 * Operador O
 * 
 * @author Juan Del Rio
 * @version 1.0 Dic-2022
 */

public class OpO extends Operador {

	public OpO(String descripcion) {
		super(descripcion);

	}

	public boolean evaluar(List<Expresion> hechos) {

		for (int i = 0; i < expresiones.size(); i++) {
			if (expresiones.get(i).evaluar(hechos))
				return true;
		}
		return false;
	}

	public String toString() {
		String texto = "(" + expresiones.get(0).toString();
		for (int i = 1; i < expresiones.size(); i++) {
			texto += " O " + expresiones.get(i).toString();
		}
		texto += ")";
		return texto;
	}

}
