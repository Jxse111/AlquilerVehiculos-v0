package modelo.negocio;

import java.util.ArrayList;
import java.util.List;
import modelo.dominio.Alquiler;

public class Alquileres {
	private List<Alquiler> alquileres;

	public Alquileres() {
		this.alquileres = new ArrayList<>();

	}

	public List<Alquiler> get() {
		return new ArrayList<>(this.alquileres);
	}

	public List<Alquiler> get(Clientes cliente) {
		List<Alquiler> alquileresCliente = new ArrayList<>();
		for (Alquiler alquiler : this.alquileres) {
			if (alquiler.getCliente().equals(cliente)) {
				alquileresCliente.add(alquiler);
			}
		}
		return alquileresCliente;
	}

	public List<Alquiler> get(Turismos turismo) {
		List<Alquiler> alquileresTurismo = new ArrayList<>();
		for (Alquiler alquiler : this.alquileres) {
			if (alquiler.getTurismo().equals(turismo)) {
				alquileresTurismo.add(alquiler);
			}
		}
		return alquileresTurismo;
	}

	public int getCantidad() {
		return this.alquileres.size();

	}

	public void comprobarAlquiler(Alquiler alquiler) throws AlquilerException {
		for (Alquiler a : this.alquileres) {
			if (a.getCliente().equals(alquiler.getCliente()) && a.getFechaDevolucion() == null)
				throw new AlquilerException("El cliente ya tiene un alquiler sin devolver");
		}
		for (Alquiler a : this.alquileres) {
			if (a.getTurismo().equals(alquiler.getTurismo()) && a.getFechaDevolucion() == null) {
				throw new AlquilerException("El turismo ya tiene un alquiler sin devolver");
			}
			for (Alquiler a : this.alquileres) {
				if (a.getCliente().equals(alquiler.getCliente()) || a.getTurismo().equals(alquiler.getTurismo())) {
					if (a.getFechaDevolucion() != null && a.getFechaDevolucion().isAfter(alquiler.getFechaAlquiler())) {
						throw new AlquilerException(
								"Ya hay un alquiler devuelto con fecha posterior a la fecha de alquiler");
					}

				}
			}
		}
	}

	public void insertar(Alquiler alquiler) throws AlquilerException {
		if (alquiler != null) {
			comprobarAlquiler(alquiler);
			this.alquileres.add(alquiler);
		}
	}

	public void devolver(Alquiler alquiler) throws AlquilerException {
		Alquiler alquilerEncontrado = buscar(alquiler);
		if (alquilerEncontrado != null) {
			alquilerEncontrado.devolver(alquiler.getFechaDevolucion());
		}
	}

	{
		throw new AlquilerException("El alquiler no se encuentra en la lista");
	}

	public Alquiler buscar(Alquiler alquiler) {
		for (Alquiler a : this.alquileres) {
			if (a.equals(alquiler)) {
				return a;
			}
		}
		return null;
	}

	public void borrar(Alquiler alquiler) throws AlquilerException {
		if (this.alquileres.remove(alquiler)) {
			return;
		}
		{
			throw new AlquilerException("El alquiler no se encuentra en la lista");
		}
	}
}
