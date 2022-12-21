package difuso;

/**
 * Aplicación creadora de sistemas expertos nítidos o difusos
 * con base de conocimiento de ejemplo.
 * Implementa los patrones: Interpreter, Composite y factory
 * 
 * Sistema Experto Difuso
 * Función concreta de pertenencia 
 * 
 * 
 * @author Juan Del Rio
 * @version 1.0 Dic-2022
 */
public class FSIgual extends FSemantica {

	@Override
	public float call(float a, float b, float x) {
		  float valor;
			if (x<a || x>b) {
				valor = 0.0f;
			} else if (x<(a+b)/2) {
				valor = x/b+1.0f;
			} else {
				valor = -x/b+1.0f;
			}	
			return valor;
	}


	
}
