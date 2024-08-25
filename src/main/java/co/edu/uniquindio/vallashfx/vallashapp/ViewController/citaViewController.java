package co.edu.uniquindio.vallashfx.vallashapp.ViewController;


import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import co.edu.uniquindio.vallashfx.vallashapp.Controller.CitaController;
import co.edu.uniquindio.vallashfx.vallashapp.Mapping.dto.CitaDto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class citaViewController {

    CitaController citaControllerService;

    ObservableList<CitaDto> listacitasDto = FXCollections.observableArrayList();

    CitaDto citadto;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizarCita;

    @FXML
    private Button btnAgregarCita;

    @FXML
    private Button btnEliminarCita;

    @FXML
    private TableView<CitaDto> tablaCita;

    @FXML
    private TableColumn<CitaDto, String> tcCedulaCliente;

    @FXML
    private TableColumn<CitaDto, String> tcCedulaTecnico;

    @FXML
    private TableColumn<CitaDto, String> tcCodigoTratamiento;

    @FXML
    private TableColumn<CitaDto, String> tcFecha;

    @FXML
    private TableColumn<CitaDto, String> tcHora;

    @FXML
    private TableColumn<CitaDto, String> tcIdCita;

    @FXML
    private TableColumn<CitaDto, String> tcNombreCliente;

    @FXML
    private TableColumn<CitaDto, String> tcTecnico;

    @FXML
    private TableColumn<CitaDto, String> tcTratamiento;

    @FXML
    private TextField txtCedulaCliente;

    @FXML
    private TextField txtCedulaTecnico;

    @FXML
    private TextField txtFechaCita;

    @FXML
    private TextField txtHoraCita;

    @FXML
    private TextField txtIdCita;
    @FXML
    private TextField txtIdTratamiento;

    @FXML
    private TextField txtNombreCliente;

    @FXML
    private TextField txtNombreTecnico;
    @FXML
    private TextField txtNombreTratamiento;


    @FXML
    void onActualizarCita(ActionEvent event) {
        actualizarCita();

    }

    @FXML
    void onCrearCita(ActionEvent event) {
        crearCita();

    }

    @FXML
    void onEliminarCita(ActionEvent event) {
        eliminarCita();

    }

    @FXML
    void initialize() {
        citaControllerService = new CitaController();
        initView();
    }

    private void initView() {
        initDataBinding();
        obtenerCitas();
        tablaCita.getItems().clear();
        tablaCita.setItems(listacitasDto);
        listenerSelection();
    }

    private void listenerSelection() {
        tablaCita.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            citadto = newSelection;
            mostrarInformacionCita(citadto);
        });
    }

    private void mostrarInformacionCita(CitaDto citadto){
        if (this.citadto != null){
            txtCedulaCliente.setText(citadto.cedulaCliente());
            txtNombreCliente.setText(citadto.nombreCliente());
            txtCedulaTecnico.setText(citadto.cedulaTecnico());
            txtNombreTecnico.setText(citadto.nombreTecnico());
            txtNombreTratamiento.setText(citadto.tratamiento());
            txtIdTratamiento.setText(citadto.tratamiento());
            txtIdCita.setText(citadto.id());
            txtFechaCita.setText(citadto.fecha());
            txtHoraCita.setText(citadto.fecha());

        }
    }

    private void obtenerCitas() {
        listacitasDto.addAll(citaControllerService.obtenerCitas());
    }

    private void initDataBinding() {
        tcCedulaCliente.setCellValueFactory((cellData -> new SimpleStringProperty(cellData.getValue().cedulaCliente())));
        tcNombreCliente.setCellValueFactory((cellData -> new SimpleStringProperty(cellData.getValue().nombreCliente())));
        tcCedulaTecnico.setCellValueFactory((cellData -> new SimpleStringProperty(cellData.getValue().cedulaTecnico())));
        tcTecnico.setCellValueFactory((cellData -> new SimpleStringProperty(cellData.getValue().nombreTecnico())));
        tcTratamiento.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().tratamiento()));
        tcCodigoTratamiento.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().idtratamiento()));
        tcIdCita.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().id()));
        tcFecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().fecha()));
        tcHora.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().hora()));
    }


    private void crearCita() {
        CitaDto citadto = construirCitaDto();
        if(datosValidos(citadto)){
            if(citaControllerService.crearCita(citadto)){
                listacitasDto.add(citadto);
                mostrarMensaje("Notificación Cita", "Cita creada", "La Cita se ha creado con éxito", Alert.AlertType.INFORMATION);
                limpiarCamposCita();
            }else{
                mostrarMensaje("Notificación Cita", "Cita no creada", "La Cita no se ha creado con éxito", Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje("Notificación Cita", "Cita no creada", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
        }

    }

    private void eliminarCita() {
        boolean CitaEliminada = false;
        if(citadto != null){
            if(mostrarMensajeConfirmacion("¿Estas seguro de elmininar al empleado?")){
                CitaEliminada = citaControllerService.eliminarCita(citadto.id());
                if(CitaEliminada == true){
                    listacitasDto.remove(citadto);
                    citadto = null;
                    tablaCita.getSelectionModel().clearSelection();
                    limpiarCamposCita();
                    mostrarMensaje("Notificación Cita", "Cita eliminada", "La Cita se ha eliminado con éxito", Alert.AlertType.INFORMATION);
                }else{
                    mostrarMensaje("Notificación Cita", "Cita no eliminada", "La Cita no se puede eliminar", Alert.AlertType.ERROR);
                }
            }
        }else{
            mostrarMensaje("Notificación Cita", "Cita no seleccionada", "Selecciona un Cita de la lista", Alert.AlertType.WARNING);
        }
    }

    private void actualizarCita() {
        boolean citaActualizada = false;
        String idCita = citadto.id();
        CitaDto citaDto = construirCitaDto();
        //2. verificar el empleado seleccionado
        if(citadto != null){

            if(datosValidos(citadto)){
                citaActualizada = citaControllerService.actualizarCita(idCita,citaDto);
                if(citaActualizada){
                    listacitasDto.remove(citadto);
                    listacitasDto.add(citaDto);
                    tablaCita.refresh();
                    mostrarMensaje("Notificación Cita", "Cita actualizada", "La cita se ha actualizado con éxito", Alert.AlertType.INFORMATION);
                    limpiarCamposCita();
                }else{
                    mostrarMensaje("Notificación Cita", "Cita no actualizada", "La cita no se ha actualizado con éxito", Alert.AlertType.INFORMATION);
                }
            }else{
                mostrarMensaje("Notificación Cita ", "Cita no creada", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
            }

        }
    }





    private CitaDto construirCitaDto() {
        return new CitaDto(
                txtNombreCliente.getText(),
                txtCedulaCliente.getText(),
                txtNombreTecnico.getText(),
                txtCedulaTecnico.getText(),
                txtNombreTratamiento.getText(),
                txtIdTratamiento.getText(),
                txtIdCita.getText(),
                txtFechaCita.getText(),
                txtHoraCita.getText()

        );

    }



    private void limpiarCamposCita() {

        txtIdCita.setText("");
        txtNombreCliente.setText("");
        txtCedulaCliente.setText("");
        txtNombreTecnico.setText("");
        txtCedulaTecnico.setText("");
        txtNombreTratamiento.setText("");
        txtIdTratamiento.setText("");
        txtFechaCita.setText("");
        txtHoraCita.setText("");

    }


    private CitaDto buildCitaDto() {
        return new CitaDto(
                txtNombreCliente.getText(),
                txtCedulaCliente.getText(),
                txtNombreTecnico.getText(),
                txtCedulaTecnico.getText(),
                txtNombreTratamiento.getText(),
                txtIdTratamiento.getText(),
                txtIdCita.getText(),
                txtFechaCita.getText(),
                txtHoraCita.getText()

        );
    }


    private boolean datosValidos(CitaDto citaDto) {
        String mensaje = "";
        if (citaDto.id() == null || citaDto.id().equals(""))
            mensaje += "El id es invalido \n";
        if(citaDto.nombreCliente() == null || citaDto.nombreCliente().equals(""))
            mensaje += "El nombre del cliente es invalido \n" ;
        if(citaDto.cedulaCliente() == null || citaDto.cedulaCliente() .equals(""))
            mensaje += "La cedula del cliente es invalida \n" ;
        if(citaDto.nombreTecnico() == null || citaDto.nombreTecnico().equals(""))
            mensaje += "El nombre del tecnico es invalido \n" ;
        if(citaDto.cedulaTecnico() == null || citaDto.cedulaTecnico().equals(""))
            mensaje += "La cedula del tecnico es invalida \n" ;
        if(citaDto.tratamiento() == null || citaDto.tratamiento().equals(""))
            mensaje += "El tratamiento es invalido \n" ;
        if(citaDto.fecha() == null || citaDto.fecha().equals(""))
            mensaje += "La fecha es invalida \n" ;
        if(citaDto.hora() == null || citaDto.hora().equals(""))
            mensaje += "La hora es invalida \n" ;
        if(mensaje.equals("")){
            return true;
        }else{
            mostrarMensaje("Notificación cliente","Datos invalidos",mensaje, Alert.AlertType.WARNING);
            return false;
        }
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    private boolean mostrarMensajeConfirmacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText(mensaje);
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }


}

