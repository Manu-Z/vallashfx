package co.edu.uniquindio.vallashfx.vallashapp.Model;

public class Tratamiento {

    private String nombre;
    private String descripción;
    private String precio;
    private String duración;

    public Tratamiento(String nombre, String descripción, String precio, String duración) {
        this.nombre = nombre;
        this.descripción = descripción;
        this.precio = precio;
        this.duración = duración;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripción() {
        return descripción;
    }

    public String getPrecio() {
        return precio;
    }

    public String getDuración() {
        return duración;
    }
}
