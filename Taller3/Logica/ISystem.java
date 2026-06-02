package Logica;

import java.util.List;

public interface ISystem {
	
	void createMage(String[] partes);
	void createSpell(String[] partes);
	void addMage(String name,List<Integer> listaIndices);
	void sobrescribirArchMages();
	void sobrescribirArchSpell();
	void addSpell(String name, String tipo, int daño, String variable);
	void modificarMagoHechizo(int indice,int opcion, int indiceSpell);
	void removerHechizo(int indice);
	void removerMago(int indice);
	String modificarHechizo(int indice, int key, int valor);
	String modificarDaño(int indiceSpell, int dañoNuevo);
	String viewSpells();
	String viewMages();
	String mejoresHechizos();
	String mejoresMagos();
	String viewSpellPuntuacion();
	String viewMagesPuntuacion();
	String getListaSpellMago(int indiceMago);
	String getMenuAtributosSpells(int indice);
	int getConteoAtributos(int indice);

}
