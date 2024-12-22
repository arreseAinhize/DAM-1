module paagbat {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media; // Si usas audio/video
    
    opens paagbat.app to javafx.graphics;
    opens paagbat.controllers to javafx.fxml;
    exports paagbat.app;
    exports paagbat.controllers;
}
