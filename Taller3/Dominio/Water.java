package Dominio;

public class Water extends Spell{

	private int cantHeal;
	private int presionAgua;
	
	public Water(String nombreHechizo, String tipo, int daño, int cantHeal,int presionAgua) {
		super(nombreHechizo, tipo, daño);
		this.cantHeal = cantHeal;
		this.presionAgua = presionAgua;
	}

	public int getCantHeal() {
		return cantHeal;
	}

	public int getPresionAgua() {
		return presionAgua;
	}

	@Override
	public String toString() {
		return "Nombre: "+nombreHechizo+" | Tipo: "+tipo+" | Daño: "+daño+" | Cantidad de Heal: "+cantHeal+" | Presion del Agua: "+presionAgua;
	}
	
	@Override
	public double puntuacion() {
		double puntero = (this.daño + this.cantHeal + this.presionAgua)*2;
		return puntero;
	}
	
	@Override
	public String lineaTxt() {
		String linea = this.nombreHechizo+";"+this.tipo+";"+this.daño+";"+this.cantHeal+","+this.presionAgua;
		return linea;
	}
	
	
	
	
}
