package Dominio;

public class Fire extends Spell{
	
	private int duracion;
	
	public Fire(String nombreHechizo, String tipo, int daño,int duracion) {
		super(nombreHechizo, tipo, daño);
		this.duracion = duracion;
	}

	public int getDuracion() {
		return duracion;
	}

	@Override
	public String toString() {
		return "Nombre: "+nombreHechizo+" | Tipo: "+tipo+" | Daño: "+daño+" | Duracion Quemadura: "+duracion;
	}
	
	@Override
	public double puntuacion() {
		double puntero = this.daño * this.duracion;
		return puntero;
	}
	
	@Override
	public String lineaTxt() {
		String linea = this.nombreHechizo+";"+this.tipo+";"+this.daño+";"+this.duracion;
		return linea;
	}
	
	@Override
	public void settAtributo(int opcion, int valor) {
		switch(opcion) {
		case 1:
			this.duracion = valor;
		}
	}
	
	@Override
	public String getMenuAtributos() {
		String linea = "1.- Duracion Quemadura";
		return linea;
	}
	
	@Override
	public int getContadorAtributos() {
		return 1;
	}

	
	
	

}
