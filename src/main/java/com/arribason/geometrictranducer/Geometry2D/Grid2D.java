package com.arribason.geometrictranducer.Geometry2D;

import javafx.scene.Group;
import javafx.scene.SubScene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Grid2D extends GObject2D {
    private final Line axisX;
    private final Line axisY;
    private final SubScene subScene;


    Grid2D(SubScene subScene, Group group) {
        //Инициализация
        this.subScene = subScene;

        //Оси
        axisX = new Line(0, 0, 0, subScene.getHeight());
        axisX.setStrokeWidth(5);
        axisX.setStroke(Color.GREEN);
        axisY = new Line(0, 0, subScene.getWidth(), 0);
        axisY.setStrokeWidth(5);
        axisY.setStroke(Color.RED);

        //Отрисовка
        group.getChildren().addAll(axisX, axisY);
    }

    @Override
    public void reBuild() {
        axisX.setEndY(subScene.getHeight());
        axisY.setEndX(subScene.getWidth());
    }

    @Override
    public void setTranslateY(int dy){
        axisY.setTranslateY(-dy);
    }

    @Override
    public void setTranslateX(int dx){
        axisX.setTranslateX(dx);
    }

    public int getH() {
        return 50;
    }
}
