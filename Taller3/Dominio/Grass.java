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
	
	@Override
	public double puntuacion() {
		double puntero = this.daño + (this.duracionStun * this.cantPlantas);
		return puntero;
	}
	
	@Override
	public String lineaTxt() {
		String linea = this.nombreHechizo+";"+this.tipo+";"+this.daño+";"+this.duracionStun+","+cantPlantas;
		return linea;
	}
	
	@Override
	public void settAtributo(int opcion, int valor) {
		switch(opcion) {
		case 1:
			this.duracionStun = valor;
			break;
		case 2:
			this.cantPlantas = valor;
			break;
		}
		
	}
	
	@Override
	public String getMenuAtributos() {
		String linea = "1.- Duracion del Stun"
				+ "\n2.- Cantidad de Plantas";
		return linea;
	}
	
	@Override
	public int getContadorAtributos() {
		return 2;
	}
	
	
	
	
	
	
}
