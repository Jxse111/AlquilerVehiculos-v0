package modelo.dominio;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente {
	private static final Pattern NOMBRE_VALIDO = Pattern.compile("[A-Z][a-z]+");
	private static final Pattern DNI_VALIDO = Pattern.compile("[0-9]{8}[A-Z]");
	private static final Pattern TELEFONO_VALIDO = Pattern.compile("[0-9]{9}");

	private String nombre;
	private String dni;
	private String telefono;

	public Cliente(String NOMBRE_VALIDO, String DNI_VALIDO, String TELEFONO_VALIDO) {
		setNombre(nombre);
		setDni(dni);
		setTelefono(telefono);
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Cliente(Cliente Clienteigual) {
		this(Clienteigual.nombre, Clienteigual.dni, Clienteigual.telefono);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		Matcher matcher = NOMBRE_VALIDO.matcher(nombre);
		if (!matcher.matches()) {
			throw new IllegalArgumentException("Nombre no válido");
		}
		this.nombre = nombre;
	}

	public static Cliente getClienteConDni(String dni) {
		return null;
	}

	@Override
	public int hashCode() {
		return Objects.hash(DNI_VALIDO, NOMBRE_VALIDO, TELEFONO_VALIDO);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(DNI_VALIDO, other.dni) && Objects.equals(NOMBRE_VALIDO, other.nombre)
				&& Objects.equals(TELEFONO_VALIDO, other.telefono);
	}

}
