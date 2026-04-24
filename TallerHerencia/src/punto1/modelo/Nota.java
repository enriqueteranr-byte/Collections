package punto1.modelo;

public class Nota {

    private String descripcion;
    private double valor;

    public Nota(String descripcion, double valor) {
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return descripcion + ": " + valor;
    }
}