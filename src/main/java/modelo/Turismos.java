package modelo;

import java.util.ArrayList;
import java.util.List;

import modelo.dominio.Turismo;

public class Turismos {
	private List<Turismo> turismos;

	public Turismos() {
		turismos = new ArrayList<>();
	}

	public List<Turismo> get() {
		return new ArrayList<>(turismos);
	}

	public int getCantidad() {
		return turismos.size();
	}

	public void insertar(Turismo turismo) {
		if (turismo != null && !turismos.contains(turismo)) {
			turismos.add(turismo);
		}
	}

	public Turismo buscar(Turismo turismo) {
		int index = turismos.indexOf(turismo);
		if (index != -1) {
			return turismos.get(index);
		}
		return null;
	}

	public void borrar(Turismo turismo) throws Exception {
		if (turismos.contains(turismo)) {
			turismos.remove(turismo);
		} else {
			throw new Exception("El turismo no se encuentra en la lista.");
		}
	}
}
