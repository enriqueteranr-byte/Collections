package punto1.modelo;
import java.util.ArrayList;

public class Asignatura {

    private String nombre;
    private Docente docente;
    private ArrayList<Tema> temas;
    private ArrayList<Nota> notas;

    public Asignatura(String nombre, Docente docente) {
        this.nombre = nombre;
        this.docente = docente;
        this.temas = new ArrayList<>();
        this.notas = new ArrayList<>();
    }

    public void agregarTema(Tema tema) {
        temas.add(tema);
    }

    public void agregarNota(Nota nota) {
        notas.add(nota);
    }

    public double calcularPromedio() {
        double suma = 0;

        for (Nota n : notas) {
            suma += n.getValor();
        }

        return notas.size() > 0 ? suma / notas.size() : 0;
    }

    public String getNombre() {
        return nombre;
    }
    public Docente getDocente() {
        return docente;
    }
    public ArrayList<Tema> getTemas() {
        return temas;
    }
    public ArrayList<Nota> getNotas() {
        return notas;
    }
}