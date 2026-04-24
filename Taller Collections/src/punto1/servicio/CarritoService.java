package punto1.servicio;

import punto1.modelo.Producto;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarritoService {

    private List<Producto> carrito = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void iniciar() {

        int opcion;

        do {
            System.out.println("\n -----Carrito----- ");
            System.out.println("1 Agregar producto");
            System.out.println("2 Eliminar producto");
            System.out.println("3 Mostrar carrito");
            System.out.println("4 Total a pagar");
            System.out.println("5 Salir");
            System.out.print("Opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregar();
                    break;
                case 2:
                    eliminar();
                    break;
                case 3:
                    mostrarCarrito();
                    break;
                case 4:
                    System.out.println("Total: $" + calcularTotal());
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 5);
    }

    private void agregar() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();

        carrito.add(new Producto(nombre, precio));
        System.out.println("Agregado.");
    }

    private void eliminar() {
        System.out.print("Nombre a eliminar: ");
        String nombre = scanner.nextLine();

        boolean eliminado = carrito.removeIf(p ->
                p.getNombre().equalsIgnoreCase(nombre));

        System.out.println(eliminado ? "Eliminado." : "No encontrado.");
    }

    public void mostrarCarrito() {
        if (carrito.isEmpty()) {
            System.out.println("Vacío.");
        } else {
            carrito.forEach(System.out::println);
        }
    }

    public double calcularTotal() {
        return carrito.stream()
                .mapToDouble(Producto::getPrecio)
                .sum();
    }
}