package Dominio;

import java.util.List;

/**
 * Un mago con su colección de hechizos.
 * <p>
 * La puntuación de un mago corresponde a la suma de las puntuaciones
 * de todos los hechizos que tiene asignados.
 *
 * @author [Eugenio Cortés Egaña, Matías Núñez González]
 * @version 1.0
 * @see Spell
 * @see Condicional
 */

public class Mage implements Condicional{
	
	/** Nombre identificador del mago. */
	
	private String nombre;
	
	/** Lista de hechizos asignados al mago. */
	
	private List<Spell> listaHechizos;
	
	/**
     * Inicializa un mago con su nombre y lista de hechizos.
     *
     * @param nombre         el nombre identificador del mago
     * @param listaHechizos  la lista inicial de hechizos asignados al mago
     */
	
	public Mage(String nombre, List<Spell> listaHechizos) {
		this.nombre = nombre;
		this.listaHechizos = listaHechizos;
	}

	/**
     * Retorna el nombre del mago.
     *
     * @return el nombre identificador del mago
     */
	
	public String getNombre() {
		return nombre;
	}

	/**
     * Retorna la lista de hechizos del mago.
     *
     * @return la lista de {@link Spell} asignados al mago
     */
	
	public List<Spell> getListaHechizos() {
		return listaHechizos;
	}
	
	/**
     * Agrega un hechizo a la lista del mago.
     *
     * @param hechizo el {@link Spell} a agregar
     */
	
	public void addSpell(Spell hechizo) {
		this.listaHechizos.add(hechizo);
	}
	
	/**
     * Elimina un hechizo de la lista del mago.
     *
     * @param hechizo el {@link Spell} a eliminar
     */
	
	public void removeSpell(Spell hechizo) {
		this.listaHechizos.remove(hechizo);
	}

	/**
     * Retorna la linea del mago con su nombre y los nombres de sus hechizos.
     *
     * @return cadena con el nombre del mago y los nombres de sus hechizos separados por {@code |}
     */
	
	@Override //Se debera imprimir con los hechizos???...
	public String toString() {
		String linea = "Nombre: "+nombre+" | Hechizos: ";
		for(int i = 0; i < listaHechizos.size(); i++) {
			linea += listaHechizos.get(i).getNombreHechizo();
			if(i != listaHechizos.size()-1) {
				linea += "|";
			}
		}
		
		return linea;
		
	}
	
	/**
     * Genera la línea de texto para que el mago exista en el archivo.
     *
     * @return cadena con el nombre del mago seguido de los nombres de sus hechizos
     *         separados por {@code ;}
     */
	
	@Override
	public String lineaTxt() {
		String lista = this.nombre + ";";
		
		for(int i = 0; i < listaHechizos.size(); i++) {
			lista += listaHechizos.get(i).getNombreHechizo();
			
			if(i != listaHechizos.size() - 1) {
				lista += "|";
			}
		}
		
		return lista;
	}
	
	/**
     * Calcula la puntuación total del mago.
     * <p>
     * Corresponde a la suma de las puntuaciones de todos los hechizos asignados.
     *
     * @return la suma de {@code puntuacion()} de cada hechizo en la lista
     */
	
	@Override
	public double puntuacion() {
		double puntero = 0;
		
		for(Spell hechizo : listaHechizos) {
			puntero += hechizo.puntuacion();
		}
		
		return puntero;
	}

	
	
	
	
	
	
	
	
	
	

}
