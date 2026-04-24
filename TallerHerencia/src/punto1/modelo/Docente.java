package punto1.modelo;

public class Docente extends Persona {

    private String especialidad;

    public Docente(String nombre, String identificacion, String especialidad) {
        super(nombre, identificacion);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}