package Logica;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
	
	//Instancio estaticamente la implementacion del sistema para acceder a sus metodos.
	private static SystemImpl systemImpl = new SystemImpl();
	private static Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException{
		// Nombre: Eugenio Cortés Egaña; Rut: 22.405.687-7
		// Nombre: Matías Núñez González; Rut: 22.256.666-5
		
		leerHechizos();
		leerMagos();
		menu();
	}

	/**
	 * Muestra el menú principal que delega a los submenus.
	 * 
	 */
	private static void menu() {
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
	 * Delega a metodos de analisis.
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


	private static void magosConPuntuacion() {
		System.out.println();
		System.out.println(systemImpl.viewMagesPuntuacion());
		
	}

	private static void hechizosConPuntuacion() {
		System.out.println();
		System.out.println(systemImpl.viewSpellPuntuacion());
		
	}

	private static void mejoresMagos() {
		System.out.println();
		System.out.println(systemImpl.mejoresMagos());
		
	}

	private static void mejoresSpells() {
		System.out.println();
		System.out.println(systemImpl.mejoresHechizos());
	}

	private static void mostrarMagos() {
		System.out.println(systemImpl.viewMages());
	}

	private static void mostrarHechizos() {
		System.out.println(systemImpl.viewSpells());
	}

	private static void menuAdministrador() {
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
				
			case 4:
				agregarHechizo();
				break;
				
			case 7:
				return;
			}
		}
		
	}

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
		}while(opcion < 1 || opcion > 4);
		
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

	private static void modificarMago() {
		// TODO Auto-generated method stub
		
	}

	//Falta sobrescribir el arch...Y arreglar segun indique nicolas
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
