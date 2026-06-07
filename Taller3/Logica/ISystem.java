package Logica;

import java.util.List;

/**
 * Contrato del sistema de gestión de magos y hechizos.
 * <p>
 * Define todas las operaciones disponibles para crear, modificar, eliminar
 * y consultar magos y hechizos, así como para que existan los datos en los archivos.
 *
 * @author [Eugenio Cortés Egaña, Matías Núñez González]
 * @version 1.0
 * @see SystemImpl
 */

public interface ISystem {
	
	/**
     * Crea y registra un mago a partir de un arreglo de partes leídas desde archivo.
     *
     * @param partes arreglo donde {@code partes[0]} es el nombre y {@code partes[1]}
     *               contiene los nombres de hechizos separados por {@code |}
     */
	
	void createMage(String[] partes);
	
	/**
     * Crea y registra un hechizo a partir de un arreglo de partes leídas desde archivo.
     *
     * @param partes arreglo con nombre, tipo, daño y atributos específicos del hechizo
     */
	
	void createSpell(String[] partes);
	
	/**
     * Crea y registra un mago con hechizos seleccionados por índice.
     *
     * @param name          el nombre del mago a agregar
     * @param listaIndices  lista de índices (base 1) de hechizos a asignar al mago;
     *                      puede estar vacía si el mago no tiene hechizos
     */
	
	void addMage(String name,List<Integer> listaIndices);
	
	/**
     * Sobrescribe el archivo de magos con el estado actual de la lista.
     */
	
	void sobrescribirArchMages();
	
	/**
     * Sobrescribe el archivo de hechizos con el estado actual de la lista.
     */
	
	void sobrescribirArchSpell();
	
	/**
     * Crea y registra un hechizo con sus atributos ingresados manualmente.
     *
     * @param name     el nombre del hechizo
     * @param tipo     el tipo del hechizo (Fuego, Tierra, Planta o Agua)
     * @param daño     los puntos de daño base del hechizo
     * @param variable cadena con los atributos específicos del tipo de hechizo;
     *                 para tipos con dos atributos se usa {@code "valor1,valor2"}
     */
	
	void addSpell(String name, String tipo, int daño, String variable);
	
	/**
     * Agrega o elimina un hechizo de la lista de un mago.
     *
     * @param indiceMago  el índice (base 0) del mago a modificar
     * @param opcion      {@code 1} para agregar, {@code 2} para eliminar
     * @param indiceSpell el índice (base 0) del hechizo a agregar o eliminar
     */
	
	void modificarMagoHechizo(int indice,int opcion, int indiceSpell);
	
	 /**
     * Elimina un hechizo del sistema y lo remueve de todos los magos que lo tengan asignado.
     *
     * @param indice el índice (base 0) del hechizo a eliminar
     */
	
	void removerHechizo(int indice);
	
	/**
     * Elimina un mago del sistema.
     *
     * @param indice el índice (base 0) del mago a eliminar
     */
	
	void removerMago(int indice);
	
	 /**
     * Modifica un atributo específico de un hechizo según una clave numérica.
     *
     * @param indice el índice (base 0) del hechizo a modificar
     * @param key    la clave numérica del atributo a modificar
     * @param valor  el nuevo valor entero para el atributo
     * @return cadena de confirmación con el nombre del hechizo modificado
     */
	
	String modificarHechizo(int indice, int key, int valor);
	
	/**
     * Modifica el daño base de un hechizo.
     *
     * @param indiceSpell el índice (base 0) del hechizo a modificar
     * @param dañoNuevo   el nuevo valor de daño base
     * @return cadena informando el hechizo y su nuevo valor de daño
     */
	
	String modificarDaño(int indiceSpell, int dañoNuevo);
	
	/**
     * Retorna la lista de todos los hechizos registrados en el sistema.
     *
     * @return cadena con la lista numerada de hechizos y sus atributos
     */
	
	String viewSpells();
	
	 /**
     * Retorna la lista de todos los magos registrados en el sistema.
     *
     * @return cadena con la lista de magos y sus hechizos
     */
	
	String viewMages();
	
	/**
     * Retorna los diez hechizos con mayor puntuación, ordenados de mayor a menor.
     *
     * @return cadena con el ranking de los diez mejores hechizos y sus puntuaciones
     */
	
	String mejoresHechizos();
	
	/**
     * Retorna los tres magos con mayor puntuación, ordenados de mayor a menor.
     *
     * @return cadena con el ranking de los tres mejores magos y sus puntuaciones
     */
	
	String mejoresMagos();
	
	/**
	 * Retorna el menú de atributos modificables de un hechizo.
	 *
	 * @param indice el índice (base 0) del hechizo consultado
	 * @return cadena con las opciones numeradas de atributos modificables
	 */
	
	String viewSpellPuntuacion();
	
	/**
	 * Retorna la lista de todos los magos junto a su puntuación calculada.
	 *
	 * @return cadena con el nombre y puntuación de cada mago
	 */
	
	String viewMagesPuntuacion();
	
	/**
	 * Retorna la lista de hechizos asignados a un mago específico.
	 *
	 * @param indiceMago el índice (base 0) del mago consultado
	 * @return cadena numerada con los nombres de los hechizos del mago
	 */
	
	String getListaSpellMago(int indiceMago);
	
	/**
     * Retorna el menú de atributos específicos modificables de un hechizo.
     *
     * @param indice el índice (base 0) del hechizo consultado
     * @return cadena con las opciones numeradas de atributos modificables
     */
	
	String getMenuAtributosSpells(int indice);
	
	/**
     * Retorna la cantidad de atributos específicos modificables de un hechizo.
     *
     * @param indice el índice (base 0) del hechizo consultado
     * @return el número de atributos modificables del hechizo
     */
	
	int getConteoAtributos(int indice);

}
