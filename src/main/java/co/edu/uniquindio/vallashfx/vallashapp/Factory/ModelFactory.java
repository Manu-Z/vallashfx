package co.edu.uniquindio.vallashfx.vallashapp.Factory;


import co.edu.uniquindio.vallashfx.vallashapp.Exceptions.CitaException;
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
        private final static ModelFactory eINSTANCE = new ModelFactory();
    }

    // Método para obtener la instancia de nuestra clase
    public static ModelFactory getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactory() {
        System.out.println("invocación clase singleton");
        cargarDatosBase();
    }

    private void cargarDatosBase() {

        salonVallash = VallashUtils.inicializarDatos();
    }

    public SalonVallash getSalonVallash(){
        return salonVallash;
    }

    public void setSalonVallash(SalonVallash salonVallash){
        this.salonVallash = salonVallash;
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

    @Override
    public boolean crearCita(CitaDto citadto) {
        try{
            if(!salonVallash.verificarCitaExistente(citadto.id())) {
                Cita cita = mapper.citaDtoToCita(citadto);
                getSalonVallash().crearCita(cita);
            }
            return true;
        }catch (CitaException e){
            e.getMessage();
            return false;
        }
    }


    @Override
    public boolean eliminarCita(String id) {
        boolean flagExiste = false;
        try {
            flagExiste = getSalonVallash().eliminarCita(id);
        } catch (CitaException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flagExiste;
    }

    @Override
    public boolean actualizarCita(String idActual, CitaDto citaDto) {
        try {
            Cita cita = mapper.citaDtoToCita(citaDto);
            getSalonVallash().actualizarCita(idActual, cita);
            return true;
        } catch (CitaException e) {
            e.printStackTrace();
            return false;
        }
    }
}
