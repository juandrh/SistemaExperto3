package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Aplicación creadora de sistemas expertos nítidos o difusos
 * con base de conocimiento de ejemplo.
 * Implementa los patrones: Interpreter, Composite y factory
 * 
 * Clase Principal: llama al creador y ejecuta el sistema elegido 
 * 
 * 
 * @author Juan Del Rio
 * @version 1.0 Dic-2022
 */


public class Principal {

	public static void main(String[] args) {

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		Boolean entradaPendiente = true;
		CreadorSistemaExperto creador;
		
		
		
		while (entradaPendiente) {
			try {
				System.out.println("Selecciona el sistema experto a crear  (1-Nitido, 2-Difuso):");
				String texto = br.readLine();
				// Elección del creador del sistema concreto
				if (texto.equals("1")) {
					creador = new CreadorSistemaExpertoNitido(); 
					ejecutaSistema(creador);
					entradaPendiente = false;
				}
				if (texto.equals("2")) {
					creador = new CreadorSistemaExpertoDifuso();
					ejecutaSistema(creador);
					entradaPendiente = false;
				}
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		
		
		
		
		System.out.println("Saliendo del sistema");
	}

	private static void ejecutaSistema(CreadorSistemaExperto creador) {

		creador.crearVariables(); // Variables globales del sistema
		creador.datosEntrada(); // Base de conocimiento: Inputs, Hechos
		creador.anadirReglas(); // Base de conocimiento: Reglas
		creador.ejecutarMotor(); // Motor de inferencia
		creador.mostrarResultado(); // Acción a realizar

	}

}
