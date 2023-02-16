package modelo;
import java.util.ArrayList;
import java.util.List;

import modelo.dominio.Cliente;
public class Clientes {
	
	    private List<Cliente> clientes;

	    public Clientes() {
	        clientes = new ArrayList<>();
	    }

	    public List<Cliente> get() {
	        return new ArrayList<>(clientes);
	    }

	    public int getCantidad() {
	        return clientes.size();
	    }

	    public void insertar(Cliente cliente) {
	        if (cliente != null && !clientes.contains(cliente)) {
	            clientes.add(cliente);
	        }
	    }

	    public Cliente buscar(Cliente cliente) {
	        int index = clientes.indexOf(cliente);
	        if (index != -1) {
	            return clientes.get(index);
	        }
	        return null;
	    }

	    public void borrar(Cliente cliente) throws Exception {
	        if (clientes.contains(cliente)) {
	            clientes.remove(cliente);
	        } else {
	            throw new Exception("El cliente no se encuentra en la lista.");
	        }
	    }

	    public void modificar(Cliente cliente, String nuevoNombre, String nuevoTelefono) throws Exception {
	        if (clientes.contains(cliente)) {
	            if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
	                cliente.setNombre(nuevoNombre);
	            }
	            if (nuevoTelefono != null && !nuevoTelefono.trim().isEmpty()) {
	                cliente.setTelefono(nuevoTelefono);
	            }
	        } else {
	            throw new Exception("El cliente no se encuentra en la lista.");
	        }
	    }
	}
