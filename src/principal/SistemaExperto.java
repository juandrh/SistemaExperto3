package principal;

import java.util.List;

/**
 * Aplicaci�n creadora de sistemas expertos n�tidos o difusos
 * con base de conocimiento de ejemplo.
 * Implementa los patrones: Interpreter, Composite y factory
 * 
 * Interfaz para los sistemas expertos concretos
 * Clase producto del patr�n factor�a
 * 
 * @author Juan Del Rio
 * @version 2.0 Dic-2022
 */

public interface SistemaExperto {
	
	public abstract void crearVariables();
	public abstract void datosEntrada(List<String> lista);  // Base de conocimiento: Inputs, Hechos 
	public abstract void anadirReglas();  // Base de conocimiento: Reglas
	public abstract void ejecutarMotor();  // Motor inferencia
	public abstract String mostrarResultado(); // Acci�n a realizar

}
