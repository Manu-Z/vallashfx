package co.edu.uniquindio.vallashfx.vallashapp.Factory;


import co.edu.uniquindio.vallashfx.vallashapp.Mapping.dto.Citadto;
import co.edu.uniquindio.vallashfx.vallashapp.Model.Cita;
import co.edu.uniquindio.vallashfx.vallashapp.Model.SalonVallash;

import java.util.ArrayList;
import java.util.List;

public class ModelFactory {

    public static ModelFactory modelFactory;
    SalonVallash salonVallash;

    public ModelFactory() {

    }


    public static ModelFactory getInstance(){
        if (modelFactory == null){
            modelFactory = new ModelFactory();

        }return modelFactory;
    }

    public List<Citadto> obtenerCitas() {
        List<Cita> citaList = salonVallash.getListaCitas();
        List<Citadto> citaDtoList = new ArrayList<>();

        for (Cita cita: citaList) {
            citaDtoList.add(buildCitaDto(cita));

        }
        return citaDtoList;
    }

    private Citadto buildCitaDto(Cita cita) {
        return new Citadto(
                cita.getClienteAsociado().getNombre(),
                cita.getClienteAsociado().getCedula(),
                cita.getTecnicoAsociado().getNombre(),
                cita.getTecnicoAsociado().getCedula(),
                cita.getTratamientoAsociado().getIdTratamiento(),
                cita.getTratamientoAsociado().getNombre(),
                cita.getId().toString(),
                cita.getFecha().toString(),
                cita.getHora().toString()

        );
    }

    public boolean crearCita(Citadto citadto) {
        Cita cita = buildCita(citadto);
        // return salonVallash.crearCita(citadto);

        return true;

    }

    private Cita buildCita(Citadto citadto) {
        return null;
    }
}
