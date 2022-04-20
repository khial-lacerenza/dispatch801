module com.lk.fret {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires common;
    requires com.jfoenix;

    opens com.lk.fret to javafx.fxml;
    exports com.lk.fret;
    exports com.lk.fret.controller;
    opens com.lk.fret.controller to javafx.fxml;
}