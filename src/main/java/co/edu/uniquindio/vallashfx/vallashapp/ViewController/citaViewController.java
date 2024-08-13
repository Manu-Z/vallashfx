package co.edu.uniquindio.vallashfx.vallashapp.ViewController;


import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.vallashfx.vallashapp.Mapping.dto.Citadto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class citaViewController {

    ObservableList<Citadto> listacitasdto = FXCollections.observableArrayList();

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
    private TableColumn<?, ?> tpCedulaCliente;

    @FXML
    private TableColumn<?, ?> tpCedulaTecnico;

    @FXML
    private TableColumn<?, ?> tpFecha;

    @FXML
    private TableColumn<?, ?> tpHora;

    @FXML
    private TableColumn<?, ?> tpId;

    @FXML
    private TableColumn<?, ?> tpNombreCliente;

    @FXML
    private TableColumn<?, ?> tpTecnico;

    @FXML
    private TableColumn<?, ?> tpTratamiento;

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

        initDataBinding();
        obtenerCitas();
        tablaCita.getItems().clear();
        tablaCita.setItems(listacitasdto);
        listenerSelection();


    }

    private void listenerSelection() {
    }

    private void obtenerCitas() {
    }

    private void initDataBinding() {
    }

}

