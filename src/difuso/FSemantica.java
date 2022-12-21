package difuso;

/**
 * Aplicación creadora de sistemas expertos nítidos o difusos
 * con base de conocimiento de ejemplo.
 * Implementa los patrones: Interpreter, Composite y factory
 * 
 * Sistema Experto Difuso
 * Crea una función para pasar como parámetro a otra función
 * 
 * 
 * @author Juan Del Rio
 * @version 1.0 Dic-2022
 */

public abstract class FSemantica implements Callable {
	
	public abstract float call(float a, float b, float x) ;
	
}
