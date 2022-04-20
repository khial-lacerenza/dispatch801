module com.lk.fret {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires common;

    opens com.lk.fret to javafx.fxml;
    exports com.lk.fret;
    exports com.lk.fret.Controller;
    opens com.lk.fret.Controller to javafx.fxml;
}