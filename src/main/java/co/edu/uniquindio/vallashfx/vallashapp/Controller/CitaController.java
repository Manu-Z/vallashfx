package co.edu.uniquindio.vallashfx.vallashapp.Controller;

import co.edu.uniquindio.vallashfx.vallashapp.Factory.ModelFactory;
import co.edu.uniquindio.vallashfx.vallashapp.Mapping.dto.CitaDto;

import java.util.List;

public class CitaController {
    ModelFactory modelFactory;

    public CitaController(){
        modelFactory = ModelFactory.getInstance();
    }
    public List<CitaDto> obtenerCitas() {
        return modelFactory.obtenerCitass();
    }

    public boolean crearCita(CitaDto citadto) {
        return modelFactory.crearCita(citadto);
    }
}
