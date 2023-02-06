package modelo.dominio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente {
    private static final Pattern NOMBRE_PATTERN = Pattern.compile("[A-Z][a-z]+");
    private static final Pattern DNI_PATTERN = Pattern.compile("[0-9]{8}[A-Z]");
    private static final Pattern TELEFONO_PATTERN = Pattern.compile("[0-9]{9}");

    private String nombre;
    private String dni;
    private String telefono;

    public Cliente(String nombre, String dni, String telefono) {
        setNombre(nombre);
        setDni(dni);
        setTelefono(telefono);
    }

    private void setTelefono(String telefono2) {
		// TODO Auto-generated method stub
		
	}

	private void setDni(String dni2) {
		// TODO Auto-generated method stub
		
	}

	public Cliente(Cliente otroCliente) {
        this(otroCliente.nombre, otroCliente.dni, otroCliente.telefono);
    }

    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        Matcher matcher = NOMBRE_PATTERN.matcher(nombre);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Nombre no válido");
        }
        this.nombre = nombre;
    }
}
