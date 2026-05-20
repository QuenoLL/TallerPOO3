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
			case 3:
				mostrarHechizos();
				break;
			case 4:
				mostrarMagos();
				break;
			case 7:
				return;
			}
		}
		
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
			case 7:
				return;
			}
		}
		
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
