package Taller3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

public static void main(String[] args) throws IOException {
	Scanner scanner = new Scanner(System.in);
	File magos = new File("Magos.txt");
	File hechizos = new File("Hechizos.txt");
	ArrayList<Mago> listamagos = new ArrayList<>();
	ArrayList<Hechizo> listahechizos = new ArrayList<>();

while (true) {
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
			+ "6. Mostrar todos los magos junto a su puntuacion\r\n"
			+"7. Regresar");
		
	int analizar = pediropcion(scanner,1,7);	
	switch (analizar) {
	case 7: break;
	case 1:
		listahechizos = leerhechizos(hechizos);
		listahechizos.sort((h1, h2) -> Integer.compare(h2.calcularPuntaje(), h1.calcularPuntaje()));
		System.out.println("TOP 10 MEJORES HECHIZOS:");

		for (int i = 0; i <10; i++) {
		    Hechizo h = listahechizos.get(i);

		    System.out.println(
		        (i + 1) + ") " + h.getNombre() + " -> Puntaje: " + h.calcularPuntaje());
		}
		break;
	case 2:
		listamagos = leermagos(magos);
		listamagos.sort((m1,m2)->Integer.compare(m2.calcularPuntaje(), m1.calcularPuntaje()));
		System.out.println("TOP 3 MEJORES MAGOS;");
		for (int i = 0; i <3; i++) {
		    Mago m = listamagos.get(i);

		    System.out.println(
		        (i + 1) + ") " +m.getNombre() + " -> Puntaje: " + m.calcularPuntaje());
		}
		
		
		break;
	case 3:
		
		listahechizos = leerhechizos(hechizos);
		for (int i = 0; i < listahechizos.size(); i++) {
			System.out.println(i+1+")"+listahechizos.get(i).getNombre());
		}
		break;
	case 4:
		
		listamagos = leermagos(magos);
		for (int i = 0; i <listamagos.size(); i++) {
			System.out.println(i+1+")"+listamagos.get(i).getNombre());
		}
		break;
	case 5: 
		listahechizos = leerhechizos(hechizos);
		for (int i = 0; i < listahechizos.size(); i++) {
			System.out.println(i+1+")"+listahechizos.get(i).getNombre()+": Puntuacion = "+ listahechizos.get(i).calcularPuntaje());
		}
		break;
	case 6:
		listamagos = leermagos(magos);
		for (int i = 0; i <listamagos.size(); i++) {
			System.out.println(i+1+")"+listamagos.get(i).getNombre()+": Puntuacion = "+ listamagos.get(i).calcularPuntaje());
		}
		break;
	}
	if (analizar == 7) {
	    break;
	}

		}
		break;
	
		
		
		
		
	case 2:
		
		
		System.out.println("1. Agregar Mago\r\n"
				+ "2. Modificar Mago\r\n"
				+ "3. Eliminar Mago\r\n"
				+ "4. Agregar Hechizo\r\n"
				+ "5. Modificar Hechizo\r\n"
				+ "6. Eliminar Hechizo");
		
		 opcion = pediropcion(scanner,1,6);
		
		
		switch (opcion) {
		case 1:
			System.out.print("Ingrese nombre del mago: ");
			String nombre = scanner.nextLine();
			String linea = nombre+";";
			int contador = 0;
			while (true) {
				System.out.println("Ingrese nombre de hechizo del mago (0 para finalizar): ");
				String buscar = scanner.nextLine();
				if (buscar.equals("0") && contador >0) {
					break;
				}
				else if(buscar.equals("0") && contador ==0) {
					System.out.println("Debe tener minimo un hechizo para ser un mago");
					continue;
				}
				Hechizo hechizo = buscarhechizo(buscar);
				if (hechizo == null) {System.out.println("Hechizo inexistente");}
				else {
					linea += hechizo.getNombre()+"|";
					contador+=1;
				}
				
				
				
				
			}
			linea = linea.substring(0,linea.length()-1);
	
			agregarlinea(magos,linea);
			
			
			break;

		case 2:
			modificarlinea(magos,scanner,0);
			break;
			
		
		case 3:
			eliminarlinea(scanner,magos);
			System.out.println("Mago eliminado con exito");
			break;
			
		case 4:
			System.out.print("Ingrese nombre del hechizo: ");
			 nombre = scanner.nextLine();
			 linea = nombre+";";
			 String tipo = "";
			 int daño = 0;
			while (true) {
				System.out.print("Ingrese Tipo del hechizo:");
				 tipo = scanner.nextLine();
				if (!tipo.equals("Fuego")&&!tipo.equals("Agua")&&!tipo.equals("Tierra")&&!tipo.equals("Planta")) {
					System.out.println("Tipo invalido");
					continue;
				}
				else {break;}
			}
			while(true) {
				System.out.print("Ingrese daño del hechizo:");
				try {
					daño = scanner.nextInt();
					scanner.nextLine();
					
				} catch (Exception e) {
					System.out.println("Ingrese un numero");
					continue;
				}
				break;
			}
			if (tipo.equals("Tierra")) {
			    int mejora = 0;
			    while (true) {
			        System.out.print("Ingrese mejora de defensa: ");
			        try {
			            mejora = scanner.nextInt();
			            scanner.nextLine();
			            break;
			        }
			        catch (Exception e) {
			            System.out.println("Ingrese un numero");
			            scanner.nextLine();
			        }
			    }
			    linea += tipo + ";" + daño + ";" + mejora;
			}
			else if (tipo.equals("Fuego")) {
			    int quemadura = 0;
			    while (true) {
			        System.out.print("Ingrese quemadura: ");
			        try {
			            quemadura = scanner.nextInt();
			            scanner.nextLine();
			            break;
			        }
			        catch (Exception e) {
			            System.out.println("Ingrese un numero");
			            scanner.nextLine();
			        }
			    }
			    linea += tipo + ";" + daño + ";" + quemadura;
			}

			else if (tipo.equals("Agua")) {
			    int heal = 0;
			    int presion = 0;
			    while (true) {
			        System.out.print("Ingrese heal: ");
			        try {
			            heal = scanner.nextInt();
			            scanner.nextLine();
			            break;
			        }
			        catch (Exception e) {
			            System.out.println("Ingrese un numero");
			            scanner.nextLine();
			        }
			    }
			    while (true) {
			        System.out.print("Ingrese presion: ");
			        try {
			            presion = scanner.nextInt();
			            scanner.nextLine();
			            break;
			        }
			        catch (Exception e) {
			            System.out.println("Ingrese un numero");
			            scanner.nextLine();
			        }
			    }

			    linea += tipo + ";" + daño + ";" + heal + "," + presion;
			}
			else if (tipo.equals("Planta")) {
			    int stun = 0;
			    int cantidad = 0;
			    while (true) {
			        System.out.print("Ingrese stun: ");
			        try {
			            stun = scanner.nextInt();
			            scanner.nextLine();
			            break;
			        }
			        catch (Exception e) {
			            System.out.println("Ingrese un numero");
			            scanner.nextLine();
			        }
			    }
			    while (true) {
			        System.out.print("Ingrese cantidad: ");
			        try {
			            cantidad = scanner.nextInt();
			            scanner.nextLine();
			            break;
			        }
			        catch (Exception e) {
			            System.out.println("Ingrese un numero");
			            scanner.nextLine();
			        }
			    }
			    linea += tipo + ";" + daño + ";" + stun + "," + cantidad;
			}
			agregarlinea(hechizos,linea);
			break;
		case 5:
			modificarlinea(hechizos,scanner,1);
			break;
		case 6:
			eliminarlinea(scanner,hechizos);
			System.out.println("Hechizo eliminado con exito");
			
			
			break;
		default:
			break;
		}
		
		
		
		
		
		
		
		
		break;
		
		
		
		
		
	default:
		break;
	}
	
	

}
	
}






public static int pediropcion(Scanner scanner,int primeraOpcion, int ultimaOpcion) {
	int opcion = 0;
    boolean valido = false;

    while (!valido) {
        try {
            System.out.print("Ingrese una opción (" + primeraOpcion + "-" + ultimaOpcion + "): ");
            opcion = scanner.nextInt();
            scanner.nextLine();

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
	lector.close();
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
		String[] listahechizosmago = hechizosmago.split("\\|");
		for (int i = 0; i < listahechizosmago.length; i++) {
			listahechizos.add(buscarhechizo(listahechizosmago[i]));
		}
		Mago mago = new Mago(nombre,listahechizos);
		listamagos.add(mago);
	
		
	}
	lector.close();
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
	lector.close();
	return null;
	
}

public static void agregarlinea(File archivo, String linea) throws IOException {
	BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo,true));
	escritor.newLine();
	escritor.write(linea);
	escritor.close();
	
	
	
	
}
public static void modificarlinea(File archivo, Scanner scanner, int tipo) throws IOException{
	Scanner lector = new Scanner(archivo);
	int contador = 0;
	ArrayList<String> lineas = new ArrayList<>();

	while (lector.hasNextLine()) {
		contador++;
		String linea = lector.nextLine();
		lineas.add(linea);
		System.out.println(contador+")"+linea);

	}

	int opcion = pediropcion(scanner,1,contador);
	String lineamod = lineas.get(opcion-1);
	String[] partes = lineamod.split(";");

	if (tipo == 0) { 
		System.out.println("Que deseas modificar\n1)Nombre\n2)Hechizos");
		int opcion2 = pediropcion(scanner,1,2);

		if (opcion2 == 1) {
			System.out.print("Ingrese nuevo nombre: ");
			String nombre = scanner.nextLine();

			String nuevalinea = nombre + ";" + partes[1];
			lineas.set(opcion-1, nuevalinea);
		}

		else if (opcion2 == 2) {
			String linea = partes[0] + ";";
			int contadorhechizos = 0;

			while (true) {
				System.out.println("Ingrese nombre de hechizo del mago (0 para finalizar): ");
				String buscar = scanner.nextLine();

				if (buscar.equals("0") && contadorhechizos > 0) {
					break;
				}

				else if (buscar.equals("0") && contadorhechizos == 0) {
					System.out.println("Debe tener minimo un hechizo para ser un mago");
					continue;
				}

				Hechizo hechizo = buscarhechizo(buscar);

				if (hechizo == null) {
					System.out.println("Hechizo inexistente");
				}
				else {
					linea += hechizo.getNombre()+"|";
					contadorhechizos++;
				}
			}

			linea = linea.substring(0,linea.length()-1);

			lineas.set(opcion-1,linea);
		}
		lector.close();
	}

	else if (tipo == 1) { 

		String nombre = partes[0];
		String nombreViejo = nombre;
		String tipohechizo = partes[1];
		int daño = Integer.parseInt(partes[2]);

		if (tipohechizo.equals("Tierra")) {
			System.out.println("Que deseas modificar\n1)Nombre\n2)Daño\n3)Mejora");
			int opcion2 = pediropcion(scanner,1,3);
			int mejora = Integer.parseInt(partes[3]);
			if (opcion2 == 1) {
			    nombre = scanner.nextLine();
			    actualizarNombreHechizoEnMagos(nombreViejo, nombre);
			}
			else if (opcion2 == 2) {
			    daño = scanner.nextInt();
			    scanner.nextLine();
			}
			else if (opcion2 == 3) {
			    mejora = scanner.nextInt();
			    scanner.nextLine();
			}

			lineas.set(opcion-1,nombre+";Tierra;"+daño+";"+mejora);
		}

		else if (tipohechizo.equals("Fuego")) {
			System.out.println("Que deseas modificar\n1)Nombre\n2)Daño\n3)Quemadura");
			int opcion2 = pediropcion(scanner,1,3);
			int quemadura = Integer.parseInt(partes[3]);

			if (opcion2 == 1) {
			    nombre = scanner.nextLine();
			    actualizarNombreHechizoEnMagos(nombreViejo, nombre);
			}
			else if (opcion2 == 2) {
			    daño = scanner.nextInt();
			    scanner.nextLine();
			}
			else if (opcion2 == 3) {
			    System.out.print("Ingrese nueva quemadura: ");
			    quemadura = scanner.nextInt();
			    scanner.nextLine();
			}

			lineas.set(opcion-1,nombre+";Fuego;"+daño+";"+quemadura);
			}

		else if (tipohechizo.equals("Agua")) {
			String[] stats = partes[3].split(",");
			int heal = Integer.parseInt(stats[0]);
			int presion = Integer.parseInt(stats[1]);

			System.out.println("Que deseas modificar\n1)Nombre\n2)Daño\n3)Heal\n4)Presion");
			int opcion2 = pediropcion(scanner,1,4);

			if (opcion2 == 1) {
				System.out.print("Ingrese nuevo nombre: ");
				nombre = scanner.nextLine();
				actualizarNombreHechizoEnMagos(nombreViejo, nombre);
			}
			else if (opcion2 == 2) {
				System.out.print("Ingrese nuevo daño: ");
				daño = scanner.nextInt();
				scanner.nextLine();
			}
			else if (opcion2 == 3) {
				System.out.print("Ingrese nuevo heal: ");
				heal = scanner.nextInt();
				scanner.nextLine();
			}
			else if (opcion2 == 4) {
				System.out.print("Ingrese nueva presion: ");
				presion = scanner.nextInt();
				scanner.nextLine();
			}

			lineas.set(opcion-1,nombre+";Agua;"+daño+";"+heal+","+presion);
		}

		else if (tipohechizo.equals("Planta")) {
			String[] stats = partes[3].split(",");
			int stun = Integer.parseInt(stats[0]);
			int cantidad = Integer.parseInt(stats[1]);

			System.out.println("Que deseas modificar\n1)Nombre\n2)Daño\n3)Stun\n4)Cantidad");
			int opcion2 = pediropcion(scanner,1,4);

			if (opcion2 == 1) {
				System.out.print("Ingrese nuevo nombre: ");
				nombre = scanner.nextLine();
			    actualizarNombreHechizoEnMagos(nombreViejo, nombre);
			}
			else if (opcion2 == 2) {
				System.out.print("Ingrese nuevo daño: ");
				daño = scanner.nextInt();
				scanner.nextLine();
			}
			else if (opcion2 == 3) {
				System.out.print("Ingrese nuevo stun: ");
				stun = scanner.nextInt();
				scanner.nextLine();
			}
			else if (opcion2 == 4) {
				System.out.print("Ingrese nueva cantidad: ");
				cantidad = scanner.nextInt();
				scanner.nextLine();
			}

			lineas.set(opcion-1,nombre+";Planta;"+daño+";"+stun+","+cantidad);
		}
	}
	BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo));
	for (int i = 0; i < lineas.size(); i++) {
		if (i==lineas.size()-1) {
			escritor.write(lineas.get(i));
		}
		else {
		escritor.write(lineas.get(i)+"\n");
		}	
	}

	escritor.flush();
	escritor.close();
}
public static void actualizarNombreHechizoEnMagos(String nombreViejo, String nombreNuevo) throws IOException {
    File magos = new File("Magos.txt");

    Scanner lector = new Scanner(magos);
    ArrayList<String> lineas = new ArrayList<>();

    while (lector.hasNextLine()) {
        String linea = lector.nextLine();

        String[] partes = linea.split(";");

        if (partes.length < 2) {
            lineas.add(linea);
            continue;
        }

        String nombreMago = partes[0];
        String[] hechizos = partes[1].split("\\|");

        for (int i = 0; i < hechizos.length; i++) {
            if (hechizos[i].equals(nombreViejo)) {
                hechizos[i] = nombreNuevo;
            }
        }

        String nuevaLinea = nombreMago + ";" + String.join("|", hechizos);
        lineas.add(nuevaLinea);
    }

    lector.close();

    BufferedWriter escritor = new BufferedWriter(new FileWriter(magos));

    for (int i = 0; i < lineas.size(); i++) {
        escritor.write(lineas.get(i));

        if (i < lineas.size() - 1) {
            escritor.newLine();
        }
    }

    escritor.close();
}

public static void eliminarlinea(Scanner scanner, File arch) throws IOException {
    Scanner lector = new Scanner(arch);
    int contador = 0;
    ArrayList<String> lineas = new ArrayList<>();
    while (lector.hasNextLine()) {
        contador++;
        String linea = lector.nextLine();
        lineas.add(linea);
        System.out.println(contador + ")" + linea);
    }
    System.out.println("Cual deseas eliminar?");
    int opcion = pediropcion(scanner, 1, contador);
    String lineaEliminada = lineas.get(opcion - 1);
    lineas.remove(opcion - 1);
    BufferedWriter escritor = new BufferedWriter(new FileWriter(arch));

    for (int i = 0; i < lineas.size(); i++) {
        if (i == lineas.size() - 1) {
            escritor.write(lineas.get(i));
        } else {
            escritor.write(lineas.get(i) + "\n");
        }
    }

    escritor.close();
    lector.close();
    if (arch.getName().equals("Hechizos.txt")) {
        String nombreHechizo = lineaEliminada.split(";")[0];
        File magos = new File("Magos.txt");
        Scanner lectorMagos = new Scanner(magos);
        ArrayList<String> nuevasLineas = new ArrayList<>();

        while (lectorMagos.hasNextLine()) {
            String linea = lectorMagos.nextLine();
            String[] partes = linea.split(";");
            String nombreMago = partes[0];
            String[] hechizos = partes[1].split("\\|");
            String nuevaLista = "";
            for (int i = 0; i < hechizos.length; i++) {
                if (!hechizos[i].equals(nombreHechizo)) {
                    if (!nuevaLista.equals("")) {
                        nuevaLista += "|";
                    }
                    nuevaLista += hechizos[i];
                }
            }
            if (!nuevaLista.equals("")) {
                nuevasLineas.add(nombreMago + ";" + nuevaLista);
            }
        }
        lectorMagos.close();
        BufferedWriter escritorMagos = new BufferedWriter(new FileWriter(magos));
        for (int i = 0; i < nuevasLineas.size(); i++) {
            if (i == nuevasLineas.size() - 1) {
                escritorMagos.write(nuevasLineas.get(i));
            } else {
                escritorMagos.write(nuevasLineas.get(i) + "\n");
            }
        }
        escritorMagos.close();
    }
}

}




