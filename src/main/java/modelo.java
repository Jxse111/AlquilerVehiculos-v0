public class Modelo {
    private List<Cliente> listaClientes;
    private List<Turismo> listaTurismos;
    private List<Alquiler> listaAlquileres;
    private NegocioCliente negocioCliente;
    private NegocioTurismo negocioTurismo;
    private NegocioAlquiler negocioAlquiler;

    public Modelo() {
        this.listaClientes = new ArrayList<>();
        this.listaTurismos = new ArrayList<>();
        this.listaAlquileres = new ArrayList<>();
        this.negocioCliente = new NegocioCliente();
        this.negocioTurismo = new NegocioTurismo();
        this.negocioAlquiler = new NegocioAlquiler();
    }

    public void comenzar() {
        // Crear las instancias necesarias para la aplicación
    }

    public void terminar() {
        // Cerrar los recursos y mostrar un mensaje informativo
    }

    public void insertarCliente(Cliente cliente) {
        // Insertar un nuevo cliente en la lista de clientes
    }

    public void insertarTurismo(Turismo turismo) {
        // Insertar un nuevo turismo en la lista de turismos
    }

    public void insertarAlquiler(Alquiler alquiler) {
        // Buscar el cliente y el turismo correspondientes y utilizarlos para crear el nuevo alquiler
    }

    public Cliente buscarCliente(int idCliente) {
        // Buscar un cliente por su ID y devolver una nueva instancia del objeto si existe
    }

    public Turismo buscarTurismo(int idTurismo) {
        // Buscar un turismo por su ID y devolver una nueva instancia del objeto si existe
    }

    public Alquiler buscarAlquiler(int idAlquiler) {
        // Buscar un alquiler por su ID y devolver una nueva instancia del objeto si existe
    }

    public void modificarCliente(Cliente cliente) {
        // Invocar al método homólogo en la clase de negocio para modificar el cliente
    }

    public void modificarTurismo(Turismo turismo) {
        // Invocar al método homólogo en la clase de negocio para modificar el turismo
    }

    public void modificarAlquiler(Alquiler alquiler) {
        // Invocar al método homólogo en la clase de negocio para modificar el alquiler
    }

    public boolean devolverAlquiler(int idAlquiler) {
        // Realizar la devolución del alquiler correspondiente si es posible
    }

    public void borrarCliente(int idCliente) {
        // Borrar un cliente y sus alquileres correspondientes en cascada
    }

    public void borrarTurismo(int idTurismo) {
        // Borrar un turismo y sus alquileres correspondientes en cascada
    }

    public List<Cliente> getListaClientes() {
        // Devolver una nueva lista de clientes con nuevas instancias de los objetos
    }

    public List<Turismo> getListaTurismos() {
        // Devolver una nueva lista de turismos con nuevas instancias de los objetos
    }

    public List<Alquiler> getListaAlquileres() {
        // Devolver una nueva lista de alquileres con nuevas instancias de los objetos
    }
}
