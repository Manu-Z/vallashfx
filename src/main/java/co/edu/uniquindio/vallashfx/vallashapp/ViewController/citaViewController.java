package co.edu.uniquindio.vallashfx.vallashapp.ViewController;


import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.vallashfx.vallashapp.Controller.CitaController;
import co.edu.uniquindio.vallashfx.vallashapp.Mapping.dto.Citadto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class citaViewController {

    CitaController citaControllerService;

    ObservableList<Citadto> listacitasdto = FXCollections.observableArrayList();

    Citadto citadto;

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
    private TableView<Citadto> tablaCita;

    @FXML
    private TableColumn<Citadto, String> tcCedulaCliente;

    @FXML
    private TableColumn<Citadto, String> tcCedulaTecnico;

    @FXML
    private TableColumn<Citadto, String> tcCodigoTratamiento;

    @FXML
    private TableColumn<Citadto, String> tcFecha;

    @FXML
    private TableColumn<Citadto, String> tcHora;

    @FXML
    private TableColumn<Citadto, String> tcIdCita;

    @FXML
    private TableColumn<Citadto, String> tcNombreCliente;

    @FXML
    private TableColumn<Citadto, String> tcTecnico;

    @FXML
    private TableColumn<Citadto, String> tcTratamiento;

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

    }

    @FXML
    void onCrearCita(ActionEvent event) {
        crearCita();

    }

    private void crearCita() {
        citadto = buildCitaDto();
        citaControllerService.crearCita(citadto);
    }

    private Citadto buildCitaDto() {
        return new Citadto(
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

    @FXML
    void onEliminarCita(ActionEvent event) {

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
        tablaCita.setItems(listacitasdto);
        listenerSelection();
    }

    private void listenerSelection() {
        tablaCita.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            citadto = newSelection;
            mostrarInformacionCita(citadto);
        });
    }

    private void mostrarInformacionCita(Citadto citadto){
        if (this.citadto != null){
            txtCedulaCliente.setText(citadto.cedulaCliente());
            txtNombreCliente.setText(citadto.nombreCliente());
            txtCedulaTecnico.setText(citadto.cedulaTecnico());
            txtNombreTecnico.setText(citadto.nombreTecnico());
            txtNombreTratamiento.setText(citadto.tratamiento());
            txtIdTratamiento.setText(citadto.idtratamiento());
            txtIdCita.setText(citadto.id());
            txtFechaCita.setText(citadto.fecha());
            txtHoraCita.setText(citadto.fecha());

        }
    }

    private void obtenerCitas() {
        listacitasdto.addAll(citaControllerService.obtenerCitas());
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

}

