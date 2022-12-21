package difuso;

/**
 * Aplicación creadora de sistemas expertos nítidos o difusos
 * con base de conocimiento de ejemplo.
 * Implementa los patrones: Interpreter, Composite y factory
 * 
 * Sistema Experto Difuso
 * Clase que implementa las variables 
 * 
 * 
 * @author Juan Del Rio
 * @version 1.0 Dic-2022
 */
public class Variable  {

		public String descripcion;
		public float a,b;
	
	  public Variable(String descripcion, float a, float b ) { // a, b puntos de cambio de la función de pertenencia
		  this.descripcion = descripcion;
		  this.a = a;
		  this.b = b;
		  }

	
	public String toString() {		
		return descripcion;
	}

	
}
