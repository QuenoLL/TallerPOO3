package Logica;

import java.util.List;

public interface ISystem {
	
	void createMage(String[] partes);
	void createSpell(String[] partes);
	void addMage(String name,List<Integer> listaIndices);
	String viewSpells();
	String viewMages();
	String mejoresHechizos();
	String mejoresMagos();
	String viewSpellPuntuacion();
	String viewMagesPuntuacion();

}
