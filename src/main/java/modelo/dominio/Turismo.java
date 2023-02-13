package modelo.dominio;

public class Turismo {
	private static final String ER_MARCA = "(Seat|Land Rover|KIA|Rolls-Royce|SsangYong)";
	private static final String ER_MATRICULA = "[0-9]{4}[BCDFGHJKLMNÑPQRSTVWXYZ]{3}";
	private String marca;
	private String modelo;
	private int cilindrada;
	private String matricula;

	public Turismo(String marca, String modelo, int cilindrada, String matricula) throws IllegalArgumentException {
		setMarca(marca);
		setModelo(modelo);
		setCilindrada(cilindrada);
		setMatricula(matricula);
	}

	public Turismo(Turismo turismo) {
		if (turismo == null) {
			throw new NullPointerException("ERROR: No es posible copiar un turismo nulo.");
		}
		{
			this.marca = turismo.marca;
			this.modelo = turismo.modelo;
			this.cilindrada = turismo.cilindrada;
			this.matricula = turismo.matricula;
		}
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) throws IllegalArgumentException {
		if (marca == null) {
			throw new NullPointerException("ERROR: la marca no puede ser nula.");
		}

	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) throws IllegalArgumentException {
		if (modelo != null && !modelo.isBlank()) {
			this.modelo = modelo;
		}
		{
			throw new IllegalArgumentException("Modelo no puede estar en blanco");
		}
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) throws IllegalArgumentException {
		if (cilindrada >= 0 && cilindrada <= 5000) {
			this.cilindrada = cilindrada;
		}
		{
			throw new IllegalArgumentException("Cilindrada no es correcta");
		}
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) throws IllegalArgumentException {
		if (matricula.matches(ER_MATRICULA)) {
			this.matricula = matricula;
		}
		throw new IllegalArgumentException("Matrícula no tiene un formato válido");
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Turismo turismo = (Turismo) o;

		return matricula.equals(turismo.matricula);
	}

	public int hashCode() {
		return matricula.hashCode();
	}

	public String toString() {
		return "Turismo{" + "marca='" + marca + '\'' + ", modelo='" + modelo + '\'' + ", cilindrada=" + cilindrada
				+ ", matricula='" + matricula + '\'' + '}';
	}

	public static Turismo getTurismoConMatricula(String matricula) {
		return new Turismo ("Seat","León", 90, matricula);
	}

	public int getPrecioDiario() {
		return 0;
	}
}