package difuso;

/**
 * Aplicaci�n creadora de sistemas expertos n�tidos o difusos con base de
 * conocimiento de ejemplo. 
 * Implementa los patrones: Interpreter, Composite y factory.
 * 
 * Sistema Experto Difuso
 * Clase operador
 * 
 * @author Juan Del Rio
 * @version 1.0 Dic-2022
 */


public abstract class Operador {

	
	public abstract void anadir(FSemantica f, Variable v);
	public abstract float evaluar(float x, float y);
	public abstract void setLimite(float limite);

}
