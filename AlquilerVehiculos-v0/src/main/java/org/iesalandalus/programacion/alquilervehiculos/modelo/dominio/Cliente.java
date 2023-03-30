package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;

public class Cliente {
	
	private static final String ER_NOMBRE = "\"[A-ZÁÉÍÓÚÑ][a-záéíóúñ] \s [A-ZÁÉÍÓÚÑ][a-záéíóúñ]*\"";
	private static final String ER_DNI = "\\d{8}[A-Z]$";
	private static final  String ER_TELEFONO = "^[6,7,9]\\d{8}$"; 
	
	
	private String nombre;
	private String dni;
	private String telefono;
	
	public Cliente (String nombre, String dni, String telefono) {
		setNombre(nombre);
		setDni(dni);
		setTelefono(telefono);
	}
	
	public Cliente (Cliente cliente) {
		this.nombre = cliente.nombre;
		this.dni = cliente.dni;
		this.telefono = cliente.telefono;
	}
	
	//GETTERS Y SETTERS
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null) {
			throw new NullPointerException("ERROR: El nombre no puede ser nulo");
		}
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	private void setDni(String dni) {
		if (dni == null) {
			throw new NullPointerException("ERROR: El DNI no puede ser nulo");
		}
		this.dni = dni;
	}
	
	private boolean comprobarLetraDNI(String dni) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int numeroDNI = Integer.parseInt(dni.substring(0, 8));
        char letraDNI = dni.charAt(8);
        int posicionLetra = numeroDNI%23;
        if(letras.charAt(posicionLetra) == letraDNI) {
        	return true;
        }
        return false;  
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		if(telefono == null) {
			throw new NullPointerException("ERROR: El telefono no puede ser nulo");
		}
		this.telefono = telefono;
	}

	public static Cliente getClienteConDni(String dni) {
		return new Cliente ("Bob Esponja", dni, "617889628");
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni, nombre, telefono);
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
		return Objects.equals(dni, other.dni) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(telefono, other.telefono);
	}

	@Override
	public String toString() {
		return String.format("Cliente [nombre=%s, dni=%s, telefono=%s]", nombre, dni, telefono);
	}
	
}