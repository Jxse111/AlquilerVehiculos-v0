package modelo.dominio;
import java.util.regex.Pattern;

public class Turismo {
    private static final String PATTERN_MARCA = "(Seat|Land Rover|KIA|Rolls-Royce|SsangYong)";
    private static final String PATTERN_MATRICULA = "[0-9]{4}[A-Z]{3}";
    private static final Pattern patternMarca = Pattern.compile(PATTERN_MARCA);
    private static final Pattern patternMatricula = Pattern.compile(PATTERN_MATRICULA);
    private static final int MIN_CILINDRADA = 0;
    private static final int MAX_CILINDRADA = 5000;
    private static Turismo turismo1;
    private static Turismo turismo2;
    private static Turismo turismos;
    private String marca;
    private String modelo;
    private int cilindrada;
    private String matricula;

    public Turismo(String marca, String modelo, int cilindrada, String matricula) throws IllegalArgumentException {
        setMarca(marca);
        setModelo(modelo);
        setCilindrada(cilindrada);
        setMatricula(matricula);
    }

    public Turismo(Turismo turismo) {
        this.marca = turismo.marca;
        this.modelo = turismo.modelo;
        this.cilindrada = turismo.cilindrada;
        this.matricula = turismo.matricula;
    }

    public static Turismo getTurismo(String matricula) {
        if (patternMatricula.matcher(matricula).matches()) {
            return new Turismo("", "", 0, matricula);
        } else {
            return null;
        }
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) throws IllegalArgumentException {
        if (patternMarca.matcher(marca).matches()) {
            this.marca = marca;
        } else {
            throw new IllegalArgumentException("Marca no válida");
        }
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) throws IllegalArgumentException {
        if (modelo != null && !modelo.isEmpty()) {
            this.modelo = modelo;
        } else {
            throw new IllegalArgumentException("Modelo no puede estar en blanco");
        }
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) throws IllegalArgumentException {
        if (cilindrada > MIN_CILINDRADA && cilindrada <= MAX_CILINDRADA) {
            this.cilindrada = cilindrada;
        } else {
            throw new IllegalArgumentException("Cilindrada no válida");
        }
    }


    public String getMatricula()

    {
    	return matricula;
    	}
    public void setMatricula(String matricula) throws IllegalArgumentException {
        if (patternMatricula.matcher(matricula).matches()) {
            this.matricula = matricula;
        } else {
            throw new IllegalArgumentException("Matrícula no válida");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Turismo turismo = (Turismo) o;

        return matricula.equals(turismo.matricula);
    }

    @Override
    public int hashCode() {
        return matricula.hashCode();
    }

    @Override
    public String toString() {
        return "Turismo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", cilindrada=" + cilindrada +
                ", matricula='" + matricula + '\'' +
                '}';
    }
