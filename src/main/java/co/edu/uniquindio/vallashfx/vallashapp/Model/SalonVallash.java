package co.edu.uniquindio.vallashfx.vallashapp.Model;

import co.edu.uniquindio.vallashfx.vallashapp.Exceptions.CitaException;
import co.edu.uniquindio.vallashfx.vallashapp.Model.Service.ISalonVallashService;

import java.util.ArrayList;

public class SalonVallash implements ISalonVallashService {
    private static final long serialVersionUID = 1L;

    ArrayList<Cliente> listaClientes = new ArrayList<>();
    ArrayList<Tratamiento> listaTratamientos = new ArrayList<>();
    ArrayList<Tecnico> listaTecnicos = new ArrayList<>();
    ArrayList<Cita> listaCitas = new ArrayList<>();

    public SalonVallash(){

    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Tratamiento> getListaTratamientos() {
        return listaTratamientos;
    }

    public void setListaTratamientos(ArrayList<Tratamiento> listaTratamientos) {
        this.listaTratamientos = listaTratamientos;
    }

    public ArrayList<Tecnico> getListaTecnicos() {
        return listaTecnicos;
    }

    public void setListaTecnicos(ArrayList<Tecnico> listaTecnicos) {
        this.listaTecnicos = listaTecnicos;
    }

    public ArrayList<Cita> getListaCitas() {
        return listaCitas;
    }

    public void setListaCitas(ArrayList<Cita> listaCitas) {
        this.listaCitas = listaCitas;
    }


    @Override
    public Cita crearNuevaCita(String id, String fecha, String hora, Cliente clienteAsociado, Tratamiento tratamientoAsociado, Tecnico tecnicoAsociado) throws CitaException {
        Cita nuevaCita = null;
        boolean citaExiste = verificarCitaExistente(id);
        if(citaExiste){
            throw new CitaException("La cita con id: "+id+" ya existe");
        }else{
            nuevaCita = new Cita();
            nuevaCita.setId(id);
            nuevaCita.setFecha(fecha);
            nuevaCita.setHora(hora);
            nuevaCita.setClienteAsociado(clienteAsociado);
            nuevaCita.setTecnicoAsociado(tecnicoAsociado);
            nuevaCita.setTratamientoAsociado(tratamientoAsociado);
            getListaCitas().add(nuevaCita);
        }
        return nuevaCita;
    }

    public void crearCita(Cita nuevaCita) throws CitaException{
        getListaCitas().add(nuevaCita);
    }

    @Override
    public boolean actualizarCita(String idActual, Cita cita) throws CitaException {
        Cita citaActual = obtenerCita(idActual);
        if(citaActual == null)
            throw new CitaException("La cita a actualizar no existe");
        else{
            citaActual.setId(cita.getId());
            citaActual.setFecha(cita.getFecha());
            citaActual.setHora(cita.getHora());
            citaActual.setClienteAsociado(cita.getClienteAsociado());
            citaActual.setTecnicoAsociado(cita.getTecnicoAsociado());
            citaActual.setTratamientoAsociado(cita.getTratamientoAsociado());
            return true;
        }
    }

    @Override
    public Boolean eliminarCita(String id) throws CitaException {
        Cita cita = null;
        boolean flagExiste = false;
        cita = obtenerCita(id);
        if(cita == null)
            throw new CitaException("La cita a eliminar no existe");
        else{
            getListaCitas().remove(cita);
            flagExiste = true;
        }
        return flagExiste;
    }
    public boolean verificarCitaExistente(String id) throws CitaException{
        if(citaExistente(id)){
            throw new CitaException("La cita con id: "+id+" ya existe");
        }else{
            return false;
        }
    }

    @Override
    public Cita obtenerCita(String id) {
        Cita citaEncontrada = null;
        for (Cita cita : getListaCitas()) {
            if(cita.getId().equalsIgnoreCase(id)){
                citaEncontrada = cita;
                break;
            }
        }
        return citaEncontrada;
    }

    @Override
    public ArrayList<Cita> obtenerCitas() {
        // TODO Auto-generated method stub
        return getListaCitas();
    }

    public boolean citaExistente(String id) {
        boolean citaEncontrada = false;
        for (Cita cita : getListaCitas()) {
            if(cita.getId().equalsIgnoreCase(id)){
                citaEncontrada = true;
                break;
            }
        }
        return citaEncontrada;
    }
}
