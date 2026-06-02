package Dominio;

public abstract class Spell implements Condicional{
	
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

	public void setDaño(int daño) {
		this.daño = daño;
	}

	@Override
	public String toString() {
		return "Spell [nombreHechizo=" + nombreHechizo + ", tipo=" + tipo + ", daño=" + daño + "]";
	}
	
	@Override
	public double puntuacion() {
		return 0.0;
		
	}
	
	@Override
	public String lineaTxt() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public abstract void settAtributo(int opcion, int valor);
	
	public abstract String getMenuAtributos();
	public abstract int getContadorAtributos();
	
	
	
	
	


}
