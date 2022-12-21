package nitido;

import java.util.List;

/**
 * Aplicación creadora de sistemas expertos nítidos o difusos con base de
 * conocimiento de ejemplo. 
 * Implementa los patrones: Interpreter, Composite y factory.
 * 
 * Sistema Experto Nítido Clase para reglas
 * 
 * 
 * @author Juan Del Rio
 * @version 1.0 Dic-2022
 */

public class Regla {

	Expresion antecedente;
	Expresion consecuente;
	List<Expresion> hechos;

	public Regla(Expresion antecedente, Expresion consecuente, List<Expresion> hechos) {
		this.antecedente = antecedente;
		this.consecuente = consecuente;
		this.hechos = hechos;
	}

	public boolean esAplicable() {
		return antecedente.evaluar(hechos);
	}

	public void aplicarRegla() {

		hechos.add(consecuente);
	}

	public Expresion getConsecuente() {

		return consecuente;
	}

	public String toString() {
		return antecedente.toString() + " -> " + consecuente.getDescripcion();
	}

}
