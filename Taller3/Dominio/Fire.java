package Dominio;

/**
 * Hechizo de tipo Fuego con efecto de quemadura prolongada.
 * <p>
 * La puntuación se calcula multiplicando el daño base por la duración
 * de la quemadura: {@code daño x duracion}.
 *
 * @author [Eugenio Cortés Egaña, Matías Núñez González]
 * @version 1.0
 * @see Spell
 */

public class Fire extends Spell{
	
	/** Duración en turnos del efecto de quemadura.
	*/
	
	private int duracion;
	
	/**
     * Inicializa un hechizo de fuego con sus atributos.
     *
     * @param nombreHechizo el nombre identificador del hechizo
     * @param tipo          el tipo; debe ser {@code "Fuego"}
     * @param daño          los puntos de daño base del hechizo
     * @param duracion      la duración en turnos del efecto de quemadura
     */
	
	public Fire(String nombreHechizo, String tipo, int daño,int duracion) {
		super(nombreHechizo, tipo, daño);
		this.duracion = duracion;
	}

	/**
     * Retorna la duración del efecto de quemadura.
     *
     * @return la duración en turnos
     */
	
	public int getDuracion() {
		return duracion;
	}

	/**
     * Retorna la linea del texto del hechizo de fuego con todos sus atributos.
     *
     * @return cadena con nombre, tipo, daño y duración de quemadura
     */
	
	@Override
	public String toString() {
		return "Nombre: "+nombreHechizo+" | Tipo: "+tipo+" | Daño: "+daño+" | Duracion Quemadura: "+duracion;
	}
	
	/**
     * Calcula la puntuación del hechizo de fuego.
     * <p>
     * Fórmula: {@code daño × duracion}.
     *
     * @return el resultado de aplicar la formula (daño x duracion)
     */
	
	@Override
	public double puntuacion() {
		double puntero = this.daño * this.duracion;
		return puntero;
	}
	
	/**
     * Genera la línea de texto para la existencia del hechizo de fuego en el archivo.
     *
     * @return cadena con nombre, tipo, daño y duración separados por {@code ;}
     */
	
	@Override
	public String lineaTxt() {
		String linea = this.nombreHechizo+";"+this.tipo+";"+this.daño+";"+this.duracion;
		return linea;
	}
	
	/**
     * Modifica un atributo específico del hechizo de fuego según la opcion indicada.
     * <p>
     * Opciones disponibles:
     * <ul>
     *   <li>{@code 1} — duración de quemadura</li>
     * </ul>
     *
     * @param opcion número del atributo a modificar
     * @param valor  el nuevo valor entero para el atributo
     */
	
	@Override
	public void settAtributo(int opcion, int valor) {
		switch(opcion) {
		case 1:
			this.duracion = valor;
		}
	}
	
	/**
     * Retorna el menú de atributos específicos modificables del hechizo de fuego.
     *
     * @return cadena con las opciones numeradas de atributos
     */
	
	@Override
	public String getMenuAtributos() {
		String linea = "1.- Duracion Quemadura";
		return linea;
	}
	
	/**
     * Retorna la cantidad de atributos modificables.
     *
     * @return {@code 1}, correspondiente a la duración de quemadura
     */
	
	@Override
	public int getContadorAtributos() {
		return 1;
	}

	
	
	

}
