package com.arribason.geometrictranducer.Geometry;

import com.arribason.geometrictranducer.Dialogs.ConvertDialog;
import com.arribason.geometrictranducer.Dialogs.NewPolygonDialog;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Scene2D {

    private final SubScene scene;
    private final AnchorPane root1;
    private final Grid2D grid2D;
    private final MyCamera camera;
    private final Group group;

    private Label info;
    private Accordion accordion;

    private double xMouseNew = 0;
    private double yMouseNew = 0;
    private double yMouseOld = 0;
    private double xMouseOld = 0;

    private final List<Polygon> polygons = new LinkedList<>();

    public Scene2D(AnchorPane root1, AnchorPane root2) {
        //Инициализация
        this.root1 = root1;
        group = new Group();

        //Интерфейс
        buildGI();

        //SubScene
        scene = new SubScene(group, root2.getWidth(), root2.getHeight(), true, SceneAntialiasing.BALANCED);
        scene.setFill(Color.BISQUE);
        root2.getChildren().add(scene);

        //MyCamera
        camera = new MyCamera();

        //Grid 2D
        grid2D = new Grid2D(scene, group);
        camera.add(grid2D);

        //Изменение камеры
        scene.addEventHandler(MouseEvent.ANY, mouseEvent -> {
            root2.setCursor(Cursor.OPEN_HAND);
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED
                    || mouseEvent.getEventType() == MouseEvent.MOUSE_DRAGGED &&
                    mouseEvent.getButton() == MouseButton.PRIMARY) {
                root2.setCursor(Cursor.CLOSED_HAND);
                xMouseNew = mouseEvent.getSceneX();
                yMouseNew = mouseEvent.getSceneY();

                if (mouseEvent.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                    camera.setTranslateY((int) (camera.getY() + (yMouseOld - yMouseNew)));
                    camera.setTranslateX((int) (camera.getX() + (xMouseOld - xMouseNew)));
                    info.setText(camera.getX() + " " + camera.getY());
                }
            }
            xMouseOld = xMouseNew;
            yMouseOld = yMouseNew;
        });

        //Изменение окна
        root2.widthProperty().addListener((observableValue, number, t1) -> {
            scene.setWidth(root2.getWidth());
            scene.setHeight(root2.getHeight());
            grid2D.reBuild();
        });
        root2.heightProperty().addListener((observableValue, number, t1) -> {
            scene.setWidth(root2.getWidth());
            scene.setHeight(root2.getHeight());
            grid2D.reBuild();
        });
    }

    private void buildGI() {
        //Label
        info = new Label("");
        AnchorPane.setBottomAnchor(info, 0.0);
        AnchorPane.setLeftAnchor(info, 0.0);
        AnchorPane.setRightAnchor(info, 0.0);
        root1.getChildren().add(info);
        //ScrollPane
        ScrollPane scrollPane = new ScrollPane();
        AnchorPane.setTopAnchor(scrollPane, 0.0);
        AnchorPane.setLeftAnchor(scrollPane, 0.0);
        AnchorPane.setRightAnchor(scrollPane, 0.0);
        AnchorPane.setBottomAnchor(scrollPane, 200.0);
        root1.getChildren().add(scrollPane);
        //VBox
        VBox vBox = new VBox();
        scrollPane.setContent(vBox);
        //New Polygon Button
        Button newPolygonBtn = new Button("Новая фигура");
        newPolygonBtn.setOnAction(event ->
                newPolygon());
        vBox.getChildren().add(newPolygonBtn);
        //Accordion
        accordion = new Accordion();
        vBox.getChildren().add(accordion);
    }

    private void newPolygon() {
        int n;
        Color color;
        String name;
        NewPolygonDialog newPolygonDialog = new NewPolygonDialog();
        newPolygonDialog.show();
        n = newPolygonDialog.getNum();
        color = newPolygonDialog.getColor();
        name = newPolygonDialog.getName();
        if (n != -1 && color != null) {
            HBox[] hBoxes = new HBox[n + 1];
            TextField[] textFieldsX = new TextField[n];
            TextField[] textFieldsY = new TextField[n];
            TitledPane titledPane = new TitledPane();
            titledPane.setText(name);
            VBox vBox = new VBox();
            titledPane.setContent(vBox);

            Polygon polygon = new Polygon(group, grid2D, n, color);
            polygons.add(polygon);
            camera.add(polygon);
            camera.setTranslateX(camera.getX() + 1);
            camera.setTranslateX(camera.getX() - 1);
            camera.setTranslateY(camera.getY() + 1);
            camera.setTranslateY(camera.getY() - 1);

            for (int i = 0; i < n; i++) {
                hBoxes[i] = new HBox();
                textFieldsX[i] = new TextField("0.0");
                textFieldsY[i] = new TextField("0.0");
                vBox.getChildren().addAll(hBoxes[i]);
                hBoxes[i].getChildren().addAll(textFieldsX[i], textFieldsY[i]);
            }
            hBoxes[n] = new HBox();

            Button delete = new Button("Удалить");
            hBoxes[n].getChildren().add(delete);
            vBox.getChildren().addAll(hBoxes[n]);
            delete.setOnAction(actionEvent -> {
                accordion.getPanes().removeAll(titledPane);
                polygon.delete();
                polygons.remove(polygon);
            });

            Button convert = new Button("Преобразовать");
            hBoxes[n].getChildren().add(convert);
            convert.setOnAction(actionEvent -> {
                ConvertDialog convertDialog;
                try {
                    convertDialog = new ConvertDialog();
                    convertDialog.show(polygon);
                    camera.setTranslateX(camera.getX() + 1);
                    camera.setTranslateX(camera.getX() - 1);
                    camera.setTranslateY(camera.getY() + 1);
                    camera.setTranslateY(camera.getY() - 1);
                    for (int i = 0; i < n; i++) {
                        double[] x = new double[n];
                        double[] y = new double[n];
                        polygon.getVertexes(x, y);
                        textFieldsX[i].setText("" + x[i]);
                        textFieldsY[i].setText("" + y[i]);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            });

            accordion.getPanes().add(titledPane);

            double[] x = new double[n];
            double[] y = new double[n];
            for (int i = 0; i < n; i++) {
                int finalI = i;
                textFieldsX[i].textProperty().addListener((observableValue, s, t1) -> {
                    try {
                        Scanner scanner = new Scanner(t1);
                        x[finalI] = scanner.nextDouble();
                        polygon.setVertexes(x, y);
                        camera.setTranslateX(camera.getX() + 1);
                        camera.setTranslateX(camera.getX() - 1);
                        camera.setTranslateY(camera.getY() + 1);
                        camera.setTranslateY(camera.getY() - 1);
                    } catch (Exception ignored) {

                    }
                });
                textFieldsY[i].textProperty().addListener((observableValue, s, t1) -> {
                    try {
                        Scanner scanner = new Scanner(t1);
                        y[finalI] = scanner.nextDouble();
                        polygon.setVertexes(x, y);
                        camera.setTranslateX(camera.getX() + 1);
                        camera.setTranslateX(camera.getX() - 1);
                        camera.setTranslateY(camera.getY() + 1);
                        camera.setTranslateY(camera.getY() - 1);
                    } catch (Exception ignored) {

                    }
                });
            }

        }
    }
}
