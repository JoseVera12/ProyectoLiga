
public class Jornada {
	private int numeroJornada;

	public Jornada() {
		super();
	}

	public Jornada(int numeroJornada) {
		super();
		this.numeroJornada = numeroJornada;
	}

	public int getNumeroJornada() {
		return numeroJornada;
	}

	public void setNumeroJornada(int numeroJornada) {
		this.numeroJornada = numeroJornada;
	}

	@Override
	public String toString() {
		return "Jornada [numeroJornada=" + numeroJornada + "]";
	}

}
