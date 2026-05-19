package Taller3;

public class Tierra extends Hechizo  {
	int mejora;

	public Tierra(String nombre, int daño, int mejora) {
		super(nombre,daño);
		this.mejora = mejora;
	}

	@Override
	public double calcularPuntaje() {

		return 0;
	}

}
