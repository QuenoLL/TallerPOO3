package Dominio;

/**
 * Hechizo de tipo Agua con efecto de curación y presión de agua.
 * <p>
 * La puntuación se calcula como: {@code (daño + cantHeal + presionAgua) × 2}.
 *
 * @author [Eugenio Cortés Egaña, Matías Núñez González]
 * @version 1.0
 * @see Spell
 */

public class Water extends Spell{

	/** Cantidad de puntos de vida que recupera el hechizo. 
	*/
	
	private int cantHeal;
	
	/** Nivel de presión del agua del hechizo.
	*/
	
	private int presionAgua;
	
	/**
     * Inicializa un hechizo de agua con sus atributos específicos.
     *
     * @param nombreHechizo el nombre identificador del hechizo
     * @param tipo          el tipo; debe ser {@code "Agua"}
     * @param daño          los puntos de daño base del hechizo
     * @param cantHeal      la cantidad de puntos de vida que recupera
     * @param presionAgua   el nivel de presión del agua
     */
	
	public Water(String nombreHechizo, String tipo, int daño, int cantHeal,int presionAgua) {
		super(nombreHechizo, tipo, daño);
		this.cantHeal = cantHeal;
		this.presionAgua = presionAgua;
	}

	/**
     * Retorna la cantidad de curación del hechizo.
     *
     * @return los puntos de vida que recupera
     */
	
	public int getCantHeal() {
		return cantHeal;
	}

	/**
     * Retorna el nivel de presión del agua.
     *
     * @return el nivel de presión del agua
     */
	
	public int getPresionAgua() {
		return presionAgua;
	}

	/**
     * Asigna un nuevo valor de curación al hechizo.
     *
     * @param cantHeal la nueva cantidad de puntos de vida a recuperar
     */
	
	public void setCantHeal(int cantHeal) {
		this.cantHeal = cantHeal;
	}

	/**
     * Asigna un nuevo nivel de presión del agua al hechizo.
     *
     * @param presionAgua el nuevo nivel de presión del agua
     */
	
	public void setPresionAgua(int presionAgua) {
		this.presionAgua = presionAgua;
	}

	/**
     * Retorna la linea del hechizo de agua con todos sus atributos.
     *
     * @return cadena con nombre, tipo, daño, cantidad de heal y presión del agua
     */
	
	@Override
	public String toString() {
		return "Nombre: "+nombreHechizo+" | Tipo: "+tipo+" | Daño: "+daño+" | Cantidad de Heal: "+cantHeal+" | Presion del Agua: "+presionAgua;
	}
	
	/**
     * Calcula la puntuación del hechizo de agua.
     * <p>
     * Fórmula: {@code (daño + cantHeal + presionAgua) × 2}.
     *
     * @return el resultado de la fórmula de puntuación
     */
	
	@Override
	public double puntuacion() {
		double puntero = (this.daño + this.cantHeal + this.presionAgua)*2;
		return puntero;
	}
	
	/**
     * Genera la línea de texto para que exista el hechizo de agua en el archivo.
     *
     * @return cadena con nombre, tipo, daño, heal y presión separados por {@code ;} y coma
     */
	
	@Override
	public String lineaTxt() {
		String linea = this.nombreHechizo+";"+this.tipo+";"+this.daño+";"+this.cantHeal+","+this.presionAgua;
		return linea;
	}
	
	/**
     * Modifica un atributo específico del hechizo de agua según la opcion indicada.
     * <p>
     * OPCiones disponibles:
     * <ul>
     *   <li>{@code 1} — cantidad de heal</li>
     *   <li>{@code 2} — presión del agua</li>
     * </ul>
     *
     * @param opcion la clave numérica del atributo a modificar
     * @param valor  el nuevo valor entero para el atributo
     */
	
	@Override
	public void settAtributo(int opcion, int valor) {
		switch(opcion) {
		
		case 1:
			this.cantHeal = valor;
			break;
		case 2:
			this.presionAgua = valor;
			break;
		}
	}
	
	/**
     * Retorna el menú de atributos modificables del hechizo de agua.
     *
     * @return cadena con las opciones numeradas de atributos
     */
	
	@Override
	public String getMenuAtributos() {
		String linea = "1.- Cantidad de Heal"
				+ "\n2.- Presion del Agua";
		return linea;
	}
	
	/**
     * Retorna la cantidad de atributos modificables.
     *
     * @return {@code 2}, correspondientes a cantidad de heal y presión del agua
     */
	
	@Override
	public int getContadorAtributos() {
		return 2;
	}
	
	
	
}
