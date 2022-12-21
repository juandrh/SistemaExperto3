package difuso;

/**
 * Aplicaci�n creadora de sistemas expertos n�tidos o difusos
 * con base de conocimiento de ejemplo.
 * Implementa los patrones: Interpreter, Composite y factory
 * 
 * Sistema Experto Difuso
 * Interfaz para pasar funciones como par�metro
 * 
 * 
 * @author Juan Del Rio
 * @version 1.0 Dic-2022
 */
public interface Callable {
	public float call(float a,float b,float x);
}
