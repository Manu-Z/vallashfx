package co.edu.uniquindio.vallashfx.vallashapp.Factory.Servicios;

import co.edu.uniquindio.vallashfx.vallashapp.Mapping.dto.CitaDto;

import java.util.List;

public interface IModelFactoryService {
    List<CitaDto> obtenerCitass();

    boolean crearCita(CitaDto citaDto);

    boolean eliminarCita(String id);

    boolean actualizarCita(String idActual, CitaDto citaDto);
}
