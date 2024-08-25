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

    @Named("citaToCitaDto")
    @Mapping(source = "clienteAsociado.nombre", target = "nombreCliente")
    @Mapping(source = "clienteAsociado.cedula", target = "cedulaCliente")
    @Mapping(source = "tecnicoAsociado.nombre", target = "nombreTecnico")
    @Mapping(source = "tecnicoAsociado.cedula", target = "cedulaTecnico")
    @Mapping(source = "tratamientoAsociado.nombre", target = "tratamiento")
    @Mapping(source = "tratamientoAsociado.idTratamiento", target = "idtratamiento")
    CitaDto citaToCitaDto(Cita cita);

    @Named("citaDtoToCita")

    @Mapping(source = "nombreCliente", target = "clienteAsociado.nombre")
    @Mapping(source = "cedulaCliente", target = "clienteAsociado.cedula")
    @Mapping(source = "nombreTecnico", target = "tecnicoAsociado.nombre")
    @Mapping(source = "cedulaTecnico", target = "tecnicoAsociado.cedula")
    @Mapping(source = "tratamiento", target = "tratamientoAsociado.nombre")
    @Mapping(source = "idtratamiento", target = "tratamientoAsociado.idTratamiento")
    Cita citaDtoToCita(CitaDto citaDto);

    @IterableMapping(qualifiedByName = "citaToCitaDto")
    List<CitaDto> getCitaDto(List<Cita> listaCitas);
}
