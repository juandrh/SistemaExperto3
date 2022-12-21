package nitido;

import java.util.List;

/**
 * Aplicación creadora de sistemas expertos nítidos o difusos con base de
 * conocimiento de ejemplo. 
 * Implementa los patrones: Interpreter, Composite y factory.
 * 
 * Sistema Experto Nítido 
 * Clase componente del patron composite
 * 
 * @author Juan Del Rio
 * @version 1.0 Dic-2022
 */

public abstract class Expresion {

	protected String descripcion;	
	
	public Expresion (String descripcion) {		
		this.descripcion = descripcion;		
	}
	
	public String getDescripcion () {		
		return descripcion;		
	}
	
	public abstract boolean evaluar(List<Expresion> hechos);	
		
	public abstract String toString() ;
		
	
	

}
