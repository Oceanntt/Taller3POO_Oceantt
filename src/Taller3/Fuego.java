package Taller3;

public class Fuego extends Hechizo {
	int quemadura;
	public Fuego(String nombre, int daño, int quemadura) {
		super(nombre,daño);
		this.quemadura = quemadura;
	}

	@Override
	public double calcularPuntaje() {

		return 0;
	}

}
