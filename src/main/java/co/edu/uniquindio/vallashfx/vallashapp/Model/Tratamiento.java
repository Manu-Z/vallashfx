package co.edu.uniquindio.vallashfx.vallashapp.Model;

public class Tratamiento {

    private String nombre;
    private String descripcion;
    private String idTratamiento;
    private double precio;

    public Tratamiento() {
    }

    public Tratamiento(String nombre, String descripcion, String idTratamiento, double precio, String duracion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idTratamiento = idTratamiento;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(String idTratamiento) {
        this.idTratamiento = idTratamiento;
    }
}
