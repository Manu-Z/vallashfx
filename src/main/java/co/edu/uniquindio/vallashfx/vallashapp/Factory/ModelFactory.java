package co.edu.uniquindio.vallashfx.vallashapp.Factory;


import co.edu.uniquindio.vallashfx.vallashapp.Factory.Servicios.IModelFactoryService;
import co.edu.uniquindio.vallashfx.vallashapp.Mapping.dto.CitaDto;
import co.edu.uniquindio.vallashfx.vallashapp.Mapping.mappers.VallashMapper;
import co.edu.uniquindio.vallashfx.vallashapp.Model.Cita;
import co.edu.uniquindio.vallashfx.vallashapp.Model.SalonVallash;
import co.edu.uniquindio.vallashfx.vallashapp.Utils.VallashUtils;

import java.util.List;

public class ModelFactory implements IModelFactoryService {

    SalonVallash salonVallash;

    VallashMapper mapper = VallashMapper.INSTANCE;



    private static class SingletonHolder {
        private final static ModelFactory INSTANCE = new ModelFactory();
    }

    // Método para obtener la instancia de nuestra clase
    public static ModelFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public ModelFactory() {
        System.out.println("invocación clase singleton");
        cargarDatosBase();
    }

    private void cargarDatosBase() {
        salonVallash = VallashUtils.inicializarDatos();
    }

   @Override
   public List<CitaDto> obtenerCitass(){
        return mapper.getCitaDto(salonVallash.getListaCitas());
   }


    /// public List<CitaDto> obtenerCitas() {
     //  List<Cita> citaList = salonVallash.getListaCitas();
      // List<CitaDto> citaDtoList = new ArrayList<>();

      // for (Cita cita: citaList) {
       //  citaDtoList.add(buildCitaDto(cita));

     // }
      // return citaDtoList;
    //}

    private CitaDto buildCitaDto(Cita cita) {
        return new CitaDto(
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

    public boolean crearCita(CitaDto citadto) {
        Cita cita = buildCita(citadto);
        // return salonVallash.crearCita(citadto);

        return true;

    }

    private Cita buildCita(CitaDto citadto) {
        return null;
    }
}
