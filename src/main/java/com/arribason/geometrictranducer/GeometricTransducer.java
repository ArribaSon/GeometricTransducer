package com.arribason.geometrictranducer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GeometricTransducer extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        GTController gtController;

        FXMLLoader fxmlLoader = new FXMLLoader(GeometricTransducer.class.getResource("main-form.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Geometric transducer");
        stage.setScene(scene);
        stage.show();

        gtController = fxmlLoader.getController();
        gtController.createLab1Scene();
    }

    public static void main(String[] args) {
        launch();
    }
}