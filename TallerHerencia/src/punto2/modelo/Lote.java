package punto2.modelo;
public class Lote extends Propiedad {
    public Lote(double precio) {
        super(precio);
    }

    public double calcularComision() {
        return precio * 0.06;
    }
}