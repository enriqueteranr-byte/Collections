package punto1.servicio;

import punto1.modelo.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaAcademico {

    private ArrayList<Estudiante> estudiantes;
    private Scanner sc;

    public SistemaAcademico() {
        estudiantes = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    public void iniciarSistema() {

        System.out.print("¿Cuántos estudiantes desea registrar?: ");
        int cantidad = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < cantidad; i++) {
            registrarEstudiante();
        }

        mostrarEstudiantes();
    }

    private void registrarEstudiante() {

        System.out.print("\nNombre del estudiante: ");
        String nombre = sc.nextLine();

        System.out.print("Identificación: ");
        String id = sc.nextLine();

        Estudiante estudiante = new Estudiante(nombre, id);

        System.out.print("¿Cuántas asignaturas?: ");
        int numAsig = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numAsig; i++) {
            Asignatura asignatura = crearAsignatura();
            estudiante.agregarAsignatura(asignatura);
        }

        estudiantes.add(estudiante);
    }

    private Asignatura crearAsignatura() {

        System.out.print("\nNombre de la asignatura: ");
        String nombreAsig = sc.nextLine();

        System.out.print("Nombre del docente: ");
        String nombreDoc = sc.nextLine();

        Docente docente = new Docente(nombreDoc, "N/A", "N/A");

        Asignatura asignatura = new Asignatura(nombreAsig, docente);

        // TEMAS
        System.out.print("¿Cuántos temas?: ");
        int numTemas = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numTemas; i++) {
            System.out.print("Tema: ");
            asignatura.agregarTema(new Tema(sc.nextLine()));
        }

        // NOTAS CON DESCRIPCIÓN 🔥
        System.out.print("¿Cuántas notas?: ");
        int numNotas = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numNotas; i++) {

            System.out.print("Tipo de nota: ");
            String tipo = sc.nextLine();

            System.out.print("Valor de la nota: ");
            double valor = sc.nextDouble();
            sc.nextLine();

            asignatura.agregarNota(new Nota(tipo, valor));
        }

        return asignatura;
    }

    public void mostrarEstudiantes() {

        for (Estudiante e : estudiantes) {

            System.out.println("\n-------------------");
            System.out.println("Estudiante: " + e.getNombre());

            for (Asignatura a : e.getAsignaturas()) {

                System.out.println("\nAsignatura: " + a.getNombre());
                System.out.println("Docente: " + a.getDocente().getNombre());

                System.out.println("Temas:");
                for (Tema t : a.getTemas()) {
                    System.out.println("- " + t.getNombre());
                }

                System.out.println("Notas:");
                for (Nota n : a.getNotas()) {
                    System.out.println(n); // usa toString 🔥
                }

                System.out.println("Promedio: " + a.calcularPromedio());
                System.out.println("-------------------");
            }
        }
    }
}