package punto2.modelo;

import java.util.ArrayList;

public class Vendedor extends Empleado implements Comisionable {

    private ArrayList<Propiedad> ventas;

    public Vendedor(String nombre) {
        super(nombre);
        ventas = new ArrayList<>();
    }

    public void agregarVenta(Propiedad p) {
        ventas.add(p);
    }

    @Override
    public double calcularComision() {
        double total = 0;

        for (Propiedad p : ventas) {

            if (p instanceof Casa) {
                total += ((Casa) p).calcularComision();
            }
            else if (p instanceof Apartamento) {
                total += ((Apartamento) p).calcularComision();
            }
            else if (p instanceof Lote) {
                total += ((Lote) p).calcularComision();
            }
        }

        return total;
    }
}