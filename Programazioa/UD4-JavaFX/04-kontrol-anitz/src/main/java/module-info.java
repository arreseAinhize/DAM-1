module dambat {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens paagbat to javafx.fxml;
    opens paagbat.controller to javafx.fxml;
    opens paagbat.model.base to javafx.base;

    exports paagbat;
    exports paagbat.controller;
    exports paagbat.model;
}
