module com.arribason.geometrictranducer {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.arribason.geometrictranducer to javafx.fxml;
    exports com.arribason.geometrictranducer;
    exports com.arribason.geometrictranducer.Dialogs;
    opens com.arribason.geometrictranducer.Dialogs to javafx.fxml;
    exports com.arribason.geometrictranducer.Geometry;
    opens com.arribason.geometrictranducer.Geometry to javafx.fxml;
}