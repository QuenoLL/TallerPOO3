package Dominio;

/**
 * Hechizo de tipo Tierra con efecto de mejora de defensa.
 * <p>
 * La puntuación se calcula como: {@code (daño × mejoraDefensa) / 2}.
 *
 * @author [Eugenio Cortés Egaña, Matías Núñez González]
 * @version 1.0
 * @see Spell
 */

public class Ground extends Spell{
	 
	/** Puntos de mejora de defensa que otorga el hechizo.
	 */
	
	private int mejoraDefensa;
	
	/**
     * Inicializa un hechizo de tierra con sus atributos específicos.
     *
     * @param nombreHechizo el nombre identificador del hechizo
     * @param tipo          el tipo; debe ser {@code "Tierra"}
     * @param daño          los puntos de daño base del hechizo
     * @param mejoraDefensa los puntos de mejora de defensa que otorga
     */
	
	public Ground(String nombreHechizo, String tipo, int daño,int mejoraDefensa) {
		super(nombreHechizo, tipo, daño);
		this.mejoraDefensa = mejoraDefensa;
	}

	/**
     * Retorna los puntos de mejora de defensa del hechizo.
     *
     * @return los puntos de mejora de defensa
     */
	
	public int getMejoraDefensa() {
		return mejoraDefensa;
	}

	/**
     * Retorna la linea del hechizo de tierra con todos sus atributos.
     *
     * @return cadena con nombre, tipo, daño y mejora de defensa
     */
	
	@Override
	public String toString() {
		return "Nombre: "+nombreHechizo+" | Tipo:"+tipo+" | Daño:"+daño+" | Mejora Defensa: "+mejoraDefensa;
	}
	
	/**
     * Calcula la puntuación del hechizo de tierra.
     * <p>
     * Fórmula: {@code (daño × mejoraDefensa) / 2}.
     *
     * @return el resultado de la fórmula de puntuación
     */
	
	@Override
	public double puntuacion() {
		double puntero = (this.daño * this.mejoraDefensa)/2;
		return puntero;
	}
	
	/**
     * Genera la línea de texto para que exista el hechizo de tierra en el archivo.
     *
     * @return cadena con nombre, tipo, daño y mejora de defensa separados por {@code ;}
     */
	
	@Override
	public String lineaTxt() {
		String linea = this.nombreHechizo+";"+this.tipo+";"+this.daño+";"+this.mejoraDefensa;
		return linea;
	}
	
	/**
     * Modifica un atributo específico del hechizo de tierra según la opcion indicada.
     * <p>
     * OPciones disponibles:
     * <ul>
     *   <li>{@code 1} — mejora de defensa</li>
     * </ul>
     *
     * @param opcion la clave numérica del atributo a modificar
     * @param valor  el nuevo valor entero para el atributo
     */
	
	@Override
	public void settAtributo(int opcion, int valor) {
		switch(opcion) {
		case 1:
			this.mejoraDefensa = valor;
			break;
		}
	}
	
	/**
     * Retorna el menú de atributos modificables del hechizo de tierra.
     *
     * @return cadena con las opciones numeradas de atributos
     */
	
	@Override
	public String getMenuAtributos() {
		String linea = "1.- Mejora Defensa";
		return linea;
	}
	
	/**
     * Retorna la cantidad de atributos modificables.
     *
     * @return {@code 1}, correspondiente a la mejora de defensa
     */
	
	@Override
	public int getContadorAtributos() {
		return 1;
	}

	
}
