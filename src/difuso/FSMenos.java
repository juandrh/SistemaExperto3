package difuso;

/**
 * Aplicaci�n creadora de sistemas expertos n�tidos o difusos
 * con base de conocimiento de ejemplo.
 * Implementa los patrones: Interpreter, Composite y factory
 * 
 * Sistema Experto Difuso
 * Funci�n concreta de pertenencia 
 * 
 * 
 * @author Juan Del Rio
 * @version 1.0 Dic-2022
 */
public class FSMenos  extends FSemantica {

	@Override
	public float call(float a, float b, float x) {
		float valor;
		if (x<a) {
			valor = 1.0f;
		} else if (x<(a+b)/2) {  // punto medio 
			valor = -x;
		} else {
			valor = 0.0f;
		}		
		return valor;		
	}


	
}
