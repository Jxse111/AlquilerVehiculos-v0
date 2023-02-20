package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;

public class Clientes {

	List<Cliente> coleccionClientes;

	public Clientes() {
		coleccionClientes = new ArrayList<>(); // creando la lista
	}

	public List<Cliente> get() {

		return coleccionClientes;
	}

	public int getCantidad() { // tengo que recorrer la lista y incrementar en cada paso

		int cantidadElementos = 0;
		for (Cliente cliente : coleccionClientes) {

			cantidadElementos++;
		}

		return cantidadElementos; // devuelvo el numero de elementos que contiene la lista

	}

	public void insertar(Cliente cliente) throws OperationNotSupportedException {

		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede insertar un cliente nulo.");
		}
		if (!coleccionClientes.contains(cliente)) {
			coleccionClientes.add(cliente);
		}else {
			throw new OperationNotSupportedException("ERROR: Ya existe un cliente con ese DNI.");
		}
	}

	public Cliente buscar(Cliente cliente) {

		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede buscar un cliente nulo.");
		}

		if (!coleccionClientes.contains(cliente)) {
			cliente = null;
		}
		return cliente;

	}

	public void borrar(Cliente cliente) throws OperationNotSupportedException {

		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede borrar un cliente nulo.");
		}

		if (coleccionClientes.contains(cliente)) { // si existe el cliente.

			coleccionClientes.remove(cliente);

		} else { // si el cliente no existe
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
		}

	}

	/*
	 * Crea el método modificar que permitirá cambiar el nombre o el teléfono (si
	 * estos parámetros no son nulos ni blancos) de un cliente existente y si no
	 * lanzará la correspondiente excepción.
	 */

	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {

		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede modificar un cliente nulo.");
		}

		if (telefono != null && !telefono.isBlank()) { // si el telefono no es nulo ni tampoco tiene espacios en blanco

			cliente.setTelefono(telefono);
			

		}
		if (nombre != null && !nombre.isBlank()) { // si el nombre es diferente a nulo y no tiene espacios ya que lo
													// quito con el isBlank

				cliente.setNombre(nombre);
		} 
		
			if (!coleccionClientes.contains(cliente)) {
				throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
			}
		
	}

}
