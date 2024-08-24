package co.edu.uniquindio.vallashfx.vallashapp.Mapping.mappers;

import co.edu.uniquindio.vallashfx.vallashapp.Mapping.dto.CitaDto;
import co.edu.uniquindio.vallashfx.vallashapp.Model.Cita;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface VallashMapper {

    VallashMapper INSTANCE = Mappers.getMapper(VallashMapper.class);

    @Named("CitaToCitaDto")

    @Mapping(source = "clienteAsociado.nombre", target = "nombreCliente")
    @Mapping(source = "clienteAsociado.cedula", target = "cedulaCliente")
    @Mapping(source = "tecnicoAsociado.nombre", target = "nombreTecnico")
    @Mapping(source = "tecnicoAsociado.cedula", target = "cedulaTecnico")
    @Mapping(source = "tratamientoAsociado.nombre", target = "tratamiento")
    CitaDto CitaToCitaDto(Cita cita);

    

    @Mapping(source = "nombreCliente", target = "clienteAsociado.nombre")
    @Mapping(source = "cedulaCliente", target = "clienteAsociado.cedula")
    @Mapping(source = "nombreTecnico", target = "tecnicoAsociado.nombre")
    @Mapping(source = "cedulaTecnico", target = "tecnicoAsociado.cedula")
    @Mapping(source = "tratamiento", target = "tratamientoAsociado.nombre")

    Cita citaDtoToCita(CitaDto citaDto);







    @IterableMapping(qualifiedByName = "CitaToCitaDto")
    List<CitaDto> getCitaDto(List<Cita> listaCitas);
}
