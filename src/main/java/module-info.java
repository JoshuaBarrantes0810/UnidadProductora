module cr.ac.una.landuna {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;
    opens cr.ac.una.landuna to javafx.fxml;
    exports cr.ac.una.landuna;
}
