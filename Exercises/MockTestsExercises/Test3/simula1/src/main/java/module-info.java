module covid_app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens br.ifsp.infection.view to javafx.fxml;
    exports br.ifsp.infection.view;

    exports br.ifsp.infection.model;
    opens br.ifsp.infection.model to javafx.fxml;

    exports br.ifsp.infection.persistence;
    opens br.ifsp.infection.persistence to javafx.fxml;

    exports br.ifsp.infection.controller;
    opens br.ifsp.infection.controller to javafx.fxml;
}