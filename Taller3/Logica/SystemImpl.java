package Logica;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import Dominio.*;

/**
 * Implementación del sistema de gestión de magos y hechizos.
 * <p>
 * Administra las listas estáticas de {@link Spell} y {@link Mage}, y provee
 * operaciones de creación, modificación, eliminación, consulta y existencia en
 * archivos de texto.
 *
 * @author [Eugenio Cortés Egaña, Matías Núñez González]
 * @version 1.0
 * @see ISystem
 */

public class SystemImpl implements ISystem {

	/** Lista estática de todos los hechizos registrados en el sistema. */

	private static List<Spell> listaHechizos = new ArrayList<Spell>();

	/** Lista estática de todos los magos registrados en el sistema. */

	private static List<Mage> listaMagos = new ArrayList<Mage>();

	/**
	 * Crea y registra un mago a partir de un arreglo de partes leídas desde
	 * archivo.
	 * <p>
	 * Si {@code partes[1]} contiene nombres de hechizos separados por {@code |},
	 * los busca en la lista existente y los asigna al mago.
	 *
	 * @param partes arreglo donde {@code partes[0]} es el nombre y
	 *               {@code partes[1]} contiene los nombres de hechizos separados
	 *               por {@code |}
	 */

	@Override
	public void createMage(String[] partes) {
		String nombre = partes[0];
		List<Spell> listaH = new ArrayList<Spell>();

		if (partes.length > 1 && !partes[1].isEmpty()) {

			String[] hechizos = partes[1].split("\\|");

			for (int i = 0; i < hechizos.length; i++) {
				for (Spell hechizo : listaHechizos) {
					if (hechizos[i].equalsIgnoreCase(hechizo.getNombreHechizo())) {
						listaH.add(hechizo);
						break;
					}
				}
			}
		}

		Mage m = new Mage(nombre, listaH);
		listaMagos.add(m);
	}

	/**
	 * Crea y registra un hechizo a partir de un arreglo de partes leídas desde
	 * archivo.
	 * <p>
	 * El tipo del hechizo determina qué subclase se instancia y cómo se transforman
	 * los atributos adicionales.
	 *
	 * @param partes arreglo con nombre, tipo, daño y atributos específicos del
	 *               hechizo
	 */

	@Override
	public void createSpell(String[] partes) {
		String nombre = partes[0];
		String tipo = partes[1];
		int daño = Integer.parseInt(partes[2]);

		Spell spell = null;

		switch (tipo) {
		case "Fuego":
			int duracion = Integer.parseInt(partes[3]);
			spell = new Fire(nombre, tipo, daño, duracion);
			break;

		case "Tierra":
			int mejora = Integer.parseInt(partes[3]);
			spell = new Ground(nombre, tipo, daño, mejora);
			break;

		case "Planta":
			String[] datosPlanta = partes[3].split(",");
			int duracionStun = Integer.parseInt(datosPlanta[0]);
			int cantPlantas = Integer.parseInt(datosPlanta[1]);
			spell = new Grass(nombre, tipo, daño, duracionStun, cantPlantas);
			break;

		case "Agua":
			String[] datosAgua = partes[3].split(",");
			int cantHeal = Integer.parseInt(datosAgua[0]);
			int presionAgua = Integer.parseInt(datosAgua[1]);
			spell = new Water(nombre, tipo, daño, cantHeal, presionAgua);
			break;
		}

		if (spell != null) {
			listaHechizos.add(spell);
		}

	}

	/**
	 * Crea y registra un mago con hechizos seleccionados por índice.
	 *
	 * @param name         el nombre del mago a agregar
	 * @param listaIndices lista de índices (base 1) de hechizos a asignar al mago;
	 *                     puede estar vacía si el mago no tiene hechizos
	 */

	@Override // Necesario arreglar con el tema de sobrescritura.
	public void addMage(String name, List<Integer> listaIndices) {

		// Inicializo una lista vacia de hechizos para crear al mago...
		List<Spell> listaH = new ArrayList<Spell>();
		Mage m = null;

		if (listaIndices.size() != 0) {

			for (int i = 0; i < listaHechizos.size(); i++) {
				for (int j = 0; j < listaIndices.size(); j++) {
					if (listaIndices.get(j) - 1 == i) {
						listaH.add(listaHechizos.get(i));
						break;
					}
				}
			}

			m = new Mage(name, listaH);
		} else {
			m = new Mage(name, listaH);
		}

		listaMagos.add(m);

	}

	/**
	 * Retorna la lista de todos los hechizos registrados en el sistema.
	 *
	 * @return cadena con la lista numerada de hechizos y sus atributos
	 */

	@Override
	public String viewSpells() {
		String list = "----HECHIZOS | SPELLS----\n";
		int c = 1;

		for (Spell hechizo : listaHechizos) {
			list += c + ". " + hechizo.toString() + "\n";
			c++;
		}

		return list;
	}

	/**
	 * Retorna la lista de todos los magos registrados en el sistema.
	 *
	 * @return cadena con la lista de magos y sus hechizos
	 */

	@Override // Ver si es que debe de imprimirse con sus hechizos o no...
	public String viewMages() {
		String list = "----MAGOS | MAGES----\n";

		for (Mage mago : listaMagos) {
			list += mago.toString() + "\n";
		}

		return list;
	}

	/**
	 * Retorna el tamaño actual de la lista de hechizos.
	 *
	 * @return la cantidad de hechizos registrados
	 */

	public int getTamañoListaH() {
		return listaHechizos.size();
	}

	/**
	 * Retorna el tamaño actual de la lista de magos.
	 *
	 * @return la cantidad de magos registrados
	 */

	public int getTamañoListaM() {
		return listaMagos.size();
	}

	/**
	 * Retorna la linea de un mago según su índice.
	 *
	 * @param indice el índice (base 0) del mago en la lista
	 * @return cadena con los datos del mago
	 */

	public String getLineaMago(int indice) {
		return listaMagos.get(indice).toString();
	}

	/**
	 * Retorna la linea de un hechizo según su índice.
	 *
	 * @param indice el índice (base 0) del hechizo en la lista
	 * @return cadena con los datos del hechizo
	 */

	public String getLineaSpell(int indice) {
		return listaHechizos.get(indice).toString();
	}

	/**
	 * Retorna los diez hechizos con mayor puntuación, ordenados de mayor a menor.
	 * <p>
	 * Opera sobre una copia de la lista original para no alterar nada.
	 *
	 * @return cadena con el ranking de los diez mejores hechizos y sus puntuaciones
	 */

	@Override
	public String mejoresHechizos() {
		String list = "-----Mejores 10 Hechizos | The Best 10 Spells-----\n";

		List<Spell> copia = new ArrayList<Spell>();

		for (Spell s : listaHechizos) {
			copia.add(s);
		}

		for (int i = 0; i < copia.size() - 1; i++) {
			for (int j = i + 1; j < copia.size(); j++) {
				if (copia.get(i).puntuacion() < copia.get(j).puntuacion()) {

					Spell aux = copia.get(i);
					copia.set(i, copia.get(j));
					copia.set(j, aux);

				}
			}
		}

		for (int i = 0; i < 10; i++) {
			list += copia.get(i).getNombreHechizo() + " | Puntuacion : " + copia.get(i).puntuacion() + "\n";
		}

		return list;
	}

	/**
	 * Retorna los tres magos con mayor puntuación, ordenados de mayor a menor.
	 * <p>
	 * Opera sobre una copia de la lista original para no alterar nada.
	 *
	 * @return cadena con el ranking de los tres mejores magos y sus puntuaciones
	 */

	@Override
	public String mejoresMagos() {
		String list = "-----Top 3 Mejores Magos | Top Three Best Mages-----\n";

		List<Mage> copia = new ArrayList<Mage>();

		for (Mage m : listaMagos) {
			copia.add(m);
		}

		for (int i = 0; i < copia.size() - 1; i++) {
			for (int j = i + 1; j < copia.size(); j++) {
				if (copia.get(i).puntuacion() < copia.get(j).puntuacion()) {

					Mage aux = copia.get(i);
					copia.set(i, copia.get(j));
					copia.set(j, aux);

				}
			}
		}

		for (int i = 0; i < 3; i++) {
			list += copia.get(i).getNombre() + " | Puntuacion : " + copia.get(i).puntuacion() + "\n";
		}

		return list;

	}

	/**
	 * Retorna la lista de todos los magos junto a su puntuación calculada.
	 *
	 * @return cadena con el nombre y puntuación de cada mago
	 */

	@Override
	public String viewMagesPuntuacion() {
		String list = "----MAGOS CON PUNTUACION| MAGES WITH POINTS----\n";

		for (Mage mago : listaMagos) {
			list += "Nombre Mago: " + mago.getNombre() + " | Puntuacion: " + mago.puntuacion() + "\n";
		}

		return list;
	}

	/**
	 * Retorna la lista de todos los hechizos junto a su puntuación calculada.
	 *
	 * @return cadena con el nombre y puntuación de cada hechizo
	 */

	@Override
	public String viewSpellPuntuacion() {
		String list = "----HECHIZOS CON PUNTUACION | SPELLS WITH POINTS----\n";

		for (Spell hechizo : listaHechizos) {
			list += "Nombre Hechizo: " + hechizo.getNombreHechizo() + " | Puntuacion: " + hechizo.puntuacion() + "\n";
		}

		return list;
	}

	/**
	 * Sobrescribe el archivo de magos con el estado actual de la lista.
	 *
	 * @see Mage#lineaTxt()
	 */

	@Override
	public void sobrescribirArchMages() {

		try {
			String arch = "txts/Magos.txt";
			FileWriter escritor = new FileWriter(arch);

			for (int i = 0; i < listaMagos.size(); i++) {
				if (i == 0) {
					escritor.write(listaMagos.get(i).lineaTxt());
				} else {
					escritor.write("\n" + listaMagos.get(i).lineaTxt());
				}
			}

			escritor.close();

		} catch (Exception e) {
			System.out.println("ERROR. " + e.getMessage());
		}
	}

	/**
	 * Crea y registra un hechizo con sus atributos ingresados manualmente.
	 *
	 * @param name     el nombre del hechizo
	 * @param tipo     el tipo del hechizo (Fuego, Tierra, Planta o Agua)
	 * @param daño     los puntos de daño base del hechizo
	 * @param variable cadena con los atributos específicos del tipo de hechizo;
	 *                 para tipos con dos atributos se usa {@code "valor1,valor2"}
	 */

	@Override
	public void addSpell(String name, String tipo, int daño, String variable) {
		Spell spell = null;

		switch (tipo) {

		case "Fuego":
			spell = new Fire(name, tipo, daño, Integer.parseInt(variable));
			break;

		case "Tierra":
			spell = new Ground(name, tipo, daño, Integer.parseInt(variable));
			break;

		case "Planta":
			String[] partesP = variable.split(",");
			int duracionStun = Integer.parseInt(partesP[0]);
			int cantPlantas = Integer.parseInt(partesP[1]);

			spell = new Grass(name, tipo, daño, duracionStun, cantPlantas);
			break;

		case "Agua":
			String[] partesA = variable.split(",");
			int cantHeal = Integer.parseInt(partesA[0]);
			int presionAgua = Integer.parseInt(partesA[1]);

			spell = new Water(name, tipo, daño, cantHeal, presionAgua);
			break;
		}

		listaHechizos.add(spell);
	}

	/**
	 * Sobrescribe el archivo de hechizos con el estado actual de la lista.
	 *
	 * @see Spell#lineaTxt()
	 */

	@Override
	public void sobrescribirArchSpell() {
		try {
			String arch = "txts/Hechizos.txt";
			FileWriter escritor = new FileWriter(arch);

			for (int i = 0; i < listaHechizos.size(); i++) {
				if (i == 0) {
					escritor.write(listaHechizos.get(i).lineaTxt());
				} else {
					escritor.write("\n" + listaHechizos.get(i).lineaTxt());
				}
			}

			escritor.close();
		} catch (Exception e) {
			System.out.println("ERROR. " + e.getMessage());
		}

	}

	/**
	 * Agrega o elimina un hechizo de la lista de un mago.
	 *
	 * @param indiceMago  el índice (base 0) del mago a modificar
	 * @param opcion      {@code 1} para agregar, {@code 2} para eliminar
	 * @param indiceSpell el índice (base 0) del hechizo a agregar o eliminar
	 */

	@Override
	public void modificarMagoHechizo(int indiceMago, int opcion, int indiceSpell) {
		if (opcion == 1) {
			listaMagos.get(indiceMago).addSpell(listaHechizos.get(indiceSpell));
		} else if (opcion == 2) {
			listaMagos.get(indiceMago).removeSpell(listaMagos.get(indiceMago).getListaHechizos().get(indiceSpell));
		}
	}

	/**
	 * Retorna la lista de hechizos asignados a un mago específico.
	 *
	 * @param indiceMago el índice (base 0) del mago consultado
	 * @return cadena numerada con los nombres de los hechizos del mago
	 */

	@Override
	public String getListaSpellMago(int indiceMago) {
		String lista = "";
		for (int i = 0; i < listaMagos.get(indiceMago).getListaHechizos().size(); i++) {
			lista += (i + 1) + ".- " + listaMagos.get(indiceMago).getListaHechizos().get(i).getNombreHechizo() + "\n";
		}

		return lista;
	}

	/**
	 * Retorna el tamaño de la lista de hechizos de un mago específico.
	 *
	 * @param indiceMago el índice (base 0) del mago consultado
	 * @return la cantidad de hechizos asignados al mago
	 */

	public int getTamañoListaSpellMago(int indiceMago) {
		return listaMagos.get(indiceMago).getListaHechizos().size();
	}

	/**
	 * Modifica el daño base de un hechizo.
	 *
	 * @param indiceSpell el índice (base 0) del hechizo a modificar
	 * @param dañoNuevo   el nuevo valor de daño base
	 * @return cadena informando el nombre del hechizo y su nuevo valor de daño
	 */

	@Override
	public String modificarDaño(int indiceSpell, int dañoNuevo) {
		listaHechizos.get(indiceSpell).setDaño(dañoNuevo);

		String linea = listaHechizos.get(indiceSpell).getNombreHechizo() + " tiene un nuevo daño de: " + dañoNuevo;

		return linea;
	}

	/**
	 * Retorna el menú de atributos específicos modificables de un hechizo.
	 *
	 * @param indice el índice (base 0) del hechizo consultado
	 * @return cadena con las opciones numeradas de atributos modificables
	 */

	@Override
	public String getMenuAtributosSpells(int indice) {
		return listaHechizos.get(indice).getMenuAtributos();
	}

	/**
	 * Retorna la cantidad de atributos específicos modificables de un hechizo.
	 *
	 * @param indice el índice (base 0) del hechizo consultado
	 * @return el número de atributos modificables del hechizo
	 */

	@Override
	public int getConteoAtributos(int indice) {
		return listaHechizos.get(indice).getContadorAtributos();
	}

	/**
	 * Modifica un atributo específico de un hechizo según una opcion numérica.
	 *
	 * @param indice el índice (base 0) del hechizo a modificar
	 * @param key    la opcion numérica del atributo a modificar
	 * @param valor  el nuevo valor entero para el atributo
	 * @return cadena de confirmación con el nombre del hechizo modificado
	 */

	@Override
	public String modificarHechizo(int indice, int key, int valor) {
		listaHechizos.get(indice).settAtributo(key, valor);
		String linea = listaHechizos.get(indice).getNombreHechizo() + " Ha sido modificado con exito!";
		return linea;
	}


	/**
	 * Elimina un hechizo del sistema y lo remueve de todos los magos que lo tengan
	 * asignado.
	 *
	 * @param indice el índice (base 0) del hechizo a eliminar
	 */
	 
	@Override
public void removerHechizo(int indice) {

		for (Mage mago : listaMagos) {
			for (int i = 0; i < mago.getListaHechizos().size(); i++) {
				if (mago.getListaHechizos().get(i).equals(listaHechizos.get(indice))) {
					mago.getListaHechizos().remove(i);
					break;
				}
			}
		}
		listaHechizos.remove(indice);
	}

	/**
     * Elimina un mago del sistema.
     *
     * @param indice el índice (base 0) del mago a eliminar
     */
	
	@Override
	public void removerMago(int indice) {
		listaMagos.remove(indice);
	}

}
