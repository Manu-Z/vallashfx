package co.edu.uniquindio.vallashfx.vallashapp.Controller.Service;

import co.edu.uniquindio.vallashfx.vallashapp.Mapping.dto.CitaDto;

import java.util.List;

public interface ICitaControllerService {
    List<CitaDto> obtenerCita();

    boolean crearCita(CitaDto citaDto);

    boolean eliminarCita(String id);

    boolean actualizarCita(String idActual, CitaDto citaDto);
}

