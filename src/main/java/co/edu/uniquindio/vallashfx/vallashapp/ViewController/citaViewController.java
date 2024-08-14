package co.edu.uniquindio.vallashfx.vallashapp.ViewController;


import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.vallashfx.vallashapp.Controller.CitaController;
import co.edu.uniquindio.vallashfx.vallashapp.Mapping.dto.Citadto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private Button btnBuscarCliente;

    @FXML
    private Button btnBuscarTecnico;

    @FXML
    private Button btnEliminarCita;

    @FXML
    private ChoiceBox<?> choiTratamiento;

    @FXML
    private TableView<Citadto> tablaCita;

    @FXML
    private TableColumn<Citadto, String> tpCedulaCliente;

    @FXML
    private TableColumn<Citadto, String> tpCedulaTecnico;

    @FXML
    private TableColumn<Citadto, String> tpFecha;

    @FXML
    private TableColumn<Citadto, String> tpHora;

    @FXML
    private TableColumn<Citadto, String> tpId;

    @FXML
    private TableColumn<Citadto, String> tpNombreCliente;

    @FXML
    private TableColumn<Citadto, String> tpTecnico;

    @FXML
    private TableColumn<Citadto, String> tpTratamiento;

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
    private TextField txtNombreCliente;

    @FXML
    private TextField txtNombreTecnico;

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
            txtCedulaCliente.setText(citadto.clientedto().cedulaCliente());
            txtNombreCliente.setText(citadto.clientedto().nombreCliente());
            txtCedulaTecnico.setText(citadto.tecnicodto().cedulaTecnico());
            txtNombreTecnico.setText(citadto.tecnicodto().nombreTecnico());
            txtIdCita.setText(citadto.id());
            txtFechaCita.setText(citadto.fecha());
            txtHoraCita.setText(citadto.fecha());

        }
    }

    private void obtenerCitas() {
        listacitasdto.addAll(citaControllerService.obtenerCitas());
    }

    private void initDataBinding() {
        tpCedulaCliente.setCellValueFactory((cellData -> new SimpleStringProperty(cellData.getValue().clientedto().cedulaCliente())));
        tpNombreCliente.setCellValueFactory((cellData -> new SimpleStringProperty(cellData.getValue().clientedto().nombreCliente())));
        tpCedulaTecnico.setCellValueFactory((cellData -> new SimpleStringProperty(cellData.getValue().tecnicodto().cedulaTecnico())));
        tpTecnico.setCellValueFactory((cellData -> new SimpleStringProperty(cellData.getValue().tecnicodto().nombreTecnico())));
        tpTratamiento.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().id()));
        tpFecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().fecha()));
        tpHora.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().hora()));
    }

}

