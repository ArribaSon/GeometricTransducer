package com.arribason.geometrictranducer.Dialogs;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Scanner;

public class NewPolygonDialog {

    private final Stage stage;
    private final Button ok;
    private final Button cancel;
    private final AnchorPane anchorPane;
    private final ColorPicker colorPicker;
    private final TextField number;
    private final TextField nameF;
    private String name;
    private int num = -1;
    private Color color;

    public NewPolygonDialog() {
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        anchorPane = new AnchorPane();
        Scene scene = new Scene(anchorPane, 400, 200);
        stage.setTitle("Создать новую фигуру");

        ok = new Button("OK");
        AnchorPane.setBottomAnchor(ok, 10.0);
        AnchorPane.setRightAnchor(ok, 10.0);
        cancel = new Button("Отмена");
        AnchorPane.setBottomAnchor(cancel, 10.0);
        AnchorPane.setLeftAnchor(cancel, 10.0);
        anchorPane.getChildren().addAll(ok, cancel);

        Label label1 = new Label("Количество вершин");
        label1.setFont(new Font(16));
        AnchorPane.setTopAnchor(label1, 20.0);
        AnchorPane.setLeftAnchor(label1, 10.0);
        anchorPane.getChildren().addAll(label1);

        number = new TextField();
        AnchorPane.setTopAnchor(number, 20.0);
        AnchorPane.setLeftAnchor(number, 200.0);
        anchorPane.getChildren().addAll(number);

        Label label2 = new Label("Цвет");
        label2.setFont(new Font(16));
        AnchorPane.setTopAnchor(label2, 56.0);
        AnchorPane.setLeftAnchor(label2, 10.0);
        anchorPane.getChildren().addAll(label2);

        colorPicker = new ColorPicker();
        AnchorPane.setTopAnchor(colorPicker, 56.0);
        AnchorPane.setLeftAnchor(colorPicker, 200.0);
        anchorPane.getChildren().addAll(colorPicker);

        nameF = new TextField();
        AnchorPane.setTopAnchor(nameF, 92.0);
        AnchorPane.setLeftAnchor(nameF, 200.0);
        anchorPane.getChildren().addAll(nameF);

        Label label3 = new Label("Название");
        label3.setFont(new Font(16));
        AnchorPane.setTopAnchor(label3, 92.0);
        AnchorPane.setLeftAnchor(label3, 10.0);
        anchorPane.getChildren().addAll(label3);

        stage.setScene(scene);
    }

    public void show() {

        ok.setOnAction(actionEvent -> setOk());
        cancel.setOnAction(actionEvent -> stage.close());
        stage.showAndWait();
    }

    private void setOk(){
        Label error = new Label("Цвет");
        error.setText("Неверно");
        error.setTextFill(Color.RED);
        error.setFont(new Font(10));
        AnchorPane.setBottomAnchor(error, 15.0);
        AnchorPane.setRightAnchor(error, 50.0);
        anchorPane.getChildren().addAll(error);
        error.setVisible(false);
        try {
            Scanner scanner = new Scanner(number.getText());
            error.setVisible(false);
            num = scanner.nextInt();
            if(num < 1) throw new Exception();
            scanner.close();
            name = nameF.getText();
            color = colorPicker.getValue();
            stage.close();
            if(num < 1) throw new Exception();
        }catch (Exception e){
            error.setVisible(true);
        }
    }

    public int getNum() {
        return num;
    }

    public Color getColor() {
        return color;
    }

    public String getName(){
        return name;
    }
}