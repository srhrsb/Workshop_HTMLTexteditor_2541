module com.brh.workshop_htmltexteditor_2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.brh.workshop_htmltexteditor_2 to javafx.fxml;
    exports com.brh.workshop_htmltexteditor_2;
}