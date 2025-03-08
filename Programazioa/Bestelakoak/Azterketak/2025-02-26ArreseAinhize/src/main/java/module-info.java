module dambat {

    requires transitive javafx.graphics;
    requires transitive javafx.controls;
    requires javafx.fxml;

    opens paagbat to javafx.fxml;
    opens paagbat.controller to javafx.fxml;
    opens paagbat.model.base to javafx.fxml;

    exports paagbat;
    exports paagbat.controller;
    exports paagbat.model;
    exports paagbat.model.base;

}
