package Logica;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Inicio de la aplicación.
 * <p>
 * Carga los datos desde archivos de texto al iniciar, y presenta al usuario
 * un menú principal con acceso al menú de administración y al menú de análisis.
 *
 * @author [Eugenio Cortés Egaña, Matías Núñez González]
 * @version 1.0
 */

public class App {
	
	/**Instancio la implementacion del sistema para acceder a sus metodos. */
	
	private static SystemImpl systemImpl = new SystemImpl();
	
    /** Lector de entrada del usuario. */

	
	private static Scanner entrada = new Scanner(System.in);
	
	/**
     * Main de la aplicación.
     * <p>
     * Carga hechizos y magos desde archivos, luego muestra el menú principal.
     *
     * @throws IOException si ocurre un error al leer los archivos de datos
     */
	
	public static void main(String[] args) throws IOException{
		// Nombre: Eugenio Cortés Egaña; Rut: 22.405.687-7
		// Nombre: Matías Núñez González; Rut: 22.256.666-5
		
		leerHechizos();
		leerMagos();
		menu();
	}

	/**
     * Muestra el menú principal y delega a los submenús según la opción elegida.
     * <p>
     * Opciones disponibles: menú administrador, menú analista y salir.
     */
	
	private static void menu(){
		int opcion = 0;
		
		while(true) {
			do {
				try {
					System.out.println("\n----Bienvenido al mundo magico----");
					System.out.println("1. Menu administrador\n2. Menu Analista\n3. Salir");
					System.out.print("> ");
					
					opcion = Integer.parseInt(entrada.nextLine());
				}catch(Exception e) {
					System.out.println("ERROR. "+e.getMessage());
				}
			}while(opcion < 1 || opcion  > 3);
			
			switch(opcion) {
			case 1:
				menuAdministrador();
				break;
			
			case 2: 
				menuAnalista();
				break;
				
			case 3:
				return;
			}
		}
	}

	/**
     * Muestra el menú del analista y delega a los métodos de análisis y consulta.
     * <p>
     * Permite consultar rankings, listar magso y hechizos con y sin puntuación.
     */
	
	private static void menuAnalista() {
		int opcion = 0;
		
		while(true) {
			do {
				try {
					System.out.println("\n----Menu Analista----");
					System.out.println("1. Top 10 Mejores Hechizos");
					System.out.println("2. Top 3 Mejores Magos");
					System.out.println("3. Mostrar todos los Hechizos");
					System.out.println("4. Mostrar todos los Magos");
					System.out.println("5. Mostrar todos los Hechizos junto a su puntuacion");
					System.out.println("6. Mostrar a todos los Magos junto a su puntuacion");
					System.out.println("7. Salir");
					System.out.print("> ");
					opcion = Integer.parseInt(entrada.nextLine());
				}catch(Exception e) {
					System.out.println("ERROR. "+e.getMessage());
				}
			}while(opcion < 1 || opcion > 7);
			
			switch(opcion) {
			case 1:
				mejoresSpells();
				break;
			case 2:
				mejoresMagos();
				break;
			case 3:
				mostrarHechizos();
				break;
			case 4:
				mostrarMagos();
				break;
			case 5:
				hechizosConPuntuacion();
				break;
			case 6:
				magosConPuntuacion();
				break;
			case 7:
				return;
			}
		}
		
	}

	/**
     * Imprime la lista de magos junto a su puntuación calculada.
     */
	
	private static void magosConPuntuacion() {
		System.out.println();
		System.out.println(systemImpl.viewMagesPuntuacion());
		
	}

	/**
     * Imprime la lista de hechizos junto a su puntuación calculada.
     */
	
	private static void hechizosConPuntuacion() {
		System.out.println();
		System.out.println(systemImpl.viewSpellPuntuacion());
		
	}

	/**
     * Imprime el ranking de los tres mejores magos por puntuación.
     */
	
	private static void mejoresMagos() {
		System.out.println();
		System.out.println(systemImpl.mejoresMagos());
		
	}

	/**
     * Imprime el ranking de los diez mejores hechizos por puntuación.
     */
	
	private static void mejoresSpells() {
		System.out.println();
		System.out.println(systemImpl.mejoresHechizos());
	}

	/**
     * Imprime la lista completa de magos registrados en el sistema.
     */
	
	private static void mostrarMagos() {
		System.out.println(systemImpl.viewMages());
	}

	/**
     * Imprime la lista completa de hechizos registrados en el sistema.
     */
	
	private static void mostrarHechizos() {
		System.out.println(systemImpl.viewSpells());
	}

	/**
     * Muestra el menú del administrador y deleag a los métodos de gestión.
     * <p>
     * Permite agregar, modificar y eliminar magos y hechizos.
     */
	
	private static void menuAdministrador(){
		int opcion = 0;
		
		while(true) {
			do {
				try {
					System.out.println("\n----Menu administrador----");
					System.out.println("1. Agregar Mago");
					System.out.println("2. Modificar Mago");
					System.out.println("3. Eliminar Mago");
					System.out.println("4. Agregar Hechizo");
					System.out.println("5. Modificar Hechizo");
					System.out.println("6. Eliminar Hechizo");
					System.out.println("7. Salir");
					System.out.print("> ");
					
					opcion = Integer.parseInt(entrada.nextLine());
				}catch(Exception e) {
					System.out.println("ERROR. "+e.getMessage());
				}
			}while(opcion < 1 || opcion > 7);
			
			switch(opcion) {
			case 1:
				agregarMago();
				break;
			
			case 2:
				modificarMago();
				break;
				
			case 3:
				eliminarMago();
				break;
				
			case 4:
				agregarHechizo();
				break;
				
			case 5:
				modificarHechizo();
				break;
				
			case 6:
				eliminarHechizo();
				break;
				
			case 7:
				return;
			}
		}
		
	}

	/**
     * Solicita datos al usuario y elimina el mago seleccionado del sistema.
     * <p>
     * Pide confirmación antes de ejecutar la eliminación y mantiene los cambios en archivo.
     */
	
	private static void eliminarMago() {
		int indice = 0;
		String decision = null;
		
		for(int i = 0; i < systemImpl.getTamañoListaM();i++) {
			System.out.println((i+1)+".- "+systemImpl.getLineaMago(i));
		}
		System.out.println("Ingrese el indice del mago que desea eliminar");
		
		do {
			try {
				System.out.print("> ");
				indice = Integer.parseInt(entrada.nextLine());
			}catch(Exception e) {
				System.out.println("ERROR. "+e.getMessage());
			}
		}while(indice < 1 || indice > systemImpl.getTamañoListaM());
		indice--;//Vuelve al indice del array del systemImpl..
		
		System.out.println("Seguro de su eliminacion?(Si/No)");
		do {
			System.out.print("> ");
			decision = entrada.nextLine();
		}while(!decision.equalsIgnoreCase("si") && !decision.equalsIgnoreCase("no"));
		
		if(decision.equalsIgnoreCase("si")) {
			systemImpl.removerMago(indice);
			systemImpl.sobrescribirArchMages();
			
			System.out.println("Mago eliminado completamente del programa.....");
		}else {
			System.out.println("Volviendo....");
		}
	}

	/**
     * Solicita datos al usuario y elimina el hechizo seleccionado del sistema.
     * <p>
     * Pide confirmación antes de ejecutar la eliminación y mantiene los cambios
     * en los archivos de hechizos y magos.
     */
	
	private static void eliminarHechizo() {
		int indice = 0;
		String decision = null;
		
		System.out.println(systemImpl.viewSpells());
		
		do {
			try {
				System.out.print("Ingrese el indice del hechizo a eliminar: ");
				indice = Integer.parseInt(entrada.nextLine());
			}catch(Exception e) {
				System.out.println("ERROR. "+e.getMessage());
			}
		}while(indice < 1 || indice > systemImpl.getTamañoListaH());
		indice--;//Vuelvo al indice correspondiente al array del systemImpl...
		
		System.out.println("Seguro de su eliminacion?(Si/No)");
		do {
			System.out.print("> ");
			decision = entrada.nextLine();
		}while(!decision.equalsIgnoreCase("si") && !decision.equalsIgnoreCase("no"));
		
		if(decision.equalsIgnoreCase("si")) {
			systemImpl.removerHechizo(indice);
			systemImpl.sobrescribirArchSpell();
			systemImpl.sobrescribirArchMages();
			
			System.out.println("Hechizo eliminado completamente del programa.....");
		}else {
			System.out.println("Volviendo....");
		}
	}

	/**
     * Solicita datos al usuario y modifica el hechizo seleccionado.
     * <p>
     * Permite modificar el daño base o los atributos específicos del tipo de hechizo,
     * y mantiene los cambios en el archivo al finalizar.
     */
	
	private static void modificarHechizo() {
		int indice = 0;
		int opcion = 0;
		
		System.out.println(systemImpl.viewSpells());

		do {
			try {
				System.out.print("Ingrese el indice del hechizo que desea modificar: ");
				indice = Integer.parseInt(entrada.nextLine());
			}catch(Exception e) {
				System.out.println("ERROR. "+e.getMessage());
			}
		}while(indice < 1 || indice > systemImpl.getTamañoListaH());
		indice--;//Valor para array del systemImpl...
		
		System.out.println("\n¿Que deseas modificar?"
				+ "\n1.- Daño"
				+ "\n2.- Atributos especificos"
				+ "\n3.- Salir");
		
		do {
			try {
				System.out.print("> ");
				opcion = Integer.parseInt(entrada.nextLine());
			}catch(Exception e) {
				System.out.println("ERROR. "+e.getMessage());
			}
		}while(opcion < 1 || opcion > 3);
		
		switch(opcion) {
		case 1:
			int daño = 0;
			
			do {
				try {
					System.out.println("Ingrese su nuevo daño para su hechizo: ");
					daño = Integer.parseInt(entrada.nextLine());
				}catch(Exception e) {
					System.out.println("ERROR. "+e.getMessage());
				}
			}while(daño < 0);
			
			systemImpl.modificarDaño(indice, daño);
			break;
		
		case 2:
			System.out.println("¿Que desea modificar?");
			System.out.println(systemImpl.getMenuAtributosSpells(indice));
			
			int llave = 0;
			do {
				try {
					System.out.print("> ");
					llave = Integer.parseInt(entrada.nextLine());
				}catch(Exception e) {
					System.out.println("ERROR. "+e.getMessage());
				}
			}while(llave < 1 || llave > systemImpl.getConteoAtributos(indice));
			
			int valor = 0;
			do {
				try {
					System.out.println("Ingrese el nuevo valor: ");
					valor = Integer.parseInt(entrada.nextLine());
				}catch(Exception e) {
					System.out.println("ERROR. "+e.getMessage());
				}
			}while(valor < 0);
			
			System.out.println(systemImpl.modificarHechizo(indice, llave, valor));
				
			break;
			
		case 3:
			break;
		}
		
		systemImpl.sobrescribirArchSpell();
	}

	/**
     * Solicita datos al usuario y agrega un nuevo hechizo al sistema.
     * <p>
     * El usuario selecciona el tipo elemental y proporciona los atributos correspondientes.
     * mantiene los cambios en el archivo al finalizar.
     */
	
	private static void agregarHechizo() {
		int opcion = 0;
		String name = null;
		
		System.out.println("\nQue tipo de hechizo desea agregar?:");
		System.out.println("1. Fuego");
		System.out.println("2. Tierra");
		System.out.println("3. Planta");
		System.out.println("4. Agua");
		System.out.println("5. Salir");
		
		
		do {
			try {
				System.out.print("> ");
				opcion = Integer.parseInt(entrada.nextLine());
			}catch(Exception e) {
				System.out.println("ERROR. "+e.getMessage());
			}
		}while(opcion < 1 || opcion > 5);
		
		if(opcion == 5) {
			return;
		}
		
		do {
			System.out.print("Ingrese el nombre de su Hechizo: ");
			name = entrada.nextLine();
		}while(name == "");
		
		int daño = 0;
		
		do {
			try {
				System.out.print("Ingrese el daño del hechizo: ");
				daño = Integer.parseInt(entrada.nextLine());
			}catch(Exception e) {
				System.out.println("ERROR. "+e.getMessage());
			}
		}while(daño < 0);
		
		//Switch para dictaminar el tipo de entrada de informacion segun tipo de de hechizo (Spell)...
		switch(opcion) {
		
		case 1:
			int duracionQuemadura = 0;
			
			do {
				try {
					System.out.print("Ingrese la duracion de la quemadura: ");
					duracionQuemadura = Integer.parseInt(entrada.nextLine());
				}catch(Exception e) {
					System.out.println("ERROR. "+e.getMessage());
				}
			}while(daño < 0);
			
			systemImpl.addSpell(name, "Fuego", daño, String.valueOf(duracionQuemadura));
			break;
		
		case 2:
			int mejoraDefensa = 0;
			
			do {
				try {
					System.out.print("Ingrese la mejora de defensa: ");
					mejoraDefensa = Integer.parseInt(entrada.nextLine());
				}catch(Exception e) {
					System.out.println("ERROR. "+e.getMessage());
				}
			}while(mejoraDefensa < 0);
			
			systemImpl.addSpell(name, "Tierra", daño, String.valueOf(mejoraDefensa));
			break;
			
		case 3:
			int duracionStun = 0, cantPlantas = 0;
			
			do {
				try{
					System.out.print("Ingrese la duracion del stun: ");
					duracionStun = Integer.parseInt(entrada.nextLine());
				}catch(Exception e) {
					System.out.println("ERROR. "+e.getMessage());
				}
			}while(duracionStun < 0);
			
			do {
				try{
					System.out.print("Ingrese la cantidad de plantas: ");
					cantPlantas = Integer.parseInt(entrada.nextLine());
				}catch(Exception e) {
					System.out.println("ERROR. "+e.getMessage());
				}
			}while(cantPlantas < 0);
			
			String variable = duracionStun+","+cantPlantas;
			
			systemImpl.addSpell(name, "Planta", daño, variable);
			break;
			
		case 4:
			int cantHeal = 0, presionAgua = 0;
			
			do {
				try{
					System.out.print("Ingrese la cantidad de heal: ");
					cantHeal = Integer.parseInt(entrada.nextLine());
				}catch(Exception e) {
					System.out.println("ERROR. "+e.getMessage());
				}
			}while(cantHeal < 0);
			
			do {
				try{
					System.out.print("Ingrese la presion del agua: ");
					presionAgua = Integer.parseInt(entrada.nextLine());
				}catch(Exception e) {
					System.out.println("ERROR. "+e.getMessage());
				}
			}while(presionAgua < 0);
			
			String variableAgua = cantHeal+","+presionAgua;
			
			systemImpl.addSpell(name, "Agua", daño, variableAgua);
			break;
			
		}
		
		systemImpl.sobrescribirArchSpell();	
	}

	/**
     * Solicita datos al usuario y modifica los hechizos del mago seleccionado.
     * <p>
     * Permite agregar o eliminar hechizos de la lista del mago,
     * y mantienee los cambios en el archivo al finalizar.
     */
	
	private static void modificarMago() {
		int indice = 0;//Recordar que es (indice + 1) la que ingresa el usuario...
		int opcion = 0;
		
		System.out.println("---Ingrese el indice del mago a modificar---");
		for(int i = 0; i < systemImpl.getTamañoListaM();i++) {
			System.out.println((i+1)+".- "+systemImpl.getLineaMago(i));
		}
		
		do {
			try {
				System.out.print("> ");
				indice = Integer.parseInt(entrada.nextLine());
			}catch(Exception e) {
				System.out.println("ERROR. "+e.getMessage());
			}
		}while(indice < 0 || indice > systemImpl.getTamañoListaM());
		
		indice--;//Devuelvo al valor que corresponde (i+1-1) == i...
		
		System.out.println("Que deseas modificar "
				+ "\n1.- Agregar Hechizo"
				+ "\n2.- Eliminar Hechizo"
				+ "\n3.- Salir");
		
		do {
			try {
				System.out.print("> ");
				opcion = Integer.parseInt(entrada.nextLine());
			}catch(Exception e) {
				System.out.println("ERROR. "+e.getMessage());
			}
		}while(opcion < 1 || opcion > 3);
		
		//Switch que pasa por los tres casos de eleccion de usuario.
		switch(opcion) {
		case 1:
			System.out.println("---Ingrese el indice del hechizo a agregar---");
			int indiceSpell = indiceHechizo();
			systemImpl.modificarMagoHechizo(indice,opcion, indiceSpell);
			System.out.println("Hechizo agregado con exito!!!");
			break;
		
		case 2:
			System.out.println("---Ingrese el indice del hechizo que quiere eliminar---");
			int indiceSpellEliminar = indiceHechizoEliminar(indice);
			systemImpl.modificarMagoHechizo(indice,opcion, indiceSpellEliminar);
			System.out.println("Hechizo eliminado con exito!!!");
			break;
		
		case 3:
			System.out.println("De vuelta al menu...");
			break;
		}
		
		systemImpl.sobrescribirArchMages();
				
	}
	
	/**
     * Solicita y valida el índice de un hechizo de la lista de un mago específico.
     *
     * @param indiceMago el índice (base 0) del mago culla lista se muestra
     * @return el índice (base 0) del hechizo seleccionado por el usuario
     */
	
	private static int indiceHechizoEliminar(int indiceMago) {
		int indiceSpell = 0;
		System.out.println(systemImpl.getListaSpellMago(indiceMago));
		
		do {
			try {
				System.out.print("> ");
				indiceSpell = Integer.parseInt(entrada.nextLine());
			}catch(Exception e) {
				System.out.println("ERROR. "+e.getMessage());
			}
		}while(indiceSpell < 1 || indiceSpell > systemImpl.getTamañoListaSpellMago(indiceMago));
		
		return indiceSpell-1;
	}
	
	/**
     * Solicita y valida el índice de un hechizo de la lista global del sistema.
     *
     * @return el índice (base 0) del hechizo seleccionado por el usuario
     */
	
	private static int indiceHechizo() {
		int indiceSpell = 0;
		for(int i = 0; i < systemImpl.getTamañoListaH(); i++) {
			System.out.println((i+1)+".- "+systemImpl.getLineaSpell(i));
		}
	
		do {
			try {
				System.out.print("> ");
				indiceSpell = Integer.parseInt(entrada.nextLine());
			}catch(Exception e) {
				System.out.println("ERROR. "+e.getMessage());
			}
		}while(indiceSpell < 1 || indiceSpell > systemImpl.getTamañoListaH());
		
		return indiceSpell-1;
	}

	/**
     * Solicita datos al usuario y agrega un nuevo mago al sistema.
     * <p>
     * Permite asignar hechizos existentes al mago durante su creación,
     * y mantiene los cambios en el archivo al finalizar.
     */
	
	private static void agregarMago() {
		String name, opcion = null;
		List<Integer> indicesHechizos = new ArrayList<Integer>();
		
		do {
			System.out.println("Ingrese el nombre del mago: ");
			name = entrada.nextLine();
		}while(name == "");
		
		do {
			System.out.println("Tiene ligado un hechizo? (Si/No): ");
			opcion = entrada.nextLine();
		}while(!opcion.equalsIgnoreCase("si") && !opcion.equalsIgnoreCase("no"));
		
		if(opcion.equalsIgnoreCase("si")) {
			int indicador = 0;
			
			System.out.println(systemImpl.viewSpells());
			System.out.println("Ingrese el Num. del hechizo (-1 fin de datos).");
			
			while(indicador != -1) {
				
				do {
					System.out.print("> ");
					indicador = Integer.parseInt(entrada.nextLine());
				}while(indicador < -1 || indicador > systemImpl.getTamañoListaH());
				
				indicesHechizos.add(indicador);
			}
			
			systemImpl.addMage(name, indicesHechizos);
			
		}else {
			systemImpl.addMage(name,indicesHechizos);
		}
		
		//Sobrescribo independientemente de la decision...
		systemImpl.sobrescribirArchMages();
		
	}

	/**
     * Lee los magos desde el archivo {@code txts/Magos.txt} y los carga en el sistema.
     *
     * @throws IOException si el archivo no existe o no puede ser leído
     */
	
	private static void leerMagos() throws IOException{
		File file = new File("txts/Magos.txt");
		Scanner lector = new Scanner(file);
		
		while(lector.hasNextLine()) {
			String linea = lector.nextLine();
			String[] partes = linea.split(";");
			
			systemImpl.createMage(partes);
		}
		lector.close();
		
	}

	/**
     * Lee los hechizos desde el archivo {@code txts/Hechizos.txt} y los carga en el sistema.
     *
     * @throws IOException si el archivo no existe o no puede ser leído
     */
	
	private static void leerHechizos() throws IOException{
		File file = new File("txts/Hechizos.txt");
		Scanner lector = new Scanner(file);
		
		while(lector.hasNextLine()) {
			String linea = lector.nextLine();
			String[] partes = linea.split(";");
			
			systemImpl.createSpell(partes);
		}
		
		lector.close();
	}
	

}
