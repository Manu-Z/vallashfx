package co.edu.uniquindio.vallashfx.vallashapp.Controller;

import co.edu.uniquindio.vallashfx.vallashapp.Controller.Service.ICitaControllerService;
import co.edu.uniquindio.vallashfx.vallashapp.Factory.ModelFactory;
import co.edu.uniquindio.vallashfx.vallashapp.Mapping.dto.CitaDto;

import java.util.List;

public class CitaController implements ICitaControllerService {
    ModelFactory modelFactory;

    public CitaController(){
        modelFactory = ModelFactory.getInstance();
    }
    public List<CitaDto> obtenerCita() {
        return modelFactory.obtenerCitass();
    }

    @Override
    public boolean crearCita(CitaDto citadto) {
        return modelFactory.crearCita(citadto);
    }

    @Override
    public boolean eliminarCita(String id){
        return modelFactory.eliminarCita(id);
    }

    public boolean actualizarCita(String idActual, CitaDto citaDto){
        return modelFactory.actualizarCita(idActual, citaDto);
    }
}
