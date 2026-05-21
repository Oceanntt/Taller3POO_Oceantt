package Taller3;

import java.util.ArrayList;

public class Mago implements CalcularPuntaje{
	String nombre;
	ArrayList<Hechizo> hechizos;

	public Mago(String nombre, ArrayList<Hechizo> hechizos) {
		this.nombre = nombre;
		this.hechizos = hechizos;

	}
	public String getNombre() {
		return nombre;
	}

	@Override
	public int calcularPuntaje() {
		int total = 0;
		for (int i = 0; i < hechizos.size(); i++) {
			Hechizo hechizo = hechizos.get(i);
			total += hechizo.calcularPuntaje();
		}
		return total;
	}

}
