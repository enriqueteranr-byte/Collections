package punto2.servicio;

import punto2.modelo.*;
import java.util.Scanner;

public class SistemaVentas {

    private Scanner sc;
    private Vendedor vendedor;

    private double salarioBase = 1300000; // salario en Colombia

    public SistemaVentas() {
        sc = new Scanner(System.in);
    }

    public void iniciar() {
        registrarVendedor();
        registrarVentas();
        mostrarResultadoFinal();
    }

    private void registrarVendedor() {
        System.out.println("Ingrese nombre del vendedor:");
        String nombre = sc.nextLine();

        vendedor = new Vendedor(nombre);
    }

    private void registrarVentas() {

        System.out.println("¿Cuántas ventas realizó?");
        int cantidad = sc.nextInt();

        for (int i = 0; i < cantidad; i++) {

            System.out.println("\nVenta #" + (i + 1));

            Propiedad p = crearPropiedad();
            vendedor.agregarVenta(p);
        }
    }

    private Propiedad crearPropiedad() {

        System.out.println("Tipo de propiedad:");
        System.out.println("1. Casa");
        System.out.println("2. Apartamento");
        System.out.println("3. Lote");

        int tipo = sc.nextInt();

        System.out.println("Ingrese precio de la propiedad:");
        double precio = sc.nextDouble();

        switch (tipo) {
            case 1:
                return new Casa(precio);
            case 2:
                return new Apartamento(precio);
            case 3:
                return new Lote(precio);
            default:
                System.out.println("Opción inválida, se registrará como lote");
                return new Lote(precio);
        }
    }

    private void mostrarResultadoFinal() {

        double comision = vendedor.calcularComision();
        double totalPagar = salarioBase + comision;

        System.out.println("\n----- Facturacion Total -----");
        System.out.println("Vendedor: " + vendedor.getNombre());
        System.out.println("Salario base: $" + salarioBase);
        System.out.println("Comisión total: $" + comision);
        System.out.println("TOTAL A PAGAR: $" + totalPagar);
    }
}