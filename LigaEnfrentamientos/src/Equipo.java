import java.util.ArrayList;
import java.util.Scanner;

public class Equipo {
	private String nombre;
	private ArrayList<Jugador> plantilla = new ArrayList<Jugador>();
	private int puntos;
	private int victorias;
	private int derrotas;
	private int empates;
	private int golesafavor;
	private int golesencontra;
	private int dg;

	public Equipo() {
		super();
	}

	public Equipo(String nombre, int puntos, int victorias, int derrotas, int empates, int golesafavor,
			int golesencontra, int dg) {
		super();
		this.nombre = nombre;
		this.puntos = puntos;
		this.victorias = victorias;
		this.derrotas = derrotas;
		this.empates = empates;
		this.golesafavor = golesafavor;
		this.golesencontra = golesencontra;
		this.dg = dg;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Jugador> getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(ArrayList<Jugador> plantilla) {
		this.plantilla = plantilla;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getVictorias() {
		return victorias;
	}

	public void setVictorias(int victorias) {
		this.victorias = victorias;
	}

	public int getDerrotas() {
		return derrotas;
	}

	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}

	public int getEmpates() {
		return empates;
	}

	public void setEmpates(int empates) {
		this.empates = empates;
	}

	public int getGolesafavor() {
		return golesafavor;
	}

	public void setGolesafavor(int golesafavor) {
		this.golesafavor = golesafavor;
	}

	public int getGolesencontra() {
		return golesencontra;
	}

	public void setGolesencontra(int golesencontra) {
		this.golesencontra = golesencontra;
	}

	public int getDg() {
		return dg;
	}

	public void setDg(int dg) {
		this.dg = dg;
	}

	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", plantilla=" + plantilla + ", puntos=" + puntos + ", victorias="
				+ victorias + ", derrotas=" + derrotas + ", empates=" + empates + ", golesafavor=" + golesafavor
				+ ", golesencontra=" + golesencontra + ", dg=" + dg + "]";
	}

	public void addJugadores(Jugador item) {
		plantilla.add(item);
	}

	public void FicharJugador() {
		Scanner lector = new Scanner(System.in);
		String nombrejugador = "";
		String posicionjugador = "";
		int dorsaljugador;

		Jugador miJugador12 = new Jugador();
		System.out.println("A continuación, vas a fichar a un jugador: ");
		System.out.println("¿Cuál es su nombre?");
		nombrejugador = lector.nextLine();
		miJugador12.setNombre(nombrejugador);

		System.out.println("¿Cuál es su dorsal?");
		dorsaljugador = lector.nextInt();
		lector.nextLine();
		miJugador12.setDorsal(dorsaljugador);

		System.out.println("¿Cuál es su posición?");
		posicionjugador = lector.nextLine();
		miJugador12.setPosicion(posicionjugador);
		plantilla.add(miJugador12);

	}

	public void DespedirJugador() {
		String nombrejugadordespedir;
		int posicion = -1;
		boolean encontrado = false;
		int contador = 0;
		int longitud = plantilla.size();

		Scanner lector = new Scanner(System.in);

		System.out.println("A continuación, vas a despedir a un jugador de la plantilla");
		System.out.println("");
		System.out.println("¿Cuál es su nombre?");
		nombrejugadordespedir = lector.nextLine();

		while (contador < longitud && !encontrado) {
			if (nombrejugadordespedir.equals(plantilla.get(contador).getNombre())) {
				encontrado = true;
				posicion = contador;
				plantilla.remove(contador);
			} else {
				contador++;
			}
		}
	}

	public void ModificarJugador() {
		String nombrejugadormodificar;
		String nombremodificado;
		String posicionmodificado;
		int dorsaljugadormodificar;
		int respuesta;
		int posicion = -1;
		boolean encontrado = false;
		int contador = 0;
		int longitud = plantilla.size();

		Scanner lector = new Scanner(System.in);
		System.out.println("Perfecto, ahora vas a modificar un jugador");
		System.out.println("¿Qué vas a modificarle?");
		System.out.println("1 = Su nombre");
		System.out.println("2 = Su dorsal");
		System.out.println("3 = Su posición");
		respuesta = lector.nextInt();
		lector.nextLine();

		switch (respuesta) {
		case 1:
			System.out.println("A continuación, vas a modificar el nombre de un jugador");
			System.out.println("¿Cuál es el nombre del jugador a modificar?");
			nombrejugadormodificar = lector.nextLine();

			while (contador < longitud && !encontrado) {
				if (nombrejugadormodificar.equals(plantilla.get(contador).getNombre())) {
					System.out.println("¿Cuál es el nuevo nombre que quieres ponerle?");
					nombremodificado = lector.nextLine();
					plantilla.get(contador).setNombre(nombremodificado);
					encontrado = true;
					posicion = contador;
				} else {
					contador++;
				}
			}
			break;

		case 2:
			System.out.println("A continuación, vas a modificar el dorsal de un jugador");
			System.out.println("¿Cuál es el nombre del jugador a modificar?");
			nombrejugadormodificar = lector.nextLine();

			while (contador < longitud && !encontrado) {
				if (nombrejugadormodificar.equals(plantilla.get(contador).getNombre())) {
					System.out.println("¿Cuál es el nuevo dorsal que quieres ponerle?");
					dorsaljugadormodificar = lector.nextInt();
					lector.nextLine();
					plantilla.get(contador).setDorsal(dorsaljugadormodificar);
					;
					encontrado = true;
					posicion = contador;
				} else {
					contador++;
				}
			}
			break;

		case 3:
			System.out.println("A continuación, vas a modificar la posición de un jugador");
			System.out.println("¿Cuál es el nombre del jugador a modificar?");
			nombrejugadormodificar = lector.nextLine();

			while (contador < longitud && !encontrado) {
				if (nombrejugadormodificar.equals(plantilla.get(contador).getNombre())) {
					System.out.println("¿Cuál es la nueva posición que quieres ponerle?");
					posicionmodificado = lector.nextLine();
					plantilla.get(contador).setPosicion(posicionmodificado);
					encontrado = true;
					posicion = contador;
				} else {
					contador++;
				}
			}
			break;
		default:

			break;
		}
	}

	public void mostrarPlantilla() {
		Scanner lector = new Scanner(System.in);
		for (Jugador elemento : plantilla) {
			System.out.println(elemento.toString());
		}
	}
}
