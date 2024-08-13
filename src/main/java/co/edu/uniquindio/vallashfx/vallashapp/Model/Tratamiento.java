package co.edu.uniquindio.vallashfx.vallashapp.Model;

public class Tratamiento {

    private String nombre;
    private String descripcion;
    private String precio;
    private String duracion;

    public Tratamiento(String nombre, String descripcion, String precio, String duracion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
}
