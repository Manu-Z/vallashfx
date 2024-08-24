package co.edu.uniquindio.vallashfx.vallashapp.Model.Service;

import co.edu.uniquindio.vallashfx.vallashapp.Exceptions.CitaException;
import co.edu.uniquindio.vallashfx.vallashapp.Model.Cita;
import co.edu.uniquindio.vallashfx.vallashapp.Model.Cliente;
import co.edu.uniquindio.vallashfx.vallashapp.Model.Tecnico;
import co.edu.uniquindio.vallashfx.vallashapp.Model.Tratamiento;

import java.util.ArrayList;

public interface ISalonVallashService {
    public Cita crearNuevaCita(String id, String fecha, String hora, Cliente clienteAsociado, Tratamiento tratamientoAsociado, Tecnico tecnicoAsociado) throws CitaException;
    public Boolean eliminarCita(String id)throws CitaException;
    boolean actualizarCita(String idActual, Cita cita) throws CitaException;
    public boolean  verificarCitaExistente(String id) throws CitaException;
    public Cita obtenerCita(String id);
    public ArrayList<Cita> obtenerCitas();

}
