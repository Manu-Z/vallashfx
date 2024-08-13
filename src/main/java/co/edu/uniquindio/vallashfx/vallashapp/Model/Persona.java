package co.edu.uniquindio.vallashfx.vallashapp.Model;

public class Persona {

    private String id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String telefono;
    private int edad;

    public Persona(String id, String cedula, String nombre, String apellido, String telefono, int edad) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.edad = edad;
    }

    public String getId() {
        return id;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getEdad() {
        return edad;
    }
}
