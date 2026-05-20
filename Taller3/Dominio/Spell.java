package Dominio;

public class Spell {
	
	protected String nombreHechizo;
	protected String tipo;
	protected int daño;
	
	public Spell(String nombreHechizo, String tipo, int daño) {
		this.nombreHechizo = nombreHechizo;
		this.tipo = tipo;
		this.daño = daño;
	}

	public String getNombreHechizo() {
		return nombreHechizo;
	}

	public String getTipo() {
		return tipo;
	}

	public int getDaño() {
		return daño;
	}

	@Override
	public String toString() {
		return "Spell [nombreHechizo=" + nombreHechizo + ", tipo=" + tipo + ", daño=" + daño + "]";
	}
	
	
	
	
	
	


}
