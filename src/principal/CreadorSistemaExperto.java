package principal;

import java.util.List;

/**
 * Aplicación creadora de sistemas expertos nítidos o difusos
 * con base de conocimiento de ejemplo.
 * Implementa los patrones: Interpreter, Composite y factory
 * 
 * Creador de sistemas expertos
 * 
 * 
 * @author Juan Del Rio
 * @version 1.0 Dic-2022
 */

public abstract class CreadorSistemaExperto {
	
	SistemaExperto sistema;
	public abstract SistemaExperto crearSistemaExperto();
	
	public void crearVariables() {
		sistema = crearSistemaExperto();
		sistema.crearVariables();
		}
	
	public void datosEntrada(List<String> listaHechosIniciales) {		
		sistema.datosEntrada(listaHechosIniciales);
		}
	public void anadirReglas() {		
		sistema.anadirReglas();
		}
	public void ejecutarMotor() {		
		sistema.ejecutarMotor();
		}
	public String mostrarResultado() {		
		return sistema.mostrarResultado();
		}
	
	
	
}
