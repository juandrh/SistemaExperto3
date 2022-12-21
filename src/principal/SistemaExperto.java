package principal;

/**
 * Aplicaci�n creadora de sistemas expertos n�tidos o difusos
 * con base de conocimiento de ejemplo.
 * Implementa los patrones: Interpreter, Composite y factory
 * 
 * Interfaz para los sistemas expertos concretos
 * 
 * 
 * @author Juan Del Rio
 * @version 1.0 Dic-2022
 */

public interface SistemaExperto {
	
	public abstract void crearVariables();
	public abstract void datosEntrada();  // Base de conocimiento: Inputs, Hechos 
	public abstract void anadirReglas();  // Base de conocimiento: Reglas
	public abstract void ejecutarMotor();  // Motor inferencia
	public abstract void mostrarResultado(); // Acci�n a realizar

}
