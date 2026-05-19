package Taller3;

public abstract class  Hechizo implements CalcularPuntaje {
	private String nombre;
	private int daño;
	private int puntaje;
	
	public Hechizo(String nombre, int daño) {
		this.nombre = nombre;
		this.daño = daño;
		this.puntaje = 0;

	}


	 @Override
	    public abstract double calcularPuntaje();

	
	

}
