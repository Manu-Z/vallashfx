package co.edu.uniquindio.vallashfx.vallashapp.Utils;

import co.edu.uniquindio.vallashfx.vallashapp.Model.*;

public class VallashUtils {

    public static SalonVallash inicializarDatos(){
        SalonVallash salonVallash = new SalonVallash();

        Cliente cliente = new Cliente();
        cliente.setId("01");
        cliente.setNombre("Adriana");
        cliente.setApellido("Gomez");
        cliente.setCedula("1093");
        cliente.setEdad(30);
        cliente.setTelefono("31466");
        salonVallash.getListaClientes().add(cliente);

        Cliente cliente2 = new Cliente();
        cliente2.setId("02");
        cliente2.setNombre("Salome");
        cliente2.setApellido("Muñoz");
        cliente2.setCedula("1098");
        cliente2.setEdad(25);
        cliente2.setTelefono("35243");
        salonVallash.getListaClientes().add(cliente2);

        Cliente cliente3 = new Cliente();
        cliente3.setId("03");
        cliente3.setNombre("Carolina");
        cliente3.setApellido("Garcia");
        cliente3.setCedula("1089");
        cliente3.setEdad(22);
        cliente3.setTelefono("31672");
        salonVallash.getListaClientes().add(cliente3);

        Tecnico tecnico = new Tecnico();
        tecnico.setId("A");
        tecnico.setNombre("Daniel");
        tecnico.setApellido("Suarez");
        tecnico.setCedula("1023");
        tecnico.setEdad(25);
        tecnico.setTelefono("3766");
        salonVallash.getListaTecnicos().add(tecnico);

        Tecnico tecnico2 = new Tecnico();
        tecnico2.setId("B");
        tecnico2.setNombre(" Samantha");
        tecnico2.setApellido("Rodriguez");
        tecnico2.setCedula("1094");
        tecnico2.setEdad(30);
        tecnico2.setTelefono("3218");
        salonVallash.getListaTecnicos().add(tecnico2);

        Tecnico tecnico3 = new Tecnico();
        tecnico3.setId("C");
        tecnico3.setNombre("Paola");
        tecnico3.setApellido("Restrepo");
        tecnico3.setCedula("1093");
        tecnico3.setEdad(30);
        tecnico3.setTelefono("3762");
        salonVallash.getListaTecnicos().add(tecnico3);

        Tratamiento tratamiento = new Tratamiento();
        tratamiento.setNombre("Efecto natural");
        tratamiento.setDescripcion("Extensiones de pestañas diseñadas para ofrecer un aspecto delicado y auténtico");
        tratamiento.setPrecio(60000);
        tratamiento.setIdTratamiento("EF01");
        salonVallash.getListaTratamientos().add(tratamiento);

        Tratamiento tratamiento2 = new Tratamiento();
        tratamiento2.setNombre("Efecto Pestañina");
        tratamiento2.setDescripcion("Extensiones que logran aumentar tu volumen, grosor y curvatura, de la forma más sutil posible");
        tratamiento2.setPrecio(60000);
        tratamiento2.setIdTratamiento("EP02");
        salonVallash.getListaTratamientos().add(tratamiento2);

        Tratamiento tratamiento3 = new Tratamiento();
        tratamiento3.setNombre("Volumen hawaiano");
        tratamiento3.setDescripcion("Presentan longitudes y volúmenes atrevidos");
        tratamiento3.setPrecio(80000);
        tratamiento3.setIdTratamiento("VH03");
        salonVallash.getListaTratamientos().add(tratamiento3);

        Tratamiento tratamiento4 = new Tratamiento();
        tratamiento3.setNombre("Lifting");
        tratamiento3.setDescripcion("Eleva la curvatura de tus pestañas sin utilizar pelo sintético");
        tratamiento3.setPrecio(55000);
        tratamiento3.setIdTratamiento("LF04");
        salonVallash.getListaTratamientos().add(tratamiento3);

        Cita cita = new Cita();
        cita.setId("1");
        cita.setFecha("13-8-2024");
        cita.setHora("8:00 am");
        cita.setClienteAsociado(salonVallash.getListaClientes().get(0));
        cita.setTratamientoAsociado(salonVallash.getListaTratamientos().get(0));
        cita.setTecnicoAsociado(salonVallash.getListaTecnicos().get(0));
        salonVallash.getListaCitas().add(cita);

        return salonVallash;







    }



}
