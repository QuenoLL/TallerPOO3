package Logica;

import java.util.ArrayList;
import java.util.List;

import Dominio.*;

public class SystemImpl implements ISystem{

	private static List<Spell> listaHechizos = new ArrayList<Spell>();
	private static List<Mage> listaMagos = new ArrayList<Mage>();
	
	@Override
	public void createMage(String[] partes) {
		String nombre = partes[0];
		String[] hechizos = partes[1].split("\\|");
		List<Spell> listaH = new ArrayList<Spell>();
		
		for(int i = 0; i < hechizos.length; i++) {
			for(Spell hechizo : listaHechizos) {
				if(hechizos[i].equalsIgnoreCase(hechizo.getNombreHechizo())) {
					listaH.add(hechizo);
					break;
				}
			}
		}
		
		Mage m = new Mage(nombre, listaH);
		listaMagos.add(m);	
	}
	
	@Override
	public void createSpell(String[] partes) {
		String nombre = partes[0];
		String tipo = partes[1];
		int daño = Integer.parseInt(partes[2]);
		
		Spell spell = null;
		
		switch(tipo) {
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
		
		if(spell != null) {
			listaHechizos.add(spell);
		}
		
	}
	
	@Override //Necesario arreglar con el tema de sobrescritura.
	public void addMage(String name,List<Integer> listaIndices) {
		
		//Inicializo una lista vacia de hechizos para crear al mago...
		List<Spell> listaH = new ArrayList<Spell>();
		Mage m = null;
		
		if(listaIndices.size() != 0) {
			
			for(int i = 0; i < listaHechizos.size(); i++) {
				for(int j = 0; j < listaIndices.size(); j++) {
					if(listaIndices.get(j)-1 == i) {
						listaH.add(listaHechizos.get(i));
						break;
					}
				}
			}
			
			m = new Mage(name,listaH);
		}else {
			m = new Mage(name,listaH);
		}
		
		listaMagos.add(m);
		
	}
	
	@Override
	public String viewSpells() {
		String list = "----HECHIZOS | SPELLS----\n";
		int c = 1;
		
		for(Spell hechizo : listaHechizos) {
			list += c+". "+hechizo.toString()+"\n";
			c++;
		}

		return list;
	}
	
	@Override //Ver si es que debe de imprimirse con sus hechizos o no...
	public String viewMages() {
		String list= "----MAGOS | MAGES----\n";
		
		for(Mage mago : listaMagos) {
			list += mago.toString() + "\n";
		}
		
		return list;
	}
	
	public int getTamañoListaH() {
		return listaHechizos.size();
	}
}

