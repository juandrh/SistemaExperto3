package difuso;

import java.util.ArrayList;

import java.util.List;
/**
 * Aplicaci�n creadora de sistemas expertos n�tidos o difusos
 * con base de conocimiento de ejemplo.
 * Implementa los patrones: Interpreter, Composite y factory
 * 
 * Sistema Experto Difuso
 * Operador de agregaci�n, implementa los m�todos de la clase padre
 * 
 * 
 * @author Juan Del Rio
 * @version 1.0 Dic-2022
 */
public class OpO extends Operador{

	List<FSemantica> funciones;
	Variable variable;
	float limite;

	public OpO() {
		funciones = new ArrayList<FSemantica>();		
	}

	public void anadir(FSemantica f, Variable variable) {
		this.variable = variable;
		funciones.add(f);
	}
	
	public void setLimite(float limite) {
		this.limite = limite;
	}
	

	public float evaluar(float x,float y) {

		float max = 0.0f;

		for (int i = 0; i < funciones.size(); i++) {			
			//m�nimo entre el valor del consecuente y el valor del antecedente
			float valor = Math.min(funciones.get(i).call(variable.a, variable.b, x),limite);			
			if (valor > max) {
				max = valor;
			}
		}
		return max;
	}

	

}
