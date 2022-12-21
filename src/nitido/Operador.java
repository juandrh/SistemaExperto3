package nitido;

import java.util.ArrayList;
import java.util.List;

/**
 * Aplicaci�n creadora de sistemas expertos n�tidos o difusos con base de
 * conocimiento de ejemplo. 
 * Implementa los patrones: Interpreter, Composite y factory.
 * 
 * Sistema Experto N�tido 
 * Clase compuesto del patron composite
 * 
 * @author Juan Del Rio
 * @version 1.0 Dic-2022
 */

public abstract class Operador extends Expresion {

	List<Expresion> expresiones;
	public abstract boolean evaluar(List<Expresion> hechos);

	public Operador(String descripcion) {
		super(descripcion);
		expresiones = new ArrayList<Expresion>();
	}

	public void anadir(Expresion e) {
		expresiones.add(e);
	}


}
