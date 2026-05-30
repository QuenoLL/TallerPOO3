package Logica;

import java.io.FileWriter;
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
	
	public int getTamañoListaM() {
		return listaMagos.size();
	}
	
	public String getLineaMago(int indice) {
		return listaMagos.get(indice).toString();		
	}
	
	public String getLineaSpell(int indice) {
		return listaHechizos.get(indice).toString();		
	}
	
	@Override
	public String mejoresHechizos() {
		String list = "-----Mejores 10 Hechizos | The Best 10 Spells-----\n";
		
		List<Spell> copia = new ArrayList<Spell>();
		
		for(Spell s : listaHechizos) {
			copia.add(s);
		}
		
		for(int i = 0; i < copia.size()-1; i++) {
			for(int j = i+1; j < copia.size(); j++) {
				if(copia.get(i).puntuacion() < copia.get(j).puntuacion()) {
					
					Spell aux = copia.get(i);
					copia.set(i, copia.get(j));
					copia.set(j, aux);
					
				}
			}
		}
		
		for(int i = 0; i < 10; i++) {
			list += copia.get(i).getNombreHechizo() + " | Puntuacion : "+ copia.get(i).puntuacion()+"\n";
		}
		
		return list;
	}
	
	@Override
	public String mejoresMagos() {
		String list = "-----Top 3 Mejores Magos | Top Three Best Mages-----\n";
		
		List<Mage> copia = new ArrayList<Mage>();
		
		for(Mage m : listaMagos) {
			copia.add(m);
		}
		
		for(int i = 0; i < copia.size()-1; i++) {
			for(int j = i+1; j < copia.size(); j++) {
				if(copia.get(i).puntuacion() < copia.get(j).puntuacion()) {
					
					Mage aux = copia.get(i);
					copia.set(i, copia.get(j));
					copia.set(j, aux);
					
				}
			}
		}
		
		for(int i = 0; i < 3; i++) {
			list += copia.get(i).getNombre() + " | Puntuacion : "+ copia.get(i).puntuacion()+"\n";
		}
		
		return list;
	
	}
	
	@Override
	public String viewMagesPuntuacion() {
		String list =  "----MAGOS CON PUNTUACION| MAGES WITH POINTS----\n";
		
		for(Mage mago : listaMagos) {
			list += "Nombre Mago: " + mago.getNombre() +" | Puntuacion: "+ mago.puntuacion() +"\n";
		}
		
		return list;
	}
	
	@Override
	public String viewSpellPuntuacion() {
		String list =  "----HECHIZOS CON PUNTUACION | SPELLS WITH POINTS----\n";
		
		for(Spell hechizo : listaHechizos) {
			list += "Nombre Hechizo: "+hechizo.getNombreHechizo() +" | Puntuacion: "+hechizo.puntuacion() + "\n";
		}
		
		return list;
	}
	
	@Override
	public void sobrescribirArchMages() {
		
		try {
			String arch = "txts/Magos.txt";
			FileWriter escritor = new FileWriter(arch);
			
			for(int i = 0; i < listaMagos.size(); i++) {
				if(i == 0) {
					escritor.write(listaMagos.get(i).lineaTxt());
				}else {
					escritor.write("\n"+listaMagos.get(i).lineaTxt());
				}
			}
			
			escritor.close();
			
			
		}catch(Exception e) {
			System.out.println("ERROR. "+e.getMessage());
		}
	}
	
	@Override
	public void addSpell(String name, String tipo, int daño, String variable) {
		Spell spell = null;
		
		switch(tipo) {
		
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
	
	@Override
	public void sobrescribirArchSpell() {
		try {
			String arch = "txts/Hechizos.txt";
			FileWriter escritor = new FileWriter(arch);

			for (int i = 0; i < listaHechizos.size(); i++) {
				if(i == 0) {
					escritor.write(listaHechizos.get(i).lineaTxt());
				}else {
					escritor.write("\n"+listaHechizos.get(i).lineaTxt());
				}
			}
			
			escritor.close();
		} catch (Exception e) {
			System.out.println("ERROR. " + e.getMessage());
		}

	}
	
	@Override
	public void modificarMagoHechizo(int indiceMago, int opcion, int indiceSpell) {
		if(opcion == 1) {
			listaMagos.get(indiceMago).addSpell(listaHechizos.get(indiceSpell));
		}else if(opcion == 2){
			listaMagos.get(indiceMago).removeSpell(listaMagos.get(indiceMago).getListaHechizos().get(indiceSpell));
		}	
	}
	
	@Override
	public String getListaSpellMago(int indiceMago) {
		String lista = "";
		for(int i = 0; i < listaMagos.get(indiceMago).getListaHechizos().size(); i++) {
			lista += (i+1)+".- "+listaMagos.get(indiceMago).getListaHechizos().get(i).getNombreHechizo()+"\n";
		}
		
		return lista;
	}
	
	public int getTamañoListaSpellMago(int indiceMago) {
		return listaMagos.get(indiceMago).getListaHechizos().size();
	}
	
	
	
	
}

