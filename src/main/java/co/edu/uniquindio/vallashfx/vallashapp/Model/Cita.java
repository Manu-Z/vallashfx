package co.edu.uniquindio.vallashfx.vallashapp.Model;

import java.util.ArrayList;
import java.util.Date;

public class Cita {

    private String id;
    private Date fecha;
    private Date hora;
    private Cliente clienteAsociado;
    private Tratamiento tratamientoAsociado;

    public Cita(String id, Date fecha, Date hora, Cliente clienteAsociado, Tratamiento tratamientoAsociado) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.clienteAsociado = clienteAsociado;
        this.tratamientoAsociado = tratamientoAsociado;

    }

    public String getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public Date getHora() {
        return hora;
    }

    public Cliente getClienteAsociado() {
        return clienteAsociado;
    }

    public Tratamiento getTratamientoAsociado() {
        return tratamientoAsociado;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public void setClienteAsociado(Cliente clienteAsociado) {
        this.clienteAsociado = clienteAsociado;
    }

    public void setTratamientoAsociado(Tratamiento tratamientoAsociado) {
        this.tratamientoAsociado = tratamientoAsociado;
    }
}
