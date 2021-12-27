module com.example.lab5_1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.lab5_1 to javafx.fxml;
    exports com.example.lab5_1;
}