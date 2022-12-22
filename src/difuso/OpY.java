package difuso;

import java.util.ArrayList;
import java.util.List;
/**
 * Aplicación creadora de sistemas expertos nítidos o difusos
 * con base de conocimiento de ejemplo.
 * Implementa los patrones: Interpreter, Composite y factory
 * 
 * Sistema Experto Difuso
 * Operador de interseccion, implementa los métodos de la clase padre
 * 
 * 
 * @author Juan Del Rio
 * @version 1.0 Dic-2022
 */
public class OpY extends Operador {

	List<FSemantica> funciones;
	List<Variable> variables;

	public OpY () {		
		funciones = new ArrayList<FSemantica>();
		variables = new ArrayList<Variable>();
	}
	
	public void anadir(FSemantica f, Variable v)  {
		// Máximo de operandos = 2
		if (funciones.size() <2) {
			funciones.add(f);
			variables.add(v);
		}
		
	}
	
	public float evaluar(float x, float y) {
		
		float r1=funciones.get(0).call(variables.get(0).a, variables.get(0).b, x);
		float r2=funciones.get(1).call(variables.get(1).a, variables.get(1).b, y);			
		float resultado = Math.min(r1,r2);		
		return resultado;
	}

	@Override
	public void setLimite(float limite) {
		// Sin funcionalidad. No se necesita en esta clase
		
	}

	
}
