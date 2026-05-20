package Taller3;

public class Planta extends Hechizo {
int cantidad;
int stun; 
	public Planta(String nombre, int daño, int stun,int cantidad) {
		super(nombre,daño);
		this.cantidad = cantidad;
		this.stun = stun;
	}

	@Override
	public int calcularPuntaje() {
		this.puntaje = daño + (stun*cantidad);
		return puntaje;
	}

}
