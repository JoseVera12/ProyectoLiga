import java.util.Scanner;

public class Controlador {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		int eleccion = 0;
		String respuesta="";
		String respuesta2 = "";
		String equipomod;
		int contador = 0;
		int longitud;
		boolean encontrado = false;
		String green = "\033[32m";
		String red = "\033[31m";
		String yellow = "\u001B[33m";
		String black = "\u001B[30m";
		String colorStrange = "\u001B[36m";
		Scanner lector = new Scanner(System.in);

		Tabla s1 = new Tabla();
		s1.addEquipos(new Equipo("Barcelona          ", 0, 0, 0, 0, 0, 0, 0));
		s1.addEquipos(new Equipo("Real Madrid        ", 0, 0, 0, 0, 0, 0, 0));
		s1.addEquipos(new Equipo("Real Sociedad      ", 0, 0, 0, 0, 0, 0, 0));
		s1.addEquipos(new Equipo("Atletico de Madrid ", 0, 0, 0, 0, 0, 0, 0));
		s1.addEquipos(new Equipo("Rayo Vallecano     ", 0, 0, 0, 0, 0, 0, 0));
		s1.addEquipos(new Equipo("Villareal          ", 0, 0, 0, 0, 0, 0, 0));
		s1.addEquipos(new Equipo("Betis              ", 0, 0, 0, 0, 0, 0, 0));
		s1.addEquipos(new Equipo("Athletic Club      ", 0, 0, 0, 0, 0, 0, 0));
		s1.addEquipos(new Equipo("Osasuna            ", 0, 0, 0, 0, 0, 0, 0));
		s1.addEquipos(new Equipo("Mallorca           ", 0, 0, 0, 0, 0, 0, 0));
		s1.addEquipos(new Equipo("Girona             ", 0, 0, 0, 0, 0, 0, 0));
		s1.addEquipos(new Equipo("Celta              ", 0, 0, 0, 0, 0, 0, 0));
		s1.addEquipos(new Equipo("Valladolid         ", 0, 0, 0, 0, 0, 0, 0));
		s1.addEquipos(new Equipo("Almeria            ", 0, 0, 0, 0, 0, 0, 0));
		s1.addEquipos(new Equipo("Cadiz              ", 0, 0, 0, 0, 0, 0, 0));
		s1.addEquipos(new Equipo("Espanyol           ", 0, 0, 0, 0, 0, 0, 0));
		s1.addEquipos(new Equipo("Sevilla            ", 0, 0, 0, 0, 0, 0, 0));
		s1.addEquipos(new Equipo("Valencia           ", 0, 0, 0, 0, 0, 0, 0));
		s1.addEquipos(new Equipo("Getafe             ", 0, 0, 0, 0, 0, 0, 0));
		s1.addEquipos(new Equipo("Elche              ", 0, 0, 0, 0, 0, 0, 0));

		try {
			for (int i = 1; i < 20; i++) {
				Jornada j1 = new Jornada(i);
			}

			System.out.println(colorStrange
					+ "$$\\        $$$$$$\\        $$\\       $$$$$$\\  $$$$$$\\   $$$$$$\\        $$\\      $$\\  $$$$$$\\   $$$$$$\\         $$$$$$\\  $$\\   $$\\ $$$$$$\\ $$\\      $$\\ $$$$$$$\\   $$$$$$\\  \r\n"
					+ "$$ |      $$  __$$\\       $$ |      \\_$$  _|$$  __$$\\ $$  __$$\\       $$$\\    $$$ |$$  __$$\\ $$  __$$\\       $$  __$$\\ $$ |  $$ |\\_$$  _|$$$\\    $$$ |$$  __$$\\ $$  __$$\\ \r\n"
					+ "$$ |      $$ /  $$ |      $$ |        $$ |  $$ /  \\__|$$ /  $$ |      $$$$\\  $$$$ |$$ /  $$ |$$ /  \\__|      $$ /  \\__|$$ |  $$ |  $$ |  $$$$\\  $$$$ |$$ |  $$ |$$ /  $$ |\r\n"
					+ "$$ |      $$$$$$$$ |      $$ |        $$ |  $$ |$$$$\\ $$$$$$$$ |      $$\\$$\\$$ $$ |$$$$$$$$ |\\$$$$$$\\        $$ |      $$$$$$$$ |  $$ |  $$\\$$\\$$ $$ |$$$$$$$\\ |$$$$$$$$ |\r\n"
					+ "$$ |      $$  __$$ |      $$ |        $$ |  $$ |\\_$$ |$$  __$$ |      $$ \\$$$  $$ |$$  __$$ | \\____$$\\       $$ |      $$  __$$ |  $$ |  $$ \\$$$  $$ |$$  __$$\\ $$  __$$ |\r\n"
					+ "$$ |      $$ |  $$ |      $$ |        $$ |  $$ |  $$ |$$ |  $$ |      $$ |\\$  /$$ |$$ |  $$ |$$\\   $$ |      $$ |  $$\\ $$ |  $$ |  $$ |  $$ |\\$  /$$ |$$ |  $$ |$$ |  $$ |\r\n"
					+ "$$$$$$$$\\ $$ |  $$ |      $$$$$$$$\\ $$$$$$\\ \\$$$$$$  |$$ |  $$ |      $$ | \\_/ $$ |$$ |  $$ |\\$$$$$$  |      \\$$$$$$  |$$ |  $$ |$$$$$$\\ $$ | \\_/ $$ |$$$$$$$  |$$ |  $$ |\r\n"
					+ "\\________|\\__|  \\__|      \\________|\\______| \\______/ \\__|  \\__|      \\__|     \\__|\\__|  \\__| \\______/        \\______/ \\__|  \\__|\\______|\\__|     \\__|\\_______/ \\__|  \\__|\r\n"
					+ "                                                                                                                                                                          \r\n"
					+ "                                                                                                                                                                          \r\n"
					+ "                                                                                                                                                                          ");
			// Saca las jornadas y enfrentamientos
			s1.sacarLiga();
			// Suma los puntos , victorias, etc
			s1.sacarTabla();

			System.out.println(black
					+ "________________________________________________________________________________________________________________________________________________");

			System.out.println(" ");
			System.out.println(black
					+ "Club:               Victorias:     Empates:   Derrotas:      Goles a favor:     Goles en contra:      Diferencia Goles:         Puntos:  ");
			// Muestra la liga ordenada con todas sus caracteristicas
			s1.ordenarliga();
			/* Para ordenar la liga y que no se repitiera si algunos tenian los mismos
			 puntos iba eliminando los equipos
			 Por lo tanto en un método los vuelvo a añadir*/
			s1.añadirEquipos();
			s1.añadirJugadores();
			do {
				System.out.println("");
				System.out.println(black
						+ "________________________________________________________________________________________________________________________________________________");

				System.out.println("");
				System.out.println("MENÚ");
				System.out.println("1. Gestionar equipo");
				System.out.println("2. Buscar informacion de una jornada");
				System.out.println("3. Terminar");
				System.out.println("");
				System.out.print("Elección: ");

				eleccion = lector.nextInt();
				lector.nextLine();

				switch (eleccion) {
				case 1:
					System.out.println(black + "¿Qué equipo vas a querer modificar?(Introduce su nombre)");
					equipomod = lector.nextLine();
					longitud = s1.getListaEquipos().size();
					for (Equipo e1 : s1.getListaEquipos()) {
						e1.setNombre(e1.getNombre().trim());
					}
					contador = 0;
					encontrado = false;
					while (contador < longitud && !encontrado) {
						if (equipomod.equals(s1.getListaEquipos().get(contador).getNombre())) {
							encontrado = true;
							do {
								System.out.println(black + "¿Que modificación vas a hacer en el "
										+ s1.getListaEquipos().get(contador).getNombre() + " ?");
								System.out.println("");
								System.out.println(green + "1. Fichar Jugador");
								System.out.println(red + "2. Despedir Jugador");
								System.out.println(yellow + "3. Modificar Jugador");
								System.out.println(colorStrange + "4. Enseñar la plantilla");
								System.out.println(colorStrange + "5. Terminar");
								System.out.println("");
								System.out.print(colorStrange + "Elige que quieres hacer: ");

								eleccion = lector.nextInt();
								lector.nextLine();

								switch (eleccion) {
								case 1: {
									System.out.println("");
									s1.getListaEquipos().get(contador).FicharJugador();
									System.out.println("Genial!");
									System.out.println("¿Quieres hacer otra cosa?(si/no)");
									respuesta2 = lector.nextLine();
									break;
								}
								case 2: {
									System.out.println("");
									s1.getListaEquipos().get(contador).DespedirJugador();
									System.out.println("Genial!");
									System.out.println("¿Quieres hacer otra cosa?(si/no)");
									respuesta2 = lector.nextLine();
									break;
								}
								case 3: {
									System.out.println("");
									s1.getListaEquipos().get(contador).ModificarJugador();
									System.out.println("Genial!");
									System.out.println("¿Quieres hacer otra cosa?(si/no)");
									respuesta2 = lector.nextLine();
									break;
								}
								case 4: {
									System.out.println("");
									s1.getListaEquipos().get(contador).mostrarPlantilla();
									System.out.println("Genial!");
									System.out.println("¿Quieres hacer otra cosa?(si/no)");
									respuesta2 = lector.nextLine();
									break;
								}
								case 5: {
									System.out.println("");
									respuesta2 = "no";
									break;
								}
								default:
									System.out.println(red + "Error: la eleccion tiene que ser un numero del 1 al 5");
								}

							} while (respuesta2.equals("si"));
							longitud = contador;
						} else {
							contador++;
						}
					}
					if (!encontrado) {
						System.out.println(red + "Ese equipo no existe");
					}
					System.out.println("Y ahora:");
					System.out.println("¿Quieres hacer otra cosa?(si/no)");
					respuesta = lector.nextLine();
					break;
				case 2:
					s1.sacarJornada();
					System.out.println("Y ahora:");
					System.out.println("¿Quieres hacer otra cosa?(si/no)");
					respuesta = lector.nextLine();

					break;
				case 3:
					System.out.println(red + "FIN MENÚ");
					break;
				default:
					System.out.println(red + "Error: la eleccion tiene que ser un numero del 1 al 3");
					break;
				}

			} while (eleccion != 3);

			lector.close();
		} catch (IllegalArgumentException e) {
			System.out.println(red + "Error en el tipo de metodo");
		} catch (NullPointerException e) {
			System.out.println(red + "El argumento no debe ser null");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(red + "Error por posicion incorrecta del array");
		} catch (NoClassDefFoundError e) {
			System.out.println(red + "Clase no encontrada");
		} catch (Exception e) {
			System.out.println(red + "Error general");
		} finally {
			System.out.println(red + "Fin");
		}

	}
}
