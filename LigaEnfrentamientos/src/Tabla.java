import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Tabla {
	private String nombre;
	private ArrayList<Equipo> listaEquipos = new ArrayList<Equipo>();
	private ArrayList<Enfrentamiento> listaEnfrentamientos = new ArrayList<Enfrentamiento>();
	private ArrayList<ArrayList<String>> Listajornadas = new ArrayList<ArrayList<String>>();

	public Tabla() {
		super();
	}

	public Tabla(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Equipo> getListaEquipos() {
		return listaEquipos;
	}

	public void setListaEquipos(ArrayList<Equipo> listaEquipos) {
		this.listaEquipos = listaEquipos;
	}

	public ArrayList<Enfrentamiento> getListaEnfrentamientos() {
		return listaEnfrentamientos;
	}

	public void setListaEnfrentamientos(ArrayList<Enfrentamiento> listaEnfrentamientos) {
		this.listaEnfrentamientos = listaEnfrentamientos;
	}

	public ArrayList<ArrayList<String>> getListajornadas() {
		return Listajornadas;
	}

	public void setListajornadas(ArrayList<ArrayList<String>> listajornadas) {
		Listajornadas = listajornadas;
	}

	@Override
	public String toString() {
		return "Tabla [nombre=" + nombre + ", listaEquipos=" + listaEquipos + ", listaEnfrentamientos="
				+ listaEnfrentamientos + ", Listajornadas=" + Listajornadas + "]";
	}

	public void addEquipos(Equipo item) {
		listaEquipos.add(item);
	}

	public void addEnfrentamiento(Enfrentamiento item) {
		listaEnfrentamientos.add(item);
	}

	public void sacarLiga() {
		int numEquipos = 20;
		int result2;
		int result1;

		int equipolocal;
		int equipovisitante;
		int numJornadas = 19;
		String ultimoEquipo;
		int contador2 = 0;
		String black = "\u001B[30m";
		String green = "\033[32m";
		String red = "\033[31m";
		String white = "\u001B[37m";
		// Creamos un array con los nombres de los equipos
		String[] equipos = new String[numEquipos];
		Collections.shuffle(listaEquipos);
		for (int i = 0; i < 190; i++) {
			Enfrentamiento e1 = new Enfrentamiento();
			listaEnfrentamientos.add(e1);
		}
		for (int i = 0; i < numEquipos; i++) {
			equipos[i] = listaEquipos.get(i).getNombre();
		}

		// Almacenamos los enfrentamientos por jornada en un array bidimensional
		String[][] enfrentamientos = new String[numJornadas][numEquipos / 2];
		// Generamos los enfrentamientos por jornada cogiendo el primero con el ultimo,
		// el segundo con el penultimo etc.

		for (int i = 0; i < numJornadas; i++) {
			for (int j = 0; j < numEquipos / 2; j++) {
				equipolocal = j;
				equipovisitante = numEquipos - 1 - j;
				enfrentamientos[i][j] = black+ equipos[equipolocal] + black + "   vs    " + black+ equipos[equipovisitante];
				listaEnfrentamientos.get(contador2).setEquipo1(equipos[equipolocal]);
				listaEnfrentamientos.get(contador2).setEquipo2(equipos[equipovisitante]);
				contador2++;

			}
			// Rotamos los equipos para generar los enfrentamientos de la siguiente jornada
			ultimoEquipo = equipos[numEquipos - 1];

			for (int k = numEquipos - 1; k > 1; k--) {
				equipos[k] = equipos[k - 1];

			}

			equipos[1] = ultimoEquipo;
		}
		// Mostramos los resultados por jornada
		contador2 = 0;
		for (int i = 0; i < numJornadas; i++) {
			System.out.println("");
			System.out.println(black + "------------- Jornada " + (i + 1) + " ---------------");
			System.out.println("");
			for (int j = 0; j < numEquipos / 2; j++) {
				result1 = (int) (Math.random() * (6 - 0)) + 0;
				result2 = (int) (Math.random() * (6 - 0)) + 0;

				System.out.println(enfrentamientos[i][j]);

				if (result1 > result2) {

					System.out.println(green + "                    " + result1 + "  -  " + red + result2);
				} else if (result2 > result1) {

					System.out.println(red + "                    " + result1 + "  -  " + green + result2);
				} else {

					System.out.println(white + "                    " + result1 + "  -  " + white + result2);
				}

				listaEnfrentamientos.get(contador2).setResultado1(result1);
				listaEnfrentamientos.get(contador2).setResultado2(result2);
				contador2++;

				System.out.println("");
			}

		}
	}

	public void sacarTabla() {

		int contador;
		int longitud = 20;
		boolean encontrado;

		for (Enfrentamiento e1 : listaEnfrentamientos) {
			contador = 0;
			encontrado = false;

			if (e1.getResultado1() > e1.getResultado2()) {
				while (contador < longitud && !encontrado) {
					if (e1.getEquipo1().equals(listaEquipos.get(contador).getNombre())) {
						encontrado = true;

						listaEquipos.get(contador).setPuntos(listaEquipos.get(contador).getPuntos() + 3);
						listaEquipos.get(contador).setVictorias(listaEquipos.get(contador).getVictorias() + 1);
						listaEquipos.get(contador)
								.setGolesafavor(listaEquipos.get(contador).getGolesafavor() + e1.getResultado1());
						listaEquipos.get(contador)
								.setGolesencontra(listaEquipos.get(contador).getGolesencontra() + e1.getResultado2());
						listaEquipos.get(contador)
								.setDg(listaEquipos.get(contador).getDg() + (e1.getResultado1() - e1.getResultado2()));
						contador = longitud;
					} else {
						contador++;
					}
				}
				contador = 0;
				encontrado = false;

				while (contador < longitud && !encontrado) {
					if (e1.getEquipo2().equals(listaEquipos.get(contador).getNombre())) {
						encontrado = true;
						listaEquipos.get(contador).setDerrotas(listaEquipos.get(contador).getDerrotas() + 1);
						listaEquipos.get(contador)
								.setGolesafavor(listaEquipos.get(contador).getGolesafavor() + e1.getResultado2());
						listaEquipos.get(contador)
								.setGolesencontra(listaEquipos.get(contador).getGolesencontra() + e1.getResultado1());
						listaEquipos.get(contador)
								.setDg(listaEquipos.get(contador).getDg() + (e1.getResultado2() - e1.getResultado1()));
						contador = longitud;
					} else {
						contador++;
					}
				}
			} else if (e1.getResultado1() < e1.getResultado2()) {
				contador = 0;
				encontrado = false;
				while (contador < longitud && !encontrado) {
					if (e1.getEquipo2().equals(listaEquipos.get(contador).getNombre())) {
						encontrado = true;

						listaEquipos.get(contador).setPuntos(listaEquipos.get(contador).getPuntos() + 3);
						listaEquipos.get(contador).setVictorias(listaEquipos.get(contador).getVictorias() + 1);
						listaEquipos.get(contador)
								.setGolesafavor(listaEquipos.get(contador).getGolesafavor() + e1.getResultado2());
						listaEquipos.get(contador)
								.setGolesencontra(listaEquipos.get(contador).getGolesencontra() + e1.getResultado1());
						listaEquipos.get(contador)
								.setDg(listaEquipos.get(contador).getDg() + (e1.getResultado2() - e1.getResultado1()));
						contador = longitud;
					} else {
						contador++;
					}
				}
				contador = 0;
				encontrado = false;

				while (contador < longitud && !encontrado) {
					if (e1.getEquipo1().equals(listaEquipos.get(contador).getNombre())) {
						encontrado = true;

						listaEquipos.get(contador).setDerrotas(listaEquipos.get(contador).getDerrotas() + 1);
						listaEquipos.get(contador)
								.setGolesafavor(listaEquipos.get(contador).getGolesafavor() + e1.getResultado1());
						listaEquipos.get(contador)
								.setGolesencontra(listaEquipos.get(contador).getGolesencontra() + e1.getResultado2());
						listaEquipos.get(contador)
								.setDg(listaEquipos.get(contador).getDg() + (e1.getResultado1() - e1.getResultado2()));
						contador = longitud;
					} else {
						contador++;
					}
				}
			} else if (e1.getResultado1() == e1.getResultado2()) {
				contador = 0;
				encontrado = false;
				while (contador < longitud && !encontrado) {
					if (e1.getEquipo1().equals(listaEquipos.get(contador).getNombre())) {
						encontrado = true;

						listaEquipos.get(contador).setPuntos(listaEquipos.get(contador).getPuntos() + 1);
						listaEquipos.get(contador).setEmpates(listaEquipos.get(contador).getEmpates() + 1);
						listaEquipos.get(contador)
								.setGolesafavor(listaEquipos.get(contador).getGolesafavor() + e1.getResultado1());
						listaEquipos.get(contador)
								.setGolesencontra(listaEquipos.get(contador).getGolesencontra() + e1.getResultado2());
						listaEquipos.get(contador)
								.setDg(listaEquipos.get(contador).getDg() + (e1.getResultado1() - e1.getResultado2()));
						contador = longitud;
					} else {
						contador++;
					}
				}
				contador = 0;
				encontrado = false;

				while (contador < longitud && !encontrado) {
					if (e1.getEquipo2().equals(listaEquipos.get(contador).getNombre())) {
						encontrado = true;

						listaEquipos.get(contador).setPuntos(listaEquipos.get(contador).getPuntos() + 1);
						listaEquipos.get(contador).setEmpates(listaEquipos.get(contador).getEmpates() + 1);
						listaEquipos.get(contador)
								.setGolesafavor(listaEquipos.get(contador).getGolesafavor() + e1.getResultado1());
						listaEquipos.get(contador)
								.setGolesencontra(listaEquipos.get(contador).getGolesencontra() + e1.getResultado2());
						listaEquipos.get(contador)
								.setDg(listaEquipos.get(contador).getDg() + (e1.getResultado1() - e1.getResultado2()));
						contador = longitud;
					} else {
						contador++;
					}
				}
			}
		}
	}

	public void sacarJornada() {

		int contador = 0;
		int eleccion;
		String black = "\u001B[30m";
		String red = "\033[31m";

		Scanner lector = new Scanner(System.in);

		for (int i = 0; i < 19; i++) {
			ArrayList<String> j1 = new ArrayList<String>();
			Listajornadas.add(j1);
			for (int j = 0; j < 10; j++) {
				j1.add(listaEnfrentamientos.get(contador).toString());
				contador++;
			}
		}

		System.out.println(black + "¿Qué jornada vas a elegir?(1-19)");
		eleccion = lector.nextInt();
		lector.nextLine();
		if (eleccion < 1 || eleccion > 19) {
			System.out.println(red + "ERROR: el número de jornada tiene que ser entre 1 y 19");
		} else {
			System.out.println(black
					+ "_______________________________________________________________________________________________________________________________________");
			System.out.println(" ");
			System.out.println(black + "                                     JORNADA " + eleccion);
			System.out.println(black
					+ "________________________________________________________________________________________________________________________________________");
			System.out.println(" ");

			for (int i = 0; i < 10; i++) {
				System.out.println("");
				System.out.println(Listajornadas.get(eleccion - 1).get(i).toString());
				System.out.println("");
			}

		}

	}

	public void ordenarliga() {
		String blue = "\033[34m";
		String yellow = "\u001B[33m";
		String red = "\033[31m";
		String white = "\u001B[37m";
		String green = "\033[32m";
		String black = "\u001B[30m";
		ArrayList<Integer> listapuntos = new ArrayList<Integer>();
		ArrayList<String> listafinal = new ArrayList<String>();

		for (Equipo e1 : listaEquipos) {
			listapuntos.add(e1.getPuntos());
		}
		Collections.sort(listapuntos);
		Collections.reverse(listapuntos);

		for (int i = 0; i < listapuntos.size(); i++) {
			for (int j = 0; j < listaEquipos.size(); j++) {
				if (listapuntos.get(i) == listaEquipos.get(j).getPuntos()) {
					listafinal.add(listaEquipos.get(j).getNombre() + "      " + listaEquipos.get(j).getVictorias()
							+ "           " + listaEquipos.get(j).getEmpates() + "            "
							+ listaEquipos.get(j).getDerrotas() + "             " + listaEquipos.get(j).getGolesafavor()
							+ "                    " + listaEquipos.get(j).getGolesencontra() + "                    "
							+ listaEquipos.get(j).getDg() + "                     " + listaEquipos.get(j).getPuntos());
					listaEquipos.remove(j);
				}

			}
		}
		// No se si es adecuado un bucle for a la hora de comparar el
				// lista.puntos.get(i) con los punto d un equipo, a lo mejor es más conveniente
				// un
				// while. Si es así, el código sería este:

				/*
				 * for (int i = 0; i < listapuntos.size(); i++) { encontrado=false; contador=0;
				 * while(contador<listaEquipos.size() && !encontrado){ if (listapuntos.get(i)
				 * == listaEquipos.get(j).getPuntos()) { encontrado=true; listafinal.add(....);
				 * listaEquipos.remove(j); listaEquipos.size() = contador; }else{ contador++; }
				 * } }
				 */
		for (int i = 0; i < 4; i++) {
			System.out.println(blue + listafinal.get(i));
		}
		for (int i = 4; i < 6; i++) {
			System.out.println(yellow + listafinal.get(i));
		}
		System.out.println(green + listafinal.get(6));
		for (int i = 7; i < 17; i++) {
			System.out.println(white + listafinal.get(i));
		}
		for (int i = 17; i < 20; i++) {
			System.out.println(red + listafinal.get(i));
		}
		System.out.println(black
				+ "________________________________________________________________________________________________________________________________________________");
		System.out.println(" ");
		System.out.print(black + " | ");
		System.out.print(blue + "Champions League");
		System.out.print(black + " | ");
		System.out.print(yellow + "Europa League");
		System.out.print(black + " | ");
		System.out.print(green + "Conference League");
		System.out.print(black + " | ");
		System.out.print(red + "Descenso");
		System.out.print(black + " | ");

	}

	public void añadirEquipos() {

		listaEquipos.add(new Equipo("Barcelona          ", 0, 0, 0, 0, 0, 0, 0));
		listaEquipos.add(new Equipo("Real Madrid        ", 0, 0, 0, 0, 0, 0, 0));
		listaEquipos.add(new Equipo("Real Sociedad      ", 0, 0, 0, 0, 0, 0, 0));
		listaEquipos.add(new Equipo("Atletico de Madrid ", 0, 0, 0, 0, 0, 0, 0));
		listaEquipos.add(new Equipo("Rayo Vallecano     ", 0, 0, 0, 0, 0, 0, 0));
		listaEquipos.add(new Equipo("Villareal          ", 0, 0, 0, 0, 0, 0, 0));
		listaEquipos.add(new Equipo("Betis              ", 0, 0, 0, 0, 0, 0, 0));
		listaEquipos.add(new Equipo("Athletic Club      ", 0, 0, 0, 0, 0, 0, 0));
		listaEquipos.add(new Equipo("Osasuna            ", 0, 0, 0, 0, 0, 0, 0));
		listaEquipos.add(new Equipo("Mallorca           ", 0, 0, 0, 0, 0, 0, 0));
		listaEquipos.add(new Equipo("Girona             ", 0, 0, 0, 0, 0, 0, 0));
		listaEquipos.add(new Equipo("Celta              ", 0, 0, 0, 0, 0, 0, 0));
		listaEquipos.add(new Equipo("Valladolid         ", 0, 0, 0, 0, 0, 0, 0));
		listaEquipos.add(new Equipo("Almeria            ", 0, 0, 0, 0, 0, 0, 0));
		listaEquipos.add(new Equipo("Cadiz              ", 0, 0, 0, 0, 0, 0, 0));
		listaEquipos.add(new Equipo("Espanyol           ", 0, 0, 0, 0, 0, 0, 0));
		listaEquipos.add(new Equipo("Sevilla            ", 0, 0, 0, 0, 0, 0, 0));
		listaEquipos.add(new Equipo("Valencia           ", 0, 0, 0, 0, 0, 0, 0));
		listaEquipos.add(new Equipo("Getafe             ", 0, 0, 0, 0, 0, 0, 0));
		listaEquipos.add(new Equipo("Elche              ", 0, 0, 0, 0, 0, 0, 0));

	}

	public void añadirJugadores() {
		listaEquipos.get(0).addJugadores(new Jugador("Ter Stegen", 1, "Portero"));
		listaEquipos.get(0).addJugadores(new Jugador("Kounde", 23, "Defensa"));
		listaEquipos.get(0).addJugadores(new Jugador("Araujo", 4, "Defensa"));
		listaEquipos.get(0).addJugadores(new Jugador("Christensen", 15, "Defensa"));
		listaEquipos.get(0).addJugadores(new Jugador("Balde", 28, "Defensa"));
		listaEquipos.get(0).addJugadores(new Jugador("Busquets", 5, "Mediocampista"));
		listaEquipos.get(0).addJugadores(new Jugador("Gavi", 6, "Mediocampista"));
		listaEquipos.get(0).addJugadores(new Jugador("Pedri", 8, "Mediocampista"));
		listaEquipos.get(0).addJugadores(new Jugador("Raphinha", 22, "Delantero"));
		listaEquipos.get(0).addJugadores(new Jugador("Lewandowski", 9, "Delantero"));
		listaEquipos.get(0).addJugadores(new Jugador("Ansu", 10, "Delantero"));

		listaEquipos.get(1).addJugadores(new Jugador("Coutois", 1, "Portero"));
		listaEquipos.get(1).addJugadores(new Jugador("Carvajal", 2, "Defensa"));
		listaEquipos.get(1).addJugadores(new Jugador("Militao", 3, "Defensa"));
		listaEquipos.get(1).addJugadores(new Jugador("Rudiger", 22, "Defensa"));
		listaEquipos.get(1).addJugadores(new Jugador("Mendy", 23, "Defensa"));
		listaEquipos.get(1).addJugadores(new Jugador("Tchouameni", 18, "Mediocampista"));
		listaEquipos.get(1).addJugadores(new Jugador("Kroos", 8, "Mediocampista"));
		listaEquipos.get(1).addJugadores(new Jugador("Modric", 10, "Mediocampista"));
		listaEquipos.get(1).addJugadores(new Jugador("Rodrygo", 21, "Delantero"));
		listaEquipos.get(1).addJugadores(new Jugador("Benzema", 9, "Delantero"));
		listaEquipos.get(1).addJugadores(new Jugador("Vinicius", 20, "Delantero"));

		listaEquipos.get(2).addJugadores(new Jugador("Remiro", 1, "Portero"));
		listaEquipos.get(2).addJugadores(new Jugador("Gorosabel", 18, "Defensa"));
		listaEquipos.get(2).addJugadores(new Jugador("Le Normand", 24, "Defensa"));
		listaEquipos.get(2).addJugadores(new Jugador("Elustondo", 6, "Defensa"));
		listaEquipos.get(2).addJugadores(new Jugador("Muñoz", 12, "Defensa"));
		listaEquipos.get(2).addJugadores(new Jugador("Zubimendi", 3, "Mediocampista"));
		listaEquipos.get(2).addJugadores(new Jugador("Merino", 8, "Mediocampista"));
		listaEquipos.get(2).addJugadores(new Jugador("David Silva", 21, "Mediocampista"));
		listaEquipos.get(2).addJugadores(new Jugador("Oyarzabal", 10, "Delantero"));
		listaEquipos.get(2).addJugadores(new Jugador("Sorloth", 9, "Delantero"));
		listaEquipos.get(2).addJugadores(new Jugador("Kubo", 14, "Delantero"));

		listaEquipos.get(3).addJugadores(new Jugador("Oblak", 13, "Portero"));
		listaEquipos.get(3).addJugadores(new Jugador("Molina", 16, "Defensa"));
		listaEquipos.get(3).addJugadores(new Jugador("Gimenez", 2, "Defensa"));
		listaEquipos.get(3).addJugadores(new Jugador("Savic", 15, "Defensa"));
		listaEquipos.get(3).addJugadores(new Jugador("Reinildo", 23, "Defensa"));
		listaEquipos.get(3).addJugadores(new Jugador("De Paul", 5, "Mediocampista"));
		listaEquipos.get(3).addJugadores(new Jugador("Llorente", 14, "Mediocampista"));
		listaEquipos.get(3).addJugadores(new Jugador("Koke", 6, "Mediocampista"));
		listaEquipos.get(3).addJugadores(new Jugador("Correa", 10, "Delantero"));
		listaEquipos.get(3).addJugadores(new Jugador("Griezmann", 8, "Delantero"));
		listaEquipos.get(3).addJugadores(new Jugador("Memphis", 9, "Delantero"));

		listaEquipos.get(4).addJugadores(new Jugador("Dimitrievski", 1, "Portero"));
		listaEquipos.get(4).addJugadores(new Jugador("Balliu", 20, "Defensa"));
		listaEquipos.get(4).addJugadores(new Jugador("Catena", 5, "Defensa"));
		listaEquipos.get(4).addJugadores(new Jugador("Lejeune", 19, "Defensa"));
		listaEquipos.get(4).addJugadores(new Jugador("Garcia", 3, "Defensa"));
		listaEquipos.get(4).addJugadores(new Jugador("Ciss", 21, "Mediocampista"));
		listaEquipos.get(4).addJugadores(new Jugador("Comesaña", 6, "Mediocampista"));
		listaEquipos.get(4).addJugadores(new Jugador("Trejo", 8, "Mediocampista"));
		listaEquipos.get(4).addJugadores(new Jugador("Isi", 7, "Delantero"));
		listaEquipos.get(4).addJugadores(new Jugador("Falcao", 9, "Delantero"));
		listaEquipos.get(4).addJugadores(new Jugador("Alvaro", 18, "Delantero"));

		listaEquipos.get(5).addJugadores(new Jugador("Reina", 1, "Portero"));
		listaEquipos.get(5).addJugadores(new Jugador("Foyth", 8, "Defensa"));
		listaEquipos.get(5).addJugadores(new Jugador("Torres", 4, "Defensa"));
		listaEquipos.get(5).addJugadores(new Jugador("Albiol", 3, "Defensa"));
		listaEquipos.get(5).addJugadores(new Jugador("Mojica", 12, "Defensa"));
		listaEquipos.get(5).addJugadores(new Jugador("Capoue", 6, "Mediocampista"));
		listaEquipos.get(5).addJugadores(new Jugador("Parejo", 10, "Mediocampista"));
		listaEquipos.get(5).addJugadores(new Jugador("Lo Celso", 17, "Mediocampista"));
		listaEquipos.get(5).addJugadores(new Jugador("Chukwueze", 11, "Delantero"));
		listaEquipos.get(5).addJugadores(new Jugador("Moreno", 7, "Delantero"));
		listaEquipos.get(5).addJugadores(new Jugador("Pino", 21, "Delantero"));

		listaEquipos.get(6).addJugadores(new Jugador("Bravo", 1, "Portero"));
		listaEquipos.get(6).addJugadores(new Jugador("Sabaly", 23, "Defensa"));
		listaEquipos.get(6).addJugadores(new Jugador("Felipe", 19, "Defensa"));
		listaEquipos.get(6).addJugadores(new Jugador("Pezzella", 16, "Defensa"));
		listaEquipos.get(6).addJugadores(new Jugador("Abner", 20, "Defensa"));
		listaEquipos.get(6).addJugadores(new Jugador("Canales", 10, "Mediocampista"));
		listaEquipos.get(6).addJugadores(new Jugador("Carvalho", 14, "Mediocampista"));
		listaEquipos.get(6).addJugadores(new Jugador("Guardado", 18, "Mediocampista"));
		listaEquipos.get(6).addJugadores(new Jugador("Fekir", 8, "Delantero"));
		listaEquipos.get(6).addJugadores(new Jugador("Iglesias", 9, "Delantero"));
		listaEquipos.get(6).addJugadores(new Jugador("Joaquin", 17, "Delantero"));

		listaEquipos.get(7).addJugadores(new Jugador("Simon", 1, "Portero"));
		listaEquipos.get(7).addJugadores(new Jugador("De Marcos", 18, "Defensa"));
		listaEquipos.get(7).addJugadores(new Jugador("Iñigo", 4, "Defensa"));
		listaEquipos.get(7).addJugadores(new Jugador("Yeray", 5, "Defensa"));
		listaEquipos.get(7).addJugadores(new Jugador("Yuri", 17, "Defensa"));
		listaEquipos.get(7).addJugadores(new Jugador("Vencedor", 16, "Mediocampista"));
		listaEquipos.get(7).addJugadores(new Jugador("Herrera", 23, "Mediocampista"));
		listaEquipos.get(7).addJugadores(new Jugador("Sancet", 8, "Mediocampista"));
		listaEquipos.get(7).addJugadores(new Jugador("Nico Williams", 11, "Delantero"));
		listaEquipos.get(7).addJugadores(new Jugador("Iñaki Williams", 9, "Delantero"));
		listaEquipos.get(7).addJugadores(new Jugador("Berenguer", 7, "Delantero"));

		listaEquipos.get(8).addJugadores(new Jugador("Herrera", 1, "Portero"));
		listaEquipos.get(8).addJugadores(new Jugador("Peña", 15, "Defensa"));
		listaEquipos.get(8).addJugadores(new Jugador("Garcia", 5, "Defensa"));
		listaEquipos.get(8).addJugadores(new Jugador("Garcia", 4, "Defensa"));
		listaEquipos.get(8).addJugadores(new Jugador("Sanchez", 20, "Defensa"));
		listaEquipos.get(8).addJugadores(new Jugador("Torro", 6, "Mediocampista"));
		listaEquipos.get(8).addJugadores(new Jugador("Moncayola", 7, "Mediocampista"));
		listaEquipos.get(8).addJugadores(new Jugador("Oroz", 22, "Mediocampista"));
		listaEquipos.get(8).addJugadores(new Jugador("Abde", 12, "Delantero"));
		listaEquipos.get(8).addJugadores(new Jugador("Avila", 9, "Delantero"));
		listaEquipos.get(8).addJugadores(new Jugador("Budimir", 17, "Delantero"));

		listaEquipos.get(9).addJugadores(new Jugador("Rajkovic", 1, "Portero"));
		listaEquipos.get(9).addJugadores(new Jugador("Maffeo", 15, "Defensa"));
		listaEquipos.get(9).addJugadores(new Jugador("Valjent", 24, "Defensa"));
		listaEquipos.get(9).addJugadores(new Jugador("Raillo", 21, "Defensa"));
		listaEquipos.get(9).addJugadores(new Jugador("Augustinsson", 3, "Defensa"));
		listaEquipos.get(9).addJugadores(new Jugador("Battaglia", 16, "Mediocampista"));
		listaEquipos.get(9).addJugadores(new Jugador("Grenier", 8, "Mediocampista"));
		listaEquipos.get(9).addJugadores(new Jugador("Lee", 19, "Mediocampista"));
		listaEquipos.get(9).addJugadores(new Jugador("Ndiaye", 23, "Delantero"));
		listaEquipos.get(9).addJugadores(new Jugador("Muriqi", 7, "Delantero"));
		listaEquipos.get(9).addJugadores(new Jugador("Prats", 9, "Delantero"));

		listaEquipos.get(10).addJugadores(new Jugador("Gazzaniga", 13, "Portero"));
		listaEquipos.get(10).addJugadores(new Jugador("Arnau", 4, "Defensa"));
		listaEquipos.get(10).addJugadores(new Jugador("Lopez", 5, "Defensa"));
		listaEquipos.get(10).addJugadores(new Jugador("Espinosa", 2, "Defensa"));
		listaEquipos.get(10).addJugadores(new Jugador("Gutierrez", 3, "Defensa"));
		listaEquipos.get(10).addJugadores(new Jugador("Romeu", 18, "Mediocampista"));
		listaEquipos.get(10).addJugadores(new Jugador("Herrera", 21, "Mediocampista"));
		listaEquipos.get(10).addJugadores(new Jugador("Garcia", 14, "Mediocampista"));
		listaEquipos.get(10).addJugadores(new Jugador("Tsygankov", 8, "Delantero"));
		listaEquipos.get(10).addJugadores(new Jugador("Villa", 12, "Delantero"));
		listaEquipos.get(10).addJugadores(new Jugador("Stuani", 7, "Delantero"));

		listaEquipos.get(11).addJugadores(new Jugador("Marchesin", 1, "Portero"));
		listaEquipos.get(11).addJugadores(new Jugador("Mallo", 2, "Defensa"));
		listaEquipos.get(11).addJugadores(new Jugador("Aidoo", 15, "Defensa"));
		listaEquipos.get(11).addJugadores(new Jugador("Nuñez", 4, "Defensa"));
		listaEquipos.get(11).addJugadores(new Jugador("Galan", 17, "Defensa"));
		listaEquipos.get(11).addJugadores(new Jugador("Tapia", 14, "Mediocampista"));
		listaEquipos.get(11).addJugadores(new Jugador("Beltran", 8, "Mediocampista"));
		listaEquipos.get(11).addJugadores(new Jugador("Veiga", 24, "Mediocampista"));
		listaEquipos.get(11).addJugadores(new Jugador("Perez", 7, "Delantero"));
		listaEquipos.get(11).addJugadores(new Jugador("Aspas", 10, "Delantero"));
		listaEquipos.get(11).addJugadores(new Jugador("Cervi", 11, "Delantero"));

		listaEquipos.get(12).addJugadores(new Jugador("Masip", 1, "Portero"));
		listaEquipos.get(12).addJugadores(new Jugador("Fresneda", 27, "Defensa"));
		listaEquipos.get(12).addJugadores(new Jugador("Sanchez", 5, "Defensa"));
		listaEquipos.get(12).addJugadores(new Jugador("El Yamiq", 15, "Defensa"));
		listaEquipos.get(12).addJugadores(new Jugador("Olaza", 12, "Defensa"));
		listaEquipos.get(12).addJugadores(new Jugador("Monchu", 8, "Mediocampista"));
		listaEquipos.get(12).addJugadores(new Jugador("Aguado", 6, "Mediocampista"));
		listaEquipos.get(12).addJugadores(new Jugador("Amallah", 9, "Mediocampista"));
		listaEquipos.get(12).addJugadores(new Jugador("Plata", 11, "Delantero"));
		listaEquipos.get(12).addJugadores(new Jugador("Larin", 25, "Delantero"));
		listaEquipos.get(12).addJugadores(new Jugador("Plano", 10, "Delantero"));

		listaEquipos.get(13).addJugadores(new Jugador("Mariño", 1, "Portero"));
		listaEquipos.get(13).addJugadores(new Jugador("Pozo", 17, "Defensa"));
		listaEquipos.get(13).addJugadores(new Jugador("Kaiky", 2, "Defensa"));
		listaEquipos.get(13).addJugadores(new Jugador("Ely", 19, "Defensa"));
		listaEquipos.get(13).addJugadores(new Jugador("Akieme", 15, "Defensa"));
		listaEquipos.get(13).addJugadores(new Jugador("Eguaras", 4, "Mediocampista"));
		listaEquipos.get(13).addJugadores(new Jugador("Robertone", 5, "Mediocampista"));
		listaEquipos.get(13).addJugadores(new Jugador("Melero", 3, "Mediocampista"));
		listaEquipos.get(13).addJugadores(new Jugador("Ramazani", 7, "Delantero"));
		listaEquipos.get(13).addJugadores(new Jugador("Suarez", 16, "Delantero"));
		listaEquipos.get(13).addJugadores(new Jugador("Embarba", 10, "Delantero"));

		listaEquipos.get(14).addJugadores(new Jugador("Ledesma", 1, "Portero"));
		listaEquipos.get(14).addJugadores(new Jugador("Carcelen", 20, "Defensa"));
		listaEquipos.get(14).addJugadores(new Jugador("Chust", 32, "Defensa"));
		listaEquipos.get(14).addJugadores(new Jugador("Fali", 3, "Defensa"));
		listaEquipos.get(14).addJugadores(new Jugador("Espino", 22, "Defensa"));
		listaEquipos.get(14).addJugadores(new Jugador("Mari", 6, "Mediocampista"));
		listaEquipos.get(14).addJugadores(new Jugador("Alcaraz", 4, "Mediocampista"));
		listaEquipos.get(14).addJugadores(new Jugador("Fernandez", 8, "Mediocampista"));
		listaEquipos.get(14).addJugadores(new Jugador("Bongonda", 10, "Delantero"));
		listaEquipos.get(14).addJugadores(new Jugador("Lozano", 9, "Delantero"));
		listaEquipos.get(14).addJugadores(new Jugador("Alejo", 11, "Delantero"));

		listaEquipos.get(15).addJugadores(new Jugador("Pacheco", 13, "Portero"));
		listaEquipos.get(15).addJugadores(new Jugador("Gil", 2, "Defensa"));
		listaEquipos.get(15).addJugadores(new Jugador("Montes", 23, "Defensa"));
		listaEquipos.get(15).addJugadores(new Jugador("Calero", 5, "Defensa"));
		listaEquipos.get(15).addJugadores(new Jugador("Pedrosa", 3, "Defensa"));
		listaEquipos.get(15).addJugadores(new Jugador("Souza", 12, "Mediocampista"));
		listaEquipos.get(15).addJugadores(new Jugador("Darder", 10, "Mediocampista"));
		listaEquipos.get(15).addJugadores(new Jugador("Exposito", 20, "Mediocampista"));
		listaEquipos.get(15).addJugadores(new Jugador("Puado", 7, "Delantero"));
		listaEquipos.get(15).addJugadores(new Jugador("Joselu", 9, "Delantero"));
		listaEquipos.get(15).addJugadores(new Jugador("Melamed", 21, "Delantero"));

		listaEquipos.get(16).addJugadores(new Jugador("Bono", 13, "Portero"));
		listaEquipos.get(16).addJugadores(new Jugador("Navas", 16, "Defensa"));
		listaEquipos.get(16).addJugadores(new Jugador("Rekik", 4, "Defensa"));
		listaEquipos.get(16).addJugadores(new Jugador("Nianzou", 14, "Defensa"));
		listaEquipos.get(16).addJugadores(new Jugador("Acuña", 19, "Defensa"));
		listaEquipos.get(16).addJugadores(new Jugador("Fernando", 20, "Mediocampista"));
		listaEquipos.get(16).addJugadores(new Jugador("Jordan", 8, "Mediocampista"));
		listaEquipos.get(16).addJugadores(new Jugador("Rakitic", 10, "Mediocampista"));
		listaEquipos.get(16).addJugadores(new Jugador("Corona", 9, "Delantero"));
		listaEquipos.get(16).addJugadores(new Jugador("En Nesyri", 15, "Delantero"));
		listaEquipos.get(16).addJugadores(new Jugador("Gomez", 24, "Delantero"));

		listaEquipos.get(17).addJugadores(new Jugador("Mamardashvili", 25, "Portero"));
		listaEquipos.get(17).addJugadores(new Jugador("Correia", 2, "Defensa"));
		listaEquipos.get(17).addJugadores(new Jugador("Paulista", 5, "Defensa"));
		listaEquipos.get(17).addJugadores(new Jugador("Diakhaby", 12, "Defensa"));
		listaEquipos.get(17).addJugadores(new Jugador("Gaya", 14, "Defensa"));
		listaEquipos.get(17).addJugadores(new Jugador("Guillamon", 6, "Mediocampista"));
		listaEquipos.get(17).addJugadores(new Jugador("Musah", 4, "Mediocampista"));
		listaEquipos.get(17).addJugadores(new Jugador("Nico", 17, "Mediocampista"));
		listaEquipos.get(17).addJugadores(new Jugador("Lino", 16, "Delantero"));
		listaEquipos.get(17).addJugadores(new Jugador("Cavani", 7, "Delantero"));
		listaEquipos.get(17).addJugadores(new Jugador("Castillejo", 11, "Delantero"));

		listaEquipos.get(18).addJugadores(new Jugador("Soria", 13, "Portero"));
		listaEquipos.get(18).addJugadores(new Jugador("Suarez", 22, "Defensa"));
		listaEquipos.get(18).addJugadores(new Jugador("Djene", 2, "Defensa"));
		listaEquipos.get(18).addJugadores(new Jugador("Alderete", 15, "Defensa"));
		listaEquipos.get(18).addJugadores(new Jugador("Angileri", 3, "Defensa"));
		listaEquipos.get(18).addJugadores(new Jugador("Algobia", 16, "Mediocampista"));
		listaEquipos.get(18).addJugadores(new Jugador("Aleña", 11, "Mediocampista"));
		listaEquipos.get(18).addJugadores(new Jugador("Milla", 5, "Mediocampista"));
		listaEquipos.get(18).addJugadores(new Jugador("Portu", 9, "Delantero"));
		listaEquipos.get(18).addJugadores(new Jugador("Unal", 10, "Delantero"));
		listaEquipos.get(18).addJugadores(new Jugador("Munir", 17, "Delantero"));

		listaEquipos.get(19).addJugadores(new Jugador("Badia", 13, "Portero"));
		listaEquipos.get(19).addJugadores(new Jugador("Lirola", 24, "Defensa"));
		listaEquipos.get(19).addJugadores(new Jugador("Magllan", 7, "Defensa"));
		listaEquipos.get(19).addJugadores(new Jugador("Verdu", 5, "Defensa"));
		listaEquipos.get(19).addJugadores(new Jugador("Clerc", 23, "Defensa"));
		listaEquipos.get(19).addJugadores(new Jugador("Mascarell", 21, "Mediocampista"));
		listaEquipos.get(19).addJugadores(new Jugador("Guti", 8, "Mediocampista"));
		listaEquipos.get(19).addJugadores(new Jugador("Gumbau", 20, "Mediocampista"));
		listaEquipos.get(19).addJugadores(new Jugador("Morente", 11, "Delantero"));
		listaEquipos.get(19).addJugadores(new Jugador("Boye", 9, "Delantero"));
		listaEquipos.get(19).addJugadores(new Jugador("Collado", 15, "Delantero"));
	}
}
