package nitido;

import java.util.ArrayList;
import java.util.List;
import principal.SistemaExperto;

/**
 * Aplicación creadora de sistemas expertos nítidos o difusos con base de
 * conocimiento de ejemplo.
 *  Implementa los patrones: Interpreter, Composite y factory.
 * 
 * Sistema Experto Nítido
 *  Clase principal
 * 
 * 
 * @author Juan Del Rio
 * @version 1.0 Dic-2022
 */

public class SENitido implements SistemaExperto {

	List<Expresion> hechos;
	List<String> hechosIniciales;
	List<Regla> reglas;
	List<Regla> conflictos;
	List<Expresion> resultados = new ArrayList<Expresion>();
	Expresion P, CN, TD, AD, CM, EP, DL, DC, PP, RL, RC, RD, ET, CB, ER, PA,resultado;
	String textoAMostrar;

	@Override
	public void crearVariables() {
		hechos = new ArrayList<Expresion>();
		reglas = new ArrayList<Regla>();
		conflictos = new ArrayList<Regla>();
		resultados = new ArrayList<Expresion>();
		resultado = null;
		textoAMostrar ="";

		// Crear hechos con los estados posibles
		P = new Hecho("Pedido recibido");
		CN = new Hecho("Cliente nuevo");
		TD = new Hecho("Tomar datos");
		AD = new Hecho("Artículo disponible");
		CM = new Hecho("Cliente moroso");
		EP = new Hecho("Exigir pago deuda pendiente");
		DL = new Hecho("Deuda liquidada");
		DC = new Hecho("Datos de cliente completos");
		PP = new Hecho("Procesar pedido");
		RL = new Hecho("Robot libre");
		RC = new Hecho("Robot cargado");
		RD = new Hecho("Robot disponible para uso");
		ET = new Hecho("Encargar tarea a robot");
		CB = new Hecho("Cargar batería robot");
		ER = new Hecho("Esperar a que el robot esté libre");
		PA = new Hecho("Pedir artículo a fábrica");

	}

	@Override
	public void datosEntrada(List<String> lista) {
		// Añadir hechos a la base de conocmimientos
		
		
		
		for(int i=0;i<lista.size();i++) {
			switch (lista.get(i)) { 
			    case "Pedido recibido":
			    hechos.add(P);
			     break;
			    case "Cliente nuevo":
			    	hechos.add(CN);
			     break;
			    
			    case "Artículo disponible":
			    	hechos.add(AD);
			     break;
			    case "Cliente moroso":
			    	hechos.add(CM);
				     break;
			    case "Robot libre":
			    	hechos.add(RL);
				     break;
			    case "Robot cargado":
			    	hechos.add(RC);
				     break;
			    default:
			     // Default 
		  }			
		}
		
		
		
		
		// fijar objetivos (acciones posibles a realizar)
		resultados.add(ET);
		resultados.add(CB);
		resultados.add(ER);
		resultados.add(PA);

		// Muestra hechos iniciales
		textoAMostrar += "\n" + "Hechos inciales: \n";
		for (int i = 0; i < hechos.size(); i++) {
			textoAMostrar += "\n" + hechos.get(i).toString();
		}

	}

	@Override
	public void anadirReglas() {
		// R1:= CN -> TD
		Regla R1 = new Regla(CN, TD, hechos);
		reglas.add(R1);
		// R2:= (NO(CN) Y CM) -> EP
		Operador O1 = new OpY("Y");
		Operador O2 = new OpNo("No");
		O2.anadir(CN);
		O1.anadir(O2);
		O1.anadir(CM);
		Regla R2 = new Regla(O1, EP, hechos);
		reglas.add(R2);
		// R3: EP -> DL
		Regla R3 = new Regla(EP, DL, hechos);
		reglas.add(R3);
		// R4:= TD O DL O (NoCN y NoCM) -> DC
		Operador O3 = new OpO("O");
		Operador O4 = new OpNo("No");
		Operador O5 = new OpNo("No");
		Operador O6 = new OpY("Y");
		O4.anadir(CN);
		O5.anadir(CM);
		O6.anadir(O4);
		O6.anadir(O5);
		O3.anadir(TD);
		O3.anadir(DL);
		O3.anadir(O6);
		Regla R4 = new Regla(O3, DC, hechos);
		reglas.add(R4);

		// R5:= P Y DC Y AD -> PP
		Operador O7 = new OpY("Y");
		O7.anadir(P);
		O7.anadir(DC);
		O7.anadir(AD);
		Regla R5 = new Regla(O7, PP, hechos);
		reglas.add(R5);

		// R6:= RL Y RC -> RD
		Operador O8 = new OpY("Y");
		O8.anadir(RL);
		O8.anadir(RC);
		Regla R6 = new Regla(O8, RD, hechos);
		reglas.add(R6);

		// R7:= PP Y RD -> ET
		Operador O9 = new OpY("Y");
		O9.anadir(PP);
		O9.anadir(RD);
		Regla R7 = new Regla(O9, ET, hechos);
		reglas.add(R7);

		Operador O10 = new OpNo("No");
		O10.anadir(RC);
		Regla R8 = new Regla(O10, CB, hechos);
		reglas.add(R8);
		Operador O11 = new OpNo("No");
		O11.anadir(RL);
		Regla R9 = new Regla(O11, ER, hechos);
		reglas.add(R9);
		Operador O12 = new OpNo("No");
		O12.anadir(AD);
		Regla R10 = new Regla(O12, PA, hechos);
		reglas.add(R10);

		textoAMostrar +="\nReglas: \n";
		for (int i = 0; i < reglas.size(); i++) {
			textoAMostrar += "\n" + reglas.get(i).toString();
		}

	}

	@Override
	public void ejecutarMotor() {
		// Límite máximo de repeticiones de bucle 30
		int ronda = 1;
		boolean terminado = false;
		while (ronda <= 30 && !terminado) {
			// Filtrado: Buscar conflictos
			for (int i = 0; i < reglas.size(); i++) {
				for (int j = 0; j < hechos.size(); j++) {
					Regla regla = reglas.get(i);
					if (regla.esAplicable() && !conflictos.contains(regla)) {
						conflictos.add(regla);
					}
				}
			}
			textoAMostrar += "\n" + "\n-- Ronda " + ronda + " ----\n";
			textoAMostrar += "\n" + "\nConflictos:";
			for (int i = 0; i < conflictos.size(); i++) {
				textoAMostrar += "\n" + conflictos.get(i).toString();
			}
			System.out.println("\nHechos:");
			for (int i = 0; i < hechos.size(); i++) {
				textoAMostrar += "\n" + hechos.get(i).toString() + "(" + hechos.get(i).evaluar(hechos) + ")";
			}

			// Resolución de conflictos: elegir la primera regla que aporte conocimiento
			Regla conflicto = null;
			for (int i = 0; i < conflictos.size(); i++) {
				conflicto = conflictos.get(i);

				if (!hechos.contains(conflicto.getConsecuente())) {
					// Fase de ejecución: añadir el consecuente a la base de conocimiento
					textoAMostrar += "\n" + "\nRegla aplicada: " + conflicto.toString();
					textoAMostrar += "\n" + "Añadido a base de conocimiento: " + conflicto.getConsecuente().toString();
					conflicto.aplicarRegla();
					reglas.remove(conflicto);
					if (resultados.contains(conflicto.getConsecuente())) {
						terminado = true;
						resultado = conflicto.getConsecuente();
					}
					conflictos.remove(conflicto);
					break;
				}
			}
			conflictos.clear();
			ronda++;
		}

	}

	@Override
	public String mostrarResultado() {
		if (resultado == null) {
			textoAMostrar += "\n\n" + "No se ha obtenido resultado.\nRevisar las datos de entrada y las reglas.";

		} else {
			textoAMostrar += "\n\n" + "Resultado: " + resultado.getDescripcion();
		}
		
		
		return textoAMostrar;

	}
	
	
		

}
