package Dominio;

public class Ground extends Spell{
	 
	private int mejoraDefensa;
	
	public Ground(String nombreHechizo, String tipo, int daño,int mejoraDefensa) {
		super(nombreHechizo, tipo, daño);
		this.mejoraDefensa = mejoraDefensa;
	}

	public int getMejoraDefensa() {
		return mejoraDefensa;
	}

	@Override
	public String toString() {
		return "Nombre: "+nombreHechizo+" | Tipo:"+tipo+" | Daño:"+daño+" | Mejora Defensa: "+mejoraDefensa;
	}
	
	@Override
	public double puntuacion() {
		double puntero = (this.daño * this.mejoraDefensa)/2;
		return puntero;
	}
	
	@Override
	public String lineaTxt() {
		String linea = this.nombreHechizo+";"+this.tipo+";"+this.daño+";"+this.mejoraDefensa;
		return linea;
	}
	
	@Override
	public void settAtributo(int opcion, int valor) {
		switch(opcion) {
		case 1:
			this.mejoraDefensa = valor;
			break;
		}
	}
	
	@Override
	public String getMenuAtributos() {
		String linea = "1.- Mejora Defensa";
		return linea;
	}
	
	@Override
	public int getContadorAtributos() {
		return 1;
	}

	
}
