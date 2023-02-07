package modelo.dominio;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Alquiler {
    private static final String DATE_FORMAT = "dd/MM/yyyy";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

    private Cliente cliente;
    private Turismo turismo;
    private Date fechaAlquiler;
    private Date fechaDevolucion;

    public Alquiler(Cliente cliente, Turismo turismo, Date fechaAlquiler, Date fechaDevolucion) {
        setCliente(cliente);
        setTurismo(turismo);
        setFechaAlquiler(fechaAlquiler);
        setFechaDevolucion(fechaDevolucion);
    }

    public Alquiler(Alquiler alquiler) {
        this(new Cliente(alquiler.getCliente()), new Turismo(alquiler.getTurismo()), alquiler.getFechaAlquiler(), alquiler.getFechaDevolucion());
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
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
    
}

   
