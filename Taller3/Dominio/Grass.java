package Dominio;

public class Grass extends Spell{
	
	private int duracionStun;
	private int cantPlantas;
	
	public Grass(String nombreHechizo, String tipo, int daño,int duracionStun,int cantPlantas) {
		super(nombreHechizo, tipo, daño);
		this.duracionStun = duracionStun;
		this.cantPlantas = cantPlantas;
	}

	public int getDuracionStun() {
		return duracionStun;
	}

	public int getCantPlantas() {
		return cantPlantas;
	}

	@Override
	public String toString() {
		return "Nombre: "+nombreHechizo+" | Tipo: "+tipo+" | Daño: "+daño+" | Duracion Stun: "+duracionStun+" | Cantidad plantas: "+cantPlantas;
	}
	
	
	
	
}
