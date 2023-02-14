package modelo.dominio;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Alquiler {
	private static DateTimeFormatter FORMATO_FECHA;
	private Cliente cliente;
	private Turismo turismo;
	private Date fechaAlquiler;
	private Date fechaDevolucion;

	public Alquiler(Cliente cliente, Turismo turismo, Date fechaAlquiler) {
		setCliente(cliente);
		setTurismo(turismo);
		setFechaAlquiler(fechaAlquiler);
	}

	public Alquiler(Alquiler alquiler) {
		this(new Cliente(alquiler.getCliente()), new Turismo(alquiler.getTurismo()), alquiler.getFechaAlquiler());
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		if (cliente == null) {
			throw new NullPointerException("ERROR:el cliente no puede ser nulo");
		}
		this.cliente = cliente;
	}

	public Turismo getTurismo() {
		return turismo;
	}

	public void setTurismo(Turismo turismo) {
		this.turismo = turismo;
	}

	public Date getFechaAlquiler() {
		return fechaAlquiler;
	}

	public void setFechaAlquiler(Date fechaAlquiler) {
		Date hoy = new Date();
		if (fechaAlquiler.after(hoy)) {
			throw new IllegalArgumentException("La fecha de alquiler no puede ser posterior a hoy");
		}
		this.fechaAlquiler = fechaAlquiler;
	}

	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(Date fechaDevolucion) {
		Date hoy = new Date();
		if (fechaDevolucion.before(fechaAlquiler) || fechaDevolucion.after(hoy)) {
			throw new IllegalArgumentException("La fecha de devolución no es válida");
		}
		this.fechaDevolucion = fechaDevolucion;
	}

	public void devolver(Date fechaDevolucion) {
		setFechaDevolucion(fechaDevolucion);
	}

	public double getPrecio() {
		long diff = fechaDevolucion.getTime() - fechaAlquiler.getTime();
		int dias = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		return dias * turismo.getPrecioDiario();

	}

	public int hashCode() {
		return Objects.hash(cliente, fechaAlquiler, fechaDevolucion, turismo);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alquiler other = (Alquiler) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(fechaAlquiler, other.fechaAlquiler)
				&& Objects.equals(fechaDevolucion, other.fechaDevolucion) && Objects.equals(turismo, other.turismo);
	
	}
	public String toString() {
		return "Alquiler [cliente=" + cliente + ", turismo=" + turismo + ", fechaAlquiler=" + fechaAlquiler
				+ ", fechaDevolucion=" + fechaDevolucion + ", getCliente()=" + getCliente() + ", getTurismo()="
				+ getTurismo() + ", getFechaAlquiler()=" + getFechaAlquiler() + ", getFechaDevolucion()="
				+ getFechaDevolucion() + ", getPrecio()=" + getPrecio() + ", hashCode()=" + hashCode() + ", getClass()="
				+ getClass() + ", toString()=" + super.toString() + "]";
	}

}
