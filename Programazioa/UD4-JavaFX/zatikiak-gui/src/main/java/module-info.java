module paagbat {
    exports paagbat.model;
    exports paagbat.controller;
    requires javafx.controls;
    requires javafx.fxml;

    opens paagbat to javafx.fxml;
    opens paagbat.controller to javafx.fxml;
    exports paagbat;
}
