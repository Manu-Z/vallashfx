package co.edu.uniquindio.vallashfx.vallashapp.Model;

import java.util.ArrayList;
import java.util.Date;

public class Cita {

    private String id;
    private String fecha;
    private String hora;
    private Cliente clienteAsociado;
    private Tratamiento tratamientoAsociado;
    private  Tecnico tecnicoAsociado;

    public Cita() {
    }

    public Cita(String id, String fecha, String hora, Cliente clienteAsociado, Tratamiento tratamientoAsociado) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.clienteAsociado = clienteAsociado;
        this.tratamientoAsociado = tratamientoAsociado;

    }

    public String getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public Cliente getClienteAsociado() {
        return clienteAsociado;
    }

    public Tratamiento getTratamientoAsociado() {
        return tratamientoAsociado;
    }

    public Tecnico getTecnicoAsociado() {
        return tecnicoAsociado;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setClienteAsociado(Cliente clienteAsociado) {
        this.clienteAsociado = clienteAsociado;
    }

    public void setTratamientoAsociado(Tratamiento tratamientoAsociado) {
        this.tratamientoAsociado = tratamientoAsociado;
    }

    public void setTecnicoAsociado(Tecnico tecnicoAsociado) {
        this.tecnicoAsociado = tecnicoAsociado;
    }
}
