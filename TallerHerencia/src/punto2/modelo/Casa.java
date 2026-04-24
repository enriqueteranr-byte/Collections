package punto2.modelo;
public class Casa extends Propiedad {
    public Casa(double precio) {
        super(precio);
    }

    public double calcularComision() {
        return precio * 0.05;
    }
}