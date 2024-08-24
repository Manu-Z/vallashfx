package co.edu.uniquindio.vallashfx.vallashapp;

import co.edu.uniquindio.vallashfx.vallashapp.Factory.ModelFactory;
import co.edu.uniquindio.vallashfx.vallashapp.Mapping.dto.CitaDto;

import java.util.List;

public class MainVallash {
    public static void main(String[] args) {

        ModelFactory modelFactory = ModelFactory.getInstance();
        CitaDto citaDto = new CitaDto(
                 "Juana",
                  "234",
                 "Julia",
                  "678",
                 "pestañas",
                       "0A",
                       "01",
                    "mayo/03/2024",
                     "8:00 pm");


        List<CitaDto> citaDtoList = modelFactory.obtenerCitass();
        citaDtoList.forEach(System.out::println);
    }
}
