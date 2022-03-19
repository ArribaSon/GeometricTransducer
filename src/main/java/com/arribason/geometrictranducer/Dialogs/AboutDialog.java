package com.arribason.geometrictranducer.Dialogs;

import com.arribason.geometrictranducer.GeometricTransducer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AboutDialog {

    private final Stage stage;
    private final AboutDController aboutDController;

    public AboutDialog() throws IOException {
        stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(GeometricTransducer.class.getResource("about-dialog.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setScene(scene);
        aboutDController = fxmlLoader.getController();
        stage.setTitle("О программе");
    }

    public void show(){
        aboutDController.getAboutText().setText("""
                GeometricTransducer v1
                Программу выполнили: Чистяков Константин и Вадим Кагарманов студенты группы ЕТ-311
                Исходный код: 
                """);
        stage.showAndWait();
    }
}
