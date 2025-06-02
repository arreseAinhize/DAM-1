module paagbat {

    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive java.sql;

    opens paagbat to javafx.fxml;
    opens paagbat.controller to javafx.fxml;
    opens paagbat.model.base to javafx.fxml;

    exports paagbat;
    exports paagbat.controller;
    exports paagbat.model;
    exports paagbat.model.base;

}
