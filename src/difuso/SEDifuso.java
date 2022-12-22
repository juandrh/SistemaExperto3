package difuso;

import java.util.ArrayList;
import java.util.List;



import principal.SistemaExperto;

/**
 * Aplicación creadora de sistemas expertos nítidos o difusos
 * con base de conocimiento de ejemplo.
 * Implementa los patrones: Interpreter, Composite y factory
 * 
 * Sistema Experto Difuso
 * Clase principal
 * 
 * 
 * @author Juan Del Rio
 * @version 1.0 Dic-2022
 */


public class SEDifuso implements SistemaExperto {

	Variable V;
	Variable B;
	Variable P;
	List<Operador> operadores;
	List<Regla> reglas;
	List<Regla> conflictos;
	List<Float> limitesConflictos;
	List<Float> entradasVelocidad; // datos recogidos por los sensores
	List<Float> entradasBateria;	  // datos recogidos por los sensores
	List<Float> valoresNitidificados;
	float[][] datos;
	String textoAMostrar;
	

	
	@Override
	public void crearVariables() {
		

		operadores = new ArrayList<Operador>();  // lista de operadores que formarán los antecedentes de las reglas
		reglas = new ArrayList<Regla>();
		conflictos = new ArrayList<Regla>(); // lista de reglas a aplicar con una entrada de datos
		limitesConflictos = new ArrayList<Float>(); // lista valores límite que se obtienen de los antecedentes
		entradasVelocidad = new ArrayList<Float>();  
		entradasBateria = new ArrayList<Float>(); 	 
		valoresNitidificados = new ArrayList<Float>(); 
		datos= new float[21][21];
		textoAMostrar ="-------------------------------------------------------------------------------------------------------------------------------------------------";

	}

	@Override
	public void datosEntrada(List<String> lista) {
		// Se ha integrado en el motor de inferencia para proporcionar
		//  un rango de valores combinando las dos variables de entrada
		
		float x1 =  (float) (Float.parseFloat(lista.get(0).toString())/100.0);
		float x2 =  (float) (Float.parseFloat(lista.get(1).toString())/100.0);
		float x3 =  (float) (Float.parseFloat(lista.get(2).toString())/100.0);
		float x4 =  (float) (Float.parseFloat(lista.get(3).toString())/100.0);
		float x5 =  (float) (Float.parseFloat(lista.get(4).toString())/100.0);
		float x6 =  (float) (Float.parseFloat(lista.get(5).toString())/100.0);
		
		
		
		
		
		
		
		V = new Variable("Diferencia con velocidad media", x1, x2);// negativa, cero, positiva
		B = new Variable("Diferencia con nivel medio bateria",x3, x4);  // -0.50f, 0.50f);  // negativa, cero, positiva
		P = new Variable("Potencia a aplicar", x5, x6); // reducir, mantener, aumentar
		
		textoAMostrar += "\nParam_a1: "+x1+", Param_b1: " +x2;
		textoAMostrar += "\nParam_a2: "+x3+", Param_b2: " +x4;
		textoAMostrar += "\nParam_a3: "+x5+", Param_b3: " +x6+ "\n";
		
		
		
		
	}

	@Override
	public void anadirReglas() {
		
		// lista de operadores de intersección para crear los antecedentes
		for (int i = 0; i < 9; i++) {
			operadores.add(new OpY());
		}
		// R1: (
		operadores.get(0).anadir(new FSMenos(), V);
		operadores.get(0).anadir(new FSMenos(), B);
		Regla R0 = new Regla(operadores.get(0), new FSMas(), P);
		reglas.add(R0);

		operadores.get(1).anadir(new FSMenos(), V);
		operadores.get(1).anadir(new FSIgual(), B);
		Regla R1 = new Regla(operadores.get(1), new FSMas(), P);
		reglas.add(R1);

		operadores.get(2).anadir(new FSMenos(), V);
		operadores.get(2).anadir(new FSMas(), B);
		Regla R2 = new Regla(operadores.get(2), new FSIgual(), P);
		reglas.add(R2);

		operadores.get(3).anadir(new FSIgual(), V);
		operadores.get(3).anadir(new FSMenos(), B);
		Regla R3 = new Regla(operadores.get(3), new FSMas(), P);
		reglas.add(R3);

		operadores.get(4).anadir(new FSIgual(), V);
		operadores.get(4).anadir(new FSIgual(), B);
		Regla R4 = new Regla(operadores.get(4), new FSIgual(), P);
		reglas.add(R4);

		operadores.get(5).anadir(new FSIgual(), V);
		operadores.get(5).anadir(new FSMas(), B);
		Regla R5 = new Regla(operadores.get(5), new FSMenos(), P);
		reglas.add(R5);

		operadores.get(6).anadir(new FSMas(), V);
		operadores.get(6).anadir(new FSMenos(), B);
		Regla R6 = new Regla(operadores.get(6), new FSIgual(), P);
		reglas.add(R6);

		operadores.get(7).anadir(new FSMas(), V);
		operadores.get(7).anadir(new FSIgual(), B);
		Regla R7 = new Regla(operadores.get(7), new FSMenos(), P);
		reglas.add(R7);

		operadores.get(8).anadir(new FSMas(), V);
		operadores.get(8).anadir(new FSMas(), B);
		Regla R8 = new Regla(operadores.get(8), new FSMenos(), P);
		reglas.add(R8);

	}

	// Motor de inferencia
	@Override
	public void ejecutarMotor() {
		
		//float delta = 0.1f;
		
		
		for (int j = 0; j < 21; j++) {
			for (int k = 0; k < 21; k++) {
			
		float resultadoAntecedente = 0.0f;
		
		// Paso 1. Evaluación del antecedente de cada regla
		for (int i = 0; i < reglas.size(); i++) {
			resultadoAntecedente = reglas.get(i).evaluaAntecedente((j-10.0f)/10.0f, (k-10.0f)/10.0f);
			if (resultadoAntecedente != 0) {
				conflictos.add(reglas.get(i));
				limitesConflictos.add(resultadoAntecedente);
			}
		}
		textoAMostrar += "\n" +  "Nº reglas que se activan: " + conflictos.size();

		// Paso 2. Obtener la conclusión de cada regla y agregar
		Operador agregacion = new OpO();

		for (int i = 0; i < conflictos.size(); i++) {
			agregacion.anadir(conflictos.get(i).getFConsecuente(), P);
			agregacion.setLimite(limitesConflictos.get(i));
		}
		
		// Paso 3. Nitidificación, búsqueda del centro de masa
		
		float sumaNumerador = 0.0f;
		float sumaDenominador = 0.0f;
		float intervalo = 0.02f;
		for (float i = -1.0f; i <= 1.0f; i=i+intervalo) {
			float v = agregacion.evaluar(i,0.0f);
			sumaNumerador += i * v;
			sumaDenominador += v;
		}
		
		datos[j][k]=sumaNumerador / sumaDenominador;
		
		textoAMostrar += "\n" + "Valor nitidificado (porcentaje de potencia a aplicar al motor): " + datos[j][k]*100 +" %.";
		conflictos.clear();
		limitesConflictos.clear();
			}
		}
		

	}

	@Override
	public String mostrarResultado() {
		
		return textoAMostrar;


	}
	
	

}
