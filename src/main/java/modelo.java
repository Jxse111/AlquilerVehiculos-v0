import java.util.ArrayList;
import java.util.List;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

import modelo.dominio.Alquiler;
import modelo.dominio.Cliente;

public class modelo {
	private List<Cliente> listaClientes;
    private List<Turismo> listaTurismos;
    private List<Alquiler> listaAlquileres;
    private NegocioCliente negocioCliente;
    private NegocioTurismo negocioTurismo;
    private NegocioAlquiler negocioAlquiler;

    public void Modelo() {
        this.listaClientes = new ArrayList<>();
        this.listaTurismos = new ArrayList<>();
        this.listaAlquileres = new ArrayList<>();
        this.negocioCliente = new NegocioCliente();
        this.negocioTurismo = new NegocioTurismo();
        this.negocioAlquiler = new NegocioAlquiler();
    }

public void comenzar() {
	
}
public void terminar() {	
	
}
public void insertar (Cliente cliente) {

}
}
