package punto1.modelo;

import java.util.ArrayList;

public class Estudiante extends Persona {

    private ArrayList<Asignatura> asignaturas;

    public Estudiante(String nombre, String identificacion) {
        super(nombre, identificacion);
        this.asignaturas = new ArrayList<>();
    }

    public void agregarAsignatura(Asignatura asignatura) {
        asignaturas.add(asignatura);
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }
}