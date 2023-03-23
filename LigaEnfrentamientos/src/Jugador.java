
public class Jugador {
	private String nombre;
	private int dorsal;
	private String posicion;

	public Jugador() {
		super();
	}

	public Jugador(String nombre, int dorsal, String posicion) {
		super();
		this.nombre = nombre;
		this.dorsal = dorsal;
		this.posicion = posicion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	@Override
	public String toString() {
		return "Jugadores [nombre=" + nombre + ", dorsal=" + dorsal + ", posicion=" + posicion + "]";
	}
}
