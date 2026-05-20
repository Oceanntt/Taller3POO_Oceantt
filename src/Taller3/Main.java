package Taller3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

public static void main(String[] args) throws FileNotFoundException {
	Scanner scanner = new Scanner(System.in);
	File magos = new File("Magos.txt");
	File hechizos = new File("Hechizos.txt");
	ArrayList<Mago> listamagos = new ArrayList<>();
	ArrayList<Hechizo> listahechizos = new ArrayList<>();


	System.out.println("Bienvenido al menu de magia\nIngrese el formato que desea\n1)Analista\n2)Administrador");
	int opcion = pediropcion(scanner,1,2);
	switch (opcion) {
	case 1:
		while(true) {
	System.out.println("Bienvenido al menu de Analista");
	System.out.println("1. Top 10 Mejores Hechizos\r\n"
			+ "2. Top 3 Mejores Magos\r\n"
			+ "3. Mostrar todos los Hechizos\r\n"
			+ "4. Mostrar todos los magos\r\n"
			+ "5. Mostrar todos los Hechizos junto a su puntuacion\r\n"
			+ "6. Mostrar todos los magos junto a su puntuacion");
		
	int analizar = pediropcion(scanner,1,6);	
	switch (analizar) {
	case 1:
		listahechizos = leerhechizos(hechizos);
		listahechizos.sort((h1, h2) -> Integer.compare(h2.calcularPuntaje(), h1.calcularPuntaje()));
		System.out.println("TOP 10 HECHIZOS:");

		for (int i = 0; i <10; i++) {
		    Hechizo h = listahechizos.get(i);

		    System.out.println(
		        (i + 1) + ") " +
		        h.getNombre() +
		        " -> Puntaje: " +
		        h.calcularPuntaje()
		    );
		}
		break;
	case 2:
	case 3:
	case 4:
	case 5: 
	case 6:

	default:
		break;
	}
	
		break;
		
		
		}
		
		
		
		
		
		
		break;
		
		
		
		
		
		
		
		
		
		
	case 2:
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		break;
		
		
		
		
		
	default:
		break;
	}
	
	

	
	
}






public static int pediropcion(Scanner scanner,int primeraOpcion, int ultimaOpcion) {
	int opcion = 0;
    boolean valido = false;

    while (!valido) {
        try {
            System.out.print("Ingrese una opción (" + primeraOpcion + "-" + ultimaOpcion + "): ");
            opcion = scanner.nextInt();

            if (opcion >= primeraOpcion && opcion <= ultimaOpcion) {
                valido = true;
            } else {
                System.out.println("Error: opción fuera de rango.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Error: debe ingresar un número entero.");
            scanner.nextLine(); //
        }
    }

    return opcion;
}

public static ArrayList<Hechizo> leerhechizos(File hechizos) throws FileNotFoundException{
	Scanner lector = new Scanner(hechizos);
	ArrayList<Hechizo> listahechizos = new ArrayList<>();
	while (lector.hasNextLine()) {
		String linea = lector.nextLine();
		String[] partes = linea.split(";");
		String nombre = partes[0];
		String tipo = partes[1];
		int daño = Integer.parseInt(partes[2]);
		if (tipo.equals("Tierra")) {
			int mejora = Integer.parseInt(partes[3]);
			Tierra tierra = new Tierra(nombre,daño,mejora);
			listahechizos.add(tierra);
		}
		else if (tipo.equals("Fuego")) {
			int quemadura = Integer.parseInt(partes[3]);
			Fuego fuego = new Fuego(nombre,daño,quemadura);
			listahechizos.add(fuego);
			
		}
		else if (tipo.equals("Agua")) {
			String[] stats = partes[3].split(",");
			int heal = Integer.parseInt(stats[0]);
			int presion = Integer.parseInt(stats[1]);
			Agua agua = new Agua(nombre,daño,heal,presion);
			listahechizos.add(agua);
		}
		else if (tipo.equals("Planta")) {
			String[] stats = partes[3].split(",");
			int stun = Integer.parseInt(stats[0]);
			int cantidad = Integer.parseInt(stats[1]);
			Planta planta = new Planta(nombre,daño,stun,cantidad);
			listahechizos.add(planta);
		}
		
	}
	
	return listahechizos;
}

public static ArrayList<Mago> leermagos(File magos) throws FileNotFoundException{
	Scanner lector = new Scanner(magos);
	ArrayList<Mago> listamagos = new ArrayList<>();
	
	while (lector.hasNextLine()) {
		ArrayList<Hechizo> listahechizos = new ArrayList<>();
		String linea = lector.nextLine();
		String[] partes = linea.split(";");
		String nombre = partes[0];
		String hechizosmago = partes[1];
		String[] listahechizosmago = hechizosmago.split("|");
		for (int i = 0; i < listahechizosmago.length; i++) {
			listahechizos.add(buscarhechizo(listahechizosmago[i]));
		}
		Mago mago = new Mago(nombre,listahechizos);
		listamagos.add(mago);
	
		
	}
	
	return listamagos;
	
}
	
public static Hechizo buscarhechizo(String nombre) throws FileNotFoundException {
	File hechizos = new File("Hechizos.txt");
	Scanner lector = new Scanner(hechizos);
	while (lector.hasNextLine()) {
		String linea = lector.nextLine();
		String[] partes = linea.split(";");
		String nombreh = partes[0];
		
		if (nombre.equals(nombreh)) {
			String tipo = partes[1];
			int daño = Integer.parseInt(partes[2]);
			if (tipo.equals("Tierra")) {
				int mejora = Integer.parseInt(partes[3]);
				Tierra tierra = new Tierra(nombre,daño,mejora);
				return tierra;
			}
			else if (tipo.equals("Fuego")) {
				int quemadura = Integer.parseInt(partes[3]);
				Fuego fuego = new Fuego(nombre,daño,quemadura);
				return fuego;
			}
			else if (tipo.equals("Agua")) {
				String[] stats = partes[3].split(",");
				int heal = Integer.parseInt(stats[0]);
				int presion = Integer.parseInt(stats[1]);
				Agua agua = new Agua(nombre,daño,heal,presion);
				return agua;
			}
			else if (tipo.equals("Planta")) {
				String[] stats = partes[3].split(",");
				int stun = Integer.parseInt(stats[0]);
				int cantidad = Integer.parseInt(stats[1]);
				Planta planta = new Planta(nombre,daño,stun,cantidad);
				return planta;
			}
		}
		
	}
	return null;
	
}
}




