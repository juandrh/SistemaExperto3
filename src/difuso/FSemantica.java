package difuso;

/**
 * Aplicaci�n creadora de sistemas expertos n�tidos o difusos
 * con base de conocimiento de ejemplo.
 * Implementa los patrones: Interpreter, Composite y factory
 * 
 * Sistema Experto Difuso
 * Crea una funci�n para pasar como par�metro a otra funci�n
 * 
 * 
 * @author Juan Del Rio
 * @version 1.0 Dic-2022
 */

public abstract class FSemantica implements Callable {
	
	public abstract float call(float a, float b, float x) ;
	
}
