package main;
import modelo.Curso;
import modelo.Entrenador;
import modelo.Participante;
import modelo.Persona;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    static ArrayList<Persona> personas = new ArrayList<>();
    static ArrayList<Participante> inscritosNatacion = new ArrayList<>();
    static ArrayList<Participante> inscritosFutbol = new ArrayList<>();
    static ArrayList<Curso> cursos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        inicializarDatos();

        boolean salir = false;

        do {
            System.out.println("----------- MENÚ PRINCIPAL  -----------");
            System.out.println("1. Registrar Participante " +
                    "\n2. Ver Cursos Disponibles por Edad " +
                    "\n3. Inscribir en Curso " +
                    "\n4. Ver Inscritos en Curso " +
                    "\n5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1 -> registrarParticipante();
                case 2 -> verCursosPorEdad();
                case 3 -> inscribirCurso();
                case 4 -> verInscritos();
                case 5 -> {
                    System.out.println("Saliendo...");
                    salir = true;
                }
                default -> System.out.println("Opcion no valida");
            }
        }
        while (!salir);
    }

    static void inicializarDatos(){
        // Crear entrenadores
        Entrenador entrenadorNatacion = new Entrenador("Laura Gómez", "1001", 35, "Natación");
        Entrenador entrenadorFutbol = new Entrenador("Carlos Díaz", "1002", 42,"Fútbol");
        // Crear participantes
        Participante p1 = new Participante("Ana Torres", "2001", 12);
        Participante p2 = new Participante("Luis Pérez", "2002", 14);
        Participante p3 = new Participante("Sofía Ramírez", "2003", 10);
        Participante p4 = new Participante("Juan López", "2004", 15);
        Participante p5 = new Participante("María Fernanda", "2005", 9);

        // Curso de Natacion
        inscritosNatacion.add(p1);
        inscritosNatacion.add(p3);
        // Curso de Fútbol
        inscritosFutbol.add(p2);
        inscritosFutbol.add(p4);

        Curso cursoNatacion = new Curso("Natación Básica","Natación","Lunes 10:00",10,15, entrenadorNatacion, inscritosNatacion);
        Curso cursoFutbol = new Curso("Fútbol Básico","Fútbol", "Lunes 10:00",10,15, entrenadorFutbol, inscritosNatacion);

        cursos.add(cursoNatacion);
        cursos.add(cursoFutbol);
    }

    static void registrarParticipante(){
        System.out.println("---------- REGISTRAR PARTICIPANTE ----------");
        System.out.println("Ingrese su nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese su cédula: ");
        String cedula = sc.nextLine();
        System.out.println("Ingrese su edad: ");
        int edad = sc.nextInt();
        sc.nextLine();
        personas.add(new Participante(nombre,cedula,edad));
        System.out.println("PARTICIPANTE REGISTRADO CON ÉXITO.");
    }

    static void inscribirCurso() {
        for (int i=0; i<cursos.size(); i++) {
            System.out.println((i+1)+"."+cursos.get(i).getNombre());
        }
        System.out.println("Ingrese la opcion de su curso: ");
        int opcion = sc.nextInt() - 1;
        sc.nextLine();

        if (opcion >= 0 && opcion < cursos.size()) {
            System.out.println("Ingrese los datos del participante:");
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Cédula: ");
            String cedula = sc.nextLine();
            System.out.print("Edad: ");
            int edad = sc.nextInt();
            sc.nextLine();

            Participante participante=new Participante(nombre,cedula,edad);
            Curso cursoSeleccionado = cursos.get(opcion);
            cursoSeleccionado.getInscritos().add(participante);
            System.out.println("Participante inscrito correctamente en el curso " + cursoSeleccionado.getNombre());
        } else {
            System.out.println("Opción inválida.");
        }
    }

    static void verInscritos(){
        System.out.println("Seleccione un curso para ver sus inscritos:");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println((i + 1) + ". " + cursos.get(i).getNombre() + " (" + cursos.get(i).getDisciplina() + ")");
        }

        System.out.print("Ingrese el número del curso: ");
        int opcionCurso = sc.nextInt() - 1;
        sc.nextLine();

        if (opcionCurso >= 0 && opcionCurso < cursos.size()) {
            cursos.get(opcionCurso).mostrarInscritos();
        } else {
            System.out.println("Opción inválida. Intente de nuevo.");
        }
    }

    static void verCursosPorEdad() {
        System.out.println("---------- VER CURSOS DISPONIBLES POR EDAD ----------");
        System.out.print("Ingrese la edad del participante: ");
        int edad = sc.nextInt();
        sc.nextLine();

        boolean hayCursos = false;

        for (Curso curso : cursos) {
            if (edad >= curso.getEdadMin() && edad <= curso.getEdadMax()) {
                System.out.println("- " + curso.getNombre() + " (" + curso.getDisciplina() + "), Edad recomendada: "
                        + curso.getEdadMin() + " a " + curso.getEdadMax());
                hayCursos = true;
            }
        }

        if (!hayCursos) {
            System.out.println("No hay cursos disponibles para la edad ingresada.");
        }
    }


}