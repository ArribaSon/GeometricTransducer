package com.arribason.geometrictranducer.Geometry3D;

import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class Scene3D {

    private final SubScene scene;
    private final AnchorPane root1;
    private final Group group;

    private double xMouseNew = 0;
    private double yMouseNew = 0;
    private double yMouseOld = 0;
    private double xMouseOld = 0;

    public Scene3D(AnchorPane root1, AnchorPane root2) {
        //Инициализация
        this.root1 = root1;
        group = new Group();

        //SubScene
        scene = new SubScene(group, root2.getWidth(), root2.getHeight(), true, SceneAntialiasing.BALANCED);
        scene.setFill(Color.BISQUE);
        root2.getChildren().add(scene);

        Grid3D grid3D = new Grid3D(scene, group);
        grid3D.setTranslateX(200);
        //grid3D.setTranslateY(200);
        grid3D.setTranslateZ(-200);
        grid3D.setRotateX(-45,0,0);
        grid3D.setRotateZ(45,0,0);


        scene.addEventHandler(MouseEvent.ANY, mouseEvent -> {
            root2.setCursor(Cursor.OPEN_HAND);
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED
                    || mouseEvent.getEventType() == MouseEvent.MOUSE_DRAGGED &&
                    mouseEvent.getButton() == MouseButton.PRIMARY) {
                root2.setCursor(Cursor.CLOSED_HAND);
                xMouseNew = mouseEvent.getSceneX();
                yMouseNew = mouseEvent.getSceneY();

                if (mouseEvent.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                    grid3D.setRotateZ((xMouseOld - xMouseNew),0,0);
                    //grid3D.setRotateY((xMouseOld - xMouseNew),0,0);
                }
            }
            xMouseOld = xMouseNew;
            yMouseOld = yMouseNew;
        });


        //Изменение окна
        root2.widthProperty().addListener((observableValue, number, t1) -> {
            scene.setWidth(root2.getWidth());
            scene.setHeight(root2.getHeight());
        });
        root2.heightProperty().addListener((observableValue, number, t1) -> {
            scene.setWidth(root2.getWidth());
            scene.setHeight(root2.getHeight());
        });
    }
}
