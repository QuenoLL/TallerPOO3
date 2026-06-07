package Dominio;

/**
 * MUestra abstracta de un hechizo mágico.
 * <p>
 * Define los atributos y comportamientos comunes a todos los tipos de hechizo
 * del sistema. Las subclases deben implementar la lógica específica
 * de puntuación y modificación de atributos.
 *
 * @author [Eugenio Cortés Egaña, Matías Núñez González]
 * @version 1.0
 * @see Fire
 * @see Ground
 * @see Grass
 * @see Water
 */

public abstract class Spell implements Condicional{
	
	/** Nombre identificador del hechizo. 
	*/
	
	protected String nombreHechizo;
	
	/** Tipo elemental del hechizo (Fuego, Tierra, Planta o Agua). 
	*/
	
	protected String tipo;
	
	 /** Puntos de daño base que inflige el hechizo.
	 */
	
	protected int daño;
	
	 /**
     * Inicializa un hechizo con sus atributos base.
     *
     * @param nombreHechizo el nombre identificador del hechizo
     * @param tipo          el tipo del hechizo
     * @param daño          los puntos de daño base del hechizo
     */
	
	public Spell(String nombreHechizo, String tipo, int daño) {
		this.nombreHechizo = nombreHechizo;
		this.tipo = tipo;
		this.daño = daño;
	}

	 /**
     * Retorna el nombre del hechizo.
     *
     * @return el nombre identificador del hechizo
     */
	
	public String getNombreHechizo() {
		return nombreHechizo;
	}
 
	/**
     * Retorna el tipo del hechizo.
     *
     * @return el tipo como {@code String}
     */
	
	public String getTipo() {
		return tipo;
	}

	/**
     * Retorna el daño base del hechizo.
     *
     * @return los puntos de daño base
     */
	
	public int getDaño() {
		return daño;
	}

	/**
     * Asigna un nuevo valor de daño base al hechizo.
     *
     * @param daño el nuevo valor de daño, debe ser mayor o igual a cero
     */
	
	public void setDaño(int daño) {
		this.daño = daño;
	}

	/**
     * Retorna la linea del hechizo con sus atributos principales.
     *
     * @return cadena con nombre, tipo y daño del hechizo
     */
	
	@Override
	public String toString() {
		return "Spell [nombreHechizo=" + nombreHechizo + ", tipo=" + tipo + ", daño=" + daño + "]";
	}
	
	/**
     * Calcula la puntuación del hechizo según su tipo concreto.
     * <p>
     * La implementación por defecto retorna {@code 0.0}; cada subclase
     * debe sobreescribir este método con su propia fórmula.
     *
     * @return la puntuación calculada del hechizo
     */
	
	@Override
	public double puntuacion() {
		return 0.0;
		
	}
	
	/**
     * Genera la línea de texto para que el hechizo exista en archivo.
     *
     * @return cadena con los atributos separados por {@code ;}, o {@code null}
     *         si la subclase no implementa el método
     */
	
	@Override
	public String lineaTxt() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
     * Modifica un atributo específico del hechizo identificado por una opcion numérica.
     * <p>
     * Cada subclase define qué opcion corresponde a qué atributo propio.
     *
     * @param opcion la clave numérica del atributo a modificar
     * @param valor  el nuevo valor entero para el atributo
     */
	
	public abstract void settAtributo(int opcion, int valor);
	
	/**
     * Retorna un menú textual con los atributos modificables del hechizo.
     *
     * @return cadena con las opciones numeradas de atributos específicos
     */
	
	public abstract String getMenuAtributos();
	
	/**
     * Retorna la cantidad de atributos específicos modificables del hechizo.
     *
     * @return número de atributos propios de la subclase
     */
	
	public abstract int getContadorAtributos();
	
	
	
	
	


}
