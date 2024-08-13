package co.edu.uniquindio.vallashfx.vallashapp.Model;

public class Tecnico extends Persona{

    private String horarioTrabajo;
    public Tecnico(String id,
                   String cedula,
                   String nombre,
                   String apellido,
                   String telefono,
                   int edad, String horarioTrabajo) {
        super(id, cedula, nombre, apellido, telefono, edad);
    }

    public String getHorarioTrabajo() {
        return horarioTrabajo;
    }
}

