package difuso;

/**
 * Aplicación creadora de sistemas expertos nítidos o difusos
 * con base de conocimiento de ejemplo.
 * Implementa los patrones: Interpreter, Composite y factory
 * 
 * Sistema Experto Difuso
 * Interfaz para pasar funciones como parámetro
 * 
 * 
 * @author Juan Del Rio
 * @version 1.0 Dic-2022
 */
public interface Callable {
	public float call(float a,float b,float x);
}
