package Dominio;

/**
 * Hechizo de tipo planta con efecto de stun y generación de plantas.
 * <p>
 * La puntuación se calcula como: {@code daño + (duracionStun × cantPlantas)}.
 *
 * @author [Eugenio Cortés Egaña, Matías Núñez González]
 * @version 1.0
 * @see Spell
 */

public class Grass extends Spell{
	
    /** Duración en turnos del efecto de stun. 
    */

	private int duracionStun;
	
    /** Cantidad de plantas generadas por el hechizo. 
    */

	private int cantPlantas;
	
	/**
     * Inicializa un hechizo de planta con sus atributos específicos.
     *
     * @param nombreHechizo el nombre identificador del hechizo
     * @param tipo          el tipo; debe ser {@code "Planta"}
     * @param daño          los puntos de daño base del hechizo
     * @param duracionStun  la duración en turnos del efecto de stun
     * @param cantPlantas   la cantidad de plantas generadas
     */
	
	public Grass(String nombreHechizo, String tipo, int daño,int duracionStun,int cantPlantas) {
		super(nombreHechizo, tipo, daño);
		this.duracionStun = duracionStun;
		this.cantPlantas = cantPlantas;
	}

	/**
     * Retorna la duración del efecto de stun.
     *
     * @return la duración en turnos del stun
     */
	
	public int getDuracionStun() {
		return duracionStun;
	}

	/**
     * Retorna la cantidad de plantas generadas.
     *
     * @return la cantidad de plantas
     */
	
	public int getCantPlantas() {
		return cantPlantas;
	}

	/**
     * Retorna la linea del hechizo de planta con todos sus atributos.
     *
     * @return cadena con nombre, tipo, daño, duración de stun y cantidad de plantas
     */
	
	@Override
	public String toString() {
		return "Nombre: "+nombreHechizo+" | Tipo: "+tipo+" | Daño: "+daño+" | Duracion Stun: "+duracionStun+" | Cantidad plantas: "+cantPlantas;
	}
	
	/**
     * Calcula la puntuación del hechizo de planta.
     * <p>
     * Fórmula: {@code daño + (duracionStun × cantPlantas)}.
     *
     * @return el resultado de la fórmula de puntuación
     */
	
	@Override
	public double puntuacion() {
		double puntero = this.daño + (this.duracionStun * this.cantPlantas);
		return puntero;
	}
	
	/**
     * Genera la línea de texto para que exista el hechizo de planta en el archivo.
     *
     * @return cadena con nombre, tipo, daño, duración de stun y cantidad de plantas
     *         separados por {@code ;} y coma según corresponda
     */
	
	@Override
	public String lineaTxt() {
		String linea = this.nombreHechizo+";"+this.tipo+";"+this.daño+";"+this.duracionStun+","+cantPlantas;
		return linea;
	}
	
	/**
     * Modifica un atributo específico del hechizo de planta según la opcion indicada.
     * <p>
     * Opciones disponibles:
     * <ul>
     *   <li>{@code 1} — duración del stun</li>
     *   <li>{@code 2} — cantidad de plantas</li>
     * </ul>
     *
     * @param opcion la clave numérica del atributo a modificar
     * @param valor  el nuevo valor entero para el atributo
     */
	
	@Override
	public void settAtributo(int opcion, int valor) {
		switch(opcion) {
		case 1:
			this.duracionStun = valor;
			break;
		case 2:
			this.cantPlantas = valor;
			break;
		}
		
	}
	
	/**
     * Retorna el menú de atributos modificables del hechizo de planta.
     *
     * @return cadena con las opciones numeradas de atributos
     */
	
	@Override
	public String getMenuAtributos() {
		String linea = "1.- Duracion del Stun"
				+ "\n2.- Cantidad de Plantas";
		return linea;
	}
	
	/**
     * Retorna la cantidad de atributos modificables.
     *
     * @return {@code 2}, correspondientes a duración de stun y cantidad de plantas
     */
	
	@Override
	public int getContadorAtributos() {
		return 2;
	}
	
	
	
	
	
	
}
