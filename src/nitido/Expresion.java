package nitido;

import java.util.List;

/**
 * Aplicaci?n creadora de sistemas expertos n?tidos o difusos con base de
 * conocimiento de ejemplo. 
 * Implementa los patrones: Interpreter, Composite y factory.
 * 
 * Sistema Experto N?tido 
 * Clase componente del patron composite
 * Clase expresi?n del patron interpreter
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
	
	// M?todos abstactos a implementar por las clases hijo
	public abstract boolean evaluar(List<Expresion> hechos);		
	public abstract String toString() ;
		
	
	

}
