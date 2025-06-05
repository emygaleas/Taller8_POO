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

        int salir = 1;

        do {
            System.out.println("----------- MENÚ PRINCIPAL  -----------");
            System.out.println("1. Registrar Participante \n2. Ver Cursos Disponibles por Edad \n3. Inscribir en Curso \n4. Ver Inscritos en Curso \n5. \n6. Salir");
            System.out.println("Seleccione una opción: ");
            int opcion = sc.nextInt();

            switch (opcion){
            }
        }while (salir != 6);


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
        System.out.printf("---------- REGISTRAR PARTICIPANTE ----------");
        System.out.printf("Ingrese su nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese su cédula: ");
        String cedula = sc.nextLine();
        System.out.printf("Ingrese su edad: ");
        int edad = sc.nextInt();
        personas.add(new Participante(nombre,cedula,edad));
        System.out.println("PARTICIPANTE REGISTRADO CON ÉXITO.");
    }
}