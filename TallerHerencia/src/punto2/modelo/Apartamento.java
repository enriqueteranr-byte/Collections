package punto2.modelo;
public class Apartamento extends Propiedad {
    public Apartamento(double precio) {
        super(precio);
    }

    public double calcularComision() {
        return precio * 0.04;
    }
}