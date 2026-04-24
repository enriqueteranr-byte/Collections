package punto2.servicio;

import punto2.modelo.Medicamento;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FarmaciaService {

    private Set<Medicamento> medicamentos = new HashSet<>();
    private Scanner scanner = new Scanner(System.in);

    public void iniciar() {

        int opcion;

        do {
            System.out.println("\n---------- FARMACIA ----------");
            System.out.println("1- Agregar medicamento");
            System.out.println("2- Mostrar medicamentos");
            System.out.println("3- Verificar medicamento");
            System.out.println("4- Eliminar medicamento");
            System.out.println("5- Total medicamentos");
            System.out.println("6- Salir");
            System.out.print("Opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarMenu();
                    break;
                case 2:
                    mostrarMedicamentos();
                    break;
                case 3:
                    verificarMenu();
                    break;
                case 4:
                    eliminarMenu();
                    break;
                case 5:
                    System.out.println("Total: " + medicamentos.size());
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 6);
    }

    private void agregarMenu() {
        System.out.print("Nombre del medicamento: ");
        String nombre = scanner.nextLine().trim();

        if (medicamentos.add(new Medicamento(nombre))) {
            System.out.println("Agregado.");
        } else {
            System.out.println("Ya existe.");
        }
    }

    private void verificarMenu() {
        System.out.print("Nombre a buscar: ");
        String nombre = scanner.nextLine().trim();

        boolean existe = medicamentos.stream()
                .anyMatch(m -> m.getNombre().equalsIgnoreCase(nombre));

        System.out.println(existe ? "Disponible." : "No disponible.");
    }

    private void eliminarMenu() {
        System.out.print("Nombre a eliminar: ");
        String nombre = scanner.nextLine().trim();

        boolean eliminado = medicamentos.removeIf(m ->
                m.getNombre().equalsIgnoreCase(nombre));

        System.out.println(eliminado ? "Eliminado." : "No encontrado.");
    }

    public void mostrarMedicamentos() {
        if (medicamentos.isEmpty()) {
            System.out.println("No hay medicamentos.");
        } else {
            medicamentos.forEach(System.out::println);
        }
    }
}