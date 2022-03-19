package com.arribason.geometrictranducer.Dialogs;

import com.arribason.geometrictranducer.GeometricTransducer;
import com.arribason.geometrictranducer.Geometry.Polygon;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class ConvertDialog {

    private final Stage stage;
    private final ConvertDController convertDController;


    public ConvertDialog() throws IOException {
        stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(GeometricTransducer.class.getResource("convert-dialog.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Преобразовать");
        convertDController = fxmlLoader.getController();
        convertDController.getAngle().textProperty().addListener((observableValue, s, t1) -> {
            convertDController.getTurnA11().setText("cos(" + convertDController.getAngle().getText() + ")");
            convertDController.getTurnA12().setText("sin(" + convertDController.getAngle().getText() + ")");
            convertDController.getTurnA21().setText("-sin(" + convertDController.getAngle().getText() + ")");
            convertDController.getTurnA22().setText("cos(" + convertDController.getAngle().getText() + ")");
        });

        convertDController.getReflectionX().selectedProperty().addListener((observableValue, aBoolean, t1) -> {
            if(t1) convertDController.getRefA22().setText("-1");
            else convertDController.getRefA22().setText("1");
        });
        convertDController.getReflectionY().selectedProperty().addListener((observableValue, aBoolean, t1) -> {
            if(t1) convertDController.getRefA11().setText("-1");
            else convertDController.getRefA11().setText("1");
        });
        stage.setScene(scene);
    }

    public void show(Polygon polygon) {

        convertDController.getOk().setOnAction(actionEvent -> {
            try {
                double[] x = new double[polygon.getN()];
                double[] y = new double[polygon.getN()];
                double[] nx = new double[polygon.getN()];
                double[] ny = new double[polygon.getN()];
                Scanner scanner = new Scanner(convertDController.getAngle().getText());
                double angle = scanner.nextDouble();
                scanner = new Scanner(convertDController.getOriginX().getText());
                double originX = scanner.nextDouble();
                scanner = new Scanner(convertDController.getOriginY().getText());
                double originY = scanner.nextDouble();

                scanner = new Scanner(convertDController.getRefA11().getText());
                double refX = scanner.nextDouble();
                scanner = new Scanner(convertDController.getRefA22().getText());
                double refY = scanner.nextDouble();

                scanner = new Scanner(convertDController.getMoveX().getText());
                double dx = scanner.nextDouble();
                scanner = new Scanner(convertDController.getMoveY().getText());
                double dy = scanner.nextDouble();

                scanner = new Scanner(convertDController.getScaleX().getText());
                double sx = scanner.nextDouble();
                scanner = new Scanner(convertDController.getScaleY().getText());
                double sy = scanner.nextDouble();
                scanner = new Scanner(convertDController.getOriginX1().getText());
                double originX1 = scanner.nextDouble();
                scanner = new Scanner(convertDController.getOriginY1().getText());
                double originY1 = scanner.nextDouble();

                polygon.getVertexes(x, y);
                for (int i = 0; i < polygon.getN(); i++) {
                    //Вращение
                    nx[i] = ((x[i] - originX) * Math.cos(angle * Math.PI / 180) - (y[i] - originY) * Math.sin(angle * Math.PI / 180));
                    nx[i] += originX;
                    ny[i] = ((x[i] - originX) * Math.sin(angle * Math.PI / 180) + (y[i] - originY) * Math.cos(angle * Math.PI / 180));
                    ny[i] += originY;
                    //Отображение
                    nx[i] = nx[i] * refX;
                    ny[i] = ny[i] * refY;
                    //Перемещение
                    nx[i] += dx;
                    ny[i] += dy;
                    //Маштабирование
                    nx[i] = (nx[i] - originX) * sx;
                    nx[i] += originX;
                    ny[i] = (ny[i] - originY) * sy;
                    ny[i] += originY;
                }
                polygon.setVertexes(nx, ny);
                stage.close();
            } catch (Exception e) {

            }
        });
        convertDController.getCancel().setOnAction(actionEvent -> {
            stage.close();
        });
        stage.showAndWait();
    }
}
