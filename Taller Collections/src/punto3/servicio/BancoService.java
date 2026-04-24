package punto3.servicio;

import punto3.modelo.Cuenta;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BancoService {

    private Map<String, Cuenta> cuentas = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void iniciar() {

        int opcion;

        do {
            System.out.println("\n===== BANCO =====");
            System.out.println("1.- Crear cuenta");
            System.out.println("2.- Consultar saldo");
            System.out.println("3.- Depositar");
            System.out.println("4.- Retirar");
            System.out.println("5.- Salir");
            System.out.print("Opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> crear();
                case 2 -> consultar();
                case 3 -> depositar();
                case 4 -> retirar();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }

        } while (opcion != 5);
    }

    private void crear() {
        System.out.print("Número: ");
        String numero = scanner.nextLine().trim();

        System.out.print("Saldo inicial: ");
        double saldo = scanner.nextDouble();
        scanner.nextLine();

        if (cuentas.containsKey(numero)) {
            System.out.println("Ya existe.");
        } else {
            cuentas.put(numero, new Cuenta(numero, saldo));
            System.out.println("Cuenta creada.");
        }
    }

    private void consultar() {
        System.out.print("Número: ");
        String numero = scanner.nextLine().trim();

        Cuenta c = cuentas.get(numero);
        System.out.println(c != null ? c : "No encontrada.");
    }

    private void depositar() {
        System.out.print("Número: ");
        String numero = scanner.nextLine().trim();

        System.out.print("Monto: ");
        double monto = scanner.nextDouble();
        scanner.nextLine();

        Cuenta c = cuentas.get(numero);

        if (c != null) {
            c.depositar(monto);
            System.out.println("Depósito OK.");
        } else {
            System.out.println("No existe.");
        }
    }

    private void retirar() {
        System.out.print("Número: ");
        String numero = scanner.nextLine().trim();

        System.out.print("Monto: ");
        double monto = scanner.nextDouble();
        scanner.nextLine();

        Cuenta c = cuentas.get(numero);

        if (c != null && c.retirar(monto)) {
            System.out.println("Retiro OK.");
        } else {
            System.out.println("Error.");
        }
    }
}