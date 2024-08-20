package co.edu.uniquindio.vallashfx.vallashapp.Controller;

import co.edu.uniquindio.vallashfx.vallashapp.Factory.ModelFactory;
import co.edu.uniquindio.vallashfx.vallashapp.Mapping.dto.Citadto;

import java.util.List;

public class CitaController {
    ModelFactory modelFactory;

    public CitaController(){
        modelFactory = ModelFactory.getInstance();
    }
    public List<Citadto> obtenerCitas() {
        return modelFactory.obtenerCitas();
    }

    public boolean crearCita(Citadto citadto) {
        return modelFactory.crearCita(citadto);
    }
}
