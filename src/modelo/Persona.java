package modelo;

public abstract class Persona {
    protected String nombre, cedula;
    protected int edad;

    //metodo constructor
    public Persona(String nombre, String cedula, int edad) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
    }

    public abstract void mostrarDatos();

    public String getNombre() {return nombre;}
    public String getCedula() {return cedula;}
    public int getEdad() {return edad;}

}
