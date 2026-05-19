package Taller3;

public class Agua extends Hechizo {
int heal;
int presion;
	public Agua(String nombre, int daño, int heal,int presion) {
		super(nombre,daño);
		this.heal = heal;
		this.presion = presion;
	}

	@Override
	public double calcularPuntaje() {

		return 0;
	}

}
