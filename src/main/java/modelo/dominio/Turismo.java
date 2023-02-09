package modelo.dominio;

import java.util.regex.Pattern;

public class Turismo {
	private static final String MARCA_VALIDA = "(Seat|Land Rover|KIA|Rolls-Royce|SsangYong)";
	private static final String MATRICULA_VALIDA = "[0-9]{4}[A-Z]{3}";
	private static final Pattern MARCA = Pattern.compile(MARCA_VALIDA);
	private static final Pattern MATRICULA = Pattern.compile(MATRICULA_VALIDA);
	private static final int MIN_CILINDRADA = 0;
	private static final int MAX_CILINDRADA = 5000;
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
		this.marca = turismo.marca;
		this.modelo = turismo.modelo;
		this.cilindrada = turismo.cilindrada;
		this.matricula = turismo.matricula;
	}

	public static Turismo getTurismo(String matricula) {
		if (MATRICULA.matcher(matricula).matches()) {
			return new Turismo("KIA,Rolls-Royce,Land Rover, SSangYong", "", 0 - 5000, matricula = "1111BBB");
		} else {
			return null;
		}
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) throws IllegalArgumentException {
		if (marca == null) {
			throw new NullPointerException("ERROR: la marca no puede ser nula.");
		}else if (marca == MARCA_VALIDA ) {
			throw new IllegalArgumentException("La marca no es válida");
		}
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) throws IllegalArgumentException {
		if (modelo != null && !modelo.isEmpty()) {
			this.modelo = modelo;
		} else {
			throw new IllegalArgumentException("Modelo no puede estar en blanco");
		}
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) throws IllegalArgumentException {
		if (cilindrada > MIN_CILINDRADA && cilindrada <= MAX_CILINDRADA) {
			this.cilindrada = cilindrada;
		} else {
			throw new IllegalArgumentException("Cilindrada no válida");
		}
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) throws IllegalArgumentException {
		if (MATRICULA.matcher(matricula).matches()) {
			this.matricula = matricula;
		} else {
			throw new IllegalArgumentException("Matrícula no válida");
		}
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

	public static Turismo getTurismoConMatricula(String MATRICULA_VALIDA) {
		return null;
	}
}