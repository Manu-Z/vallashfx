module co.edu.uniquindio.vallashfx.vallashapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.vallashfx.vallashapp to javafx.fxml;
    exports co.edu.uniquindio.vallashfx.vallashapp;
}