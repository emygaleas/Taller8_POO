package modelo;
import java.util.*;

public class Curso {
    private String nombre, disciplina, horario;
    private int edadMin, edadMax;
    private Entrenador entrenador;
    private List<Participante>inscritos;

    public Curso(String nombre, String disciplina, String horario, int edadMin, int edadMax, Entrenador entrenador, List<Participante> inscritos) {
        this.nombre = nombre;
        this.disciplina = disciplina;
        this.horario = horario;
        this.edadMin = edadMin;
        this.edadMax = edadMax;
        this.entrenador = entrenador;
        this.inscritos = inscritos;
    }

    public boolean inscribir(Participante p){
        if(inscritos.size()<30 && p.getEdad() >= edadMin && p.getEdad()<=edadMax) {
            inscritos.add(p);
            {
                return true;
            }
        }
        return false;
    }

    public void mostrarInscritos(){
        System.out.println("CURSO: " + nombre + "(" + disciplina + ")" );
        for(Participante p:inscritos){
            p.mostrarDatos();
        }
    }
}
