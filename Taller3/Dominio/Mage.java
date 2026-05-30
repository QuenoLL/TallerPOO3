package Dominio;

import java.util.List;

public class Mage implements Condicional{
	
	private String nombre;
	private List<Spell> listaHechizos;
	
	public Mage(String nombre, List<Spell> listaHechizos) {
		this.nombre = nombre;
		this.listaHechizos = listaHechizos;
	}

	public String getNombre() {
		return nombre;
	}

	public List<Spell> getListaHechizos() {
		return listaHechizos;
	}
	
	public void addSpell(Spell hechizo) {
		listaHechizos.add(hechizo);
	}

	@Override //Se debera imprimir con los hechizos???...
	public String toString() {
		
		return "Nombre: "+nombre+" | Cantidad Hechizos: "+this.listaHechizos.size();
	}
	
	@Override
	public String lineaTxt() {
		String lista = this.nombre + ";";
		
		for(int i = 0; i < listaHechizos.size(); i++) {
			lista += listaHechizos.get(i).getNombreHechizo();
			
			if(i != listaHechizos.size() - 1) {
				lista += "|";
			}
		}
		
		return lista;
	}
	
	@Override
	public double puntuacion() {
		double puntero = 0;
		
		for(Spell hechizo : listaHechizos) {
			puntero += hechizo.puntuacion();
		}
		
		return puntero;
	}
	
	
	
	
	
	
	
	
	
	
	

}
