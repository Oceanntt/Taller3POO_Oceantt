package Taller3;

public abstract class  Hechizo implements CalcularPuntaje {
	private String nombre;
	protected int daño;
	protected int puntaje;
	
	public Hechizo(String nombre, int daño) {
		this.nombre = nombre;
		this.daño = daño;
		this.puntaje = 0;

	}
	public int getDaño() {
		return daño;
	}
	public String getNombre() {
		return nombre;
	}
	


	 @Override
	    public abstract int calcularPuntaje();

	
	

}
