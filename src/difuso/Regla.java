package difuso;

/**
 * Aplicación creadora de sistemas expertos nítidos o difusos
 * con base de conocimiento de ejemplo.
 * Implementa los patrones: Interpreter, Composite y factory
 * 
 * Sistema Experto Difuso
 * Clase que implementa las reglas
 * 
 * 
 * @author Juan Del Rio
 * @version 1.0 Dic-2022
 */
public class Regla {

	Operador op;	
	FSemantica fConsecuente;
	Variable vConsecuente;
		

	public Regla(Operador op,FSemantica fConsecuente, Variable vConsecuente) {
		this.op = op;
		this.fConsecuente = fConsecuente;
		this.vConsecuente = vConsecuente;
		
	}

	public float evaluaAntecedente(float x,float y) {
			
		return op.evaluar(x,y);
	}
	
	public FSemantica getFConsecuente() {
		
		return fConsecuente;
	}
		
	public String toString() {		
		return "";
	}
	
	

}
