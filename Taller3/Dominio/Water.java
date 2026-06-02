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

	public void setCantHeal(int cantHeal) {
		this.cantHeal = cantHeal;
	}

	public void setPresionAgua(int presionAgua) {
		this.presionAgua = presionAgua;
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
	
	@Override
	public void settAtributo(int opcion, int valor) {
		switch(opcion) {
		
		case 1:
			this.cantHeal = valor;
			break;
		case 2:
			this.presionAgua = valor;
			break;
		}
	}
	
	@Override
	public String getMenuAtributos() {
		String linea = "1.- Cantidad de Heal"
				+ "\n2.- Presion del Agua";
		return linea;
	}
	
	@Override
	public int getContadorAtributos() {
		return 2;
	}
	
	
	
}
