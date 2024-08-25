package co.edu.uniquindio.vallashfx.vallashapp.Controller.Servicios;

import co.edu.uniquindio.vallashfx.vallashapp.Mapping.dto.CitaDto;

import java.util.List;

public interface ICitaControllerService {

    List<CitaDto> obtenerCitas();

    boolean crearCita(CitaDto citaDto);

    boolean eliminarCita(String id);

    boolean actualizarCita(String idActual, CitaDto citaDto);

}
