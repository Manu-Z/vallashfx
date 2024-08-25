module co.edu.uniquindio.vallashfx.vallashapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mapstruct;


    opens co.edu.uniquindio.vallashfx.vallashapp to javafx.fxml;
    exports co.edu.uniquindio.vallashfx.vallashapp;
    opens co.edu.uniquindio.vallashfx.vallashapp.ViewController to javafx.fxml;
    exports co.edu.uniquindio.vallashfx.vallashapp.ViewController;
    exports co.edu.uniquindio.vallashfx.vallashapp.Controller;
    exports co.edu.uniquindio.vallashfx.vallashapp.Mapping.dto;
    exports co.edu.uniquindio.vallashfx.vallashapp.Model;
    opens co.edu.uniquindio.vallashfx.vallashapp.Controller to javafx.fxml;

    exports co.edu.uniquindio.vallashfx.vallashapp.Mapping.mappers;
}