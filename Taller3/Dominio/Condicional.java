package Dominio;

/**
 * Contrato que deben cumplir las variables del sistema .
 * <p>
 * Define las operaciones comunes de puntuación y de texto
 * que son requeridas tanto por magos como por hechizos.
 * 
 * @author [Eugenio Cortés Egaña, Matías Núñez González]
 * @version 1.0
 */

public interface Condicional {
	
	/**
     * Calcula y retorna la puntuación.
     * 
     * @return la puntuación calculada según las reglas de la variable
     */
	
	double puntuacion();
	
	/**
     * Genera una linea de texto para que se use con el archivo.
     * 
     * @return cadena de texto con los atributos del objeto separados por {@code ;}
     */
	
	String lineaTxt();

}
