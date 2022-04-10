package com.arribason.geometrictranducer.Geometry3D;

import javafx.scene.Group;
import javafx.scene.SubScene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Grid3D extends GObject3D{
    private final Vertex3D startAxisX;
    private final Vertex3D endAxisX;
    private final Vertex3D startAxisY;
    private final Vertex3D endAxisY;
    private final Vertex3D startAxisZ;
    private final Vertex3D endAxisZ;
    private final Line axisX;
    private final Line axisY;
    private final Line axisZ;
    private final SubScene subScene;

    private int newX = 0;
    private int newY = 0;
    private int newZ = 0;

    public Grid3D(SubScene subScene, Group group){
        //Инициализация
        this.subScene = subScene;
        //Оси
        startAxisX = new Vertex3D(group,this ,Color.RED);
        startAxisX.setTranslateX(-100);
        endAxisX = new Vertex3D(group,this ,Color.RED);
        endAxisX.setTranslateX(100);
        axisX = new Line(startAxisX.getNewX(), startAxisX.getNewZ(), endAxisX.getNewX(), endAxisX.getNewZ());
        axisX.setStrokeWidth(5);
        axisX.setStroke(Color.RED);

        startAxisY = new Vertex3D(group,this ,Color.GREEN);
        startAxisY.setTranslateY(-100);
        endAxisY = new Vertex3D(group,this ,Color.GREEN);
        endAxisY.setTranslateY(100);
        axisY = new Line(startAxisY.getNewX(), startAxisY.getNewZ(), endAxisY.getNewX(), endAxisY.getNewZ());
        axisY.setStrokeWidth(5);
        axisY.setStroke(Color.GREEN);

        startAxisZ = new Vertex3D(group,this ,Color.BLUE);
        startAxisZ.setTranslateZ(-100);
        endAxisZ = new Vertex3D(group,this ,Color.BLUE);
        endAxisZ.setTranslateZ(100);
        axisZ = new Line(startAxisZ.getNewX(), startAxisZ.getNewZ(), endAxisZ.getNewX(), endAxisZ.getNewZ());
        axisZ.setStrokeWidth(5);
        axisZ.setStroke(Color.BLUE);

        //Отрисовка
        group.getChildren().addAll(axisX, axisY, axisZ);
    }

    @Override
    public void setTranslateX(int dx){
        newX = newX + dx;

        startAxisX.setTranslateX(dx);
        endAxisX.setTranslateX(dx);
        axisX.setStartX(startAxisX.getNewX());
        axisX.setStartY(startAxisX.getNewZ());
        axisX.setEndX(endAxisX.getNewX());
        axisX.setEndY(endAxisX.getNewZ());

        startAxisY.setTranslateX(dx);
        endAxisY.setTranslateX(dx);
        axisY.setStartX(startAxisY.getNewX());
        axisY.setStartY(startAxisY.getNewZ());
        axisY.setEndX(endAxisY.getNewX());
        axisY.setEndY(endAxisY.getNewZ());

        startAxisZ.setTranslateX(dx);
        endAxisZ.setTranslateX(dx);
        axisZ.setStartX(startAxisZ.getNewX());
        axisZ.setStartY(startAxisZ.getNewZ());
        axisZ.setEndX(endAxisZ.getNewX());
        axisZ.setEndY(endAxisZ.getNewZ());
    }
    @Override
    public void setTranslateY(int dy){
        newY = newY + dy;

        startAxisX.setTranslateY(dy);
        endAxisX.setTranslateY(dy);
        axisX.setStartX(startAxisX.getNewX());
        axisX.setStartY(startAxisX.getNewZ());
        axisX.setEndX(endAxisX.getNewX());
        axisX.setEndY(endAxisX.getNewZ());

        startAxisY.setTranslateY(dy);
        endAxisY.setTranslateY(dy);
        axisY.setStartX(startAxisY.getNewX());
        axisY.setStartY(startAxisY.getNewZ());
        axisY.setEndX(endAxisY.getNewX());
        axisY.setEndY(endAxisY.getNewZ());

        startAxisZ.setTranslateY(dy);
        endAxisZ.setTranslateY(dy);
        axisZ.setStartX(startAxisZ.getNewX());
        axisZ.setStartY(startAxisZ.getNewZ());
        axisZ.setEndX(endAxisZ.getNewX());
        axisZ.setEndY(endAxisZ.getNewZ());
    }
    @Override
    public void setTranslateZ(int dz){
        newZ = newZ + dz;

        startAxisX.setTranslateZ(dz);
        endAxisX.setTranslateZ(dz);
        axisX.setStartX(startAxisX.getNewX());
        axisX.setStartY(startAxisX.getNewZ());
        axisX.setEndX(endAxisX.getNewX());
        axisX.setEndY(endAxisX.getNewZ());

        startAxisY.setTranslateZ(dz);
        endAxisY.setTranslateZ(dz);
        axisY.setStartX(startAxisY.getNewX());
        axisY.setStartY(startAxisY.getNewZ());
        axisY.setEndX(endAxisY.getNewX());
        axisY.setEndY(endAxisY.getNewZ());

        startAxisZ.setTranslateZ(dz);
        endAxisZ.setTranslateZ(dz);
        axisZ.setStartX(startAxisZ.getNewX());
        axisZ.setStartY(startAxisZ.getNewZ());
        axisZ.setEndX(endAxisZ.getNewX());
        axisZ.setEndY(endAxisZ.getNewZ());
    }
    @Override
    public void setRotateX(double a, int y, int z){
        startAxisX.setRotateX(a, newY + y, -(newZ + z));
        endAxisX.setRotateX(a, newY + y, -(newZ + z));
        axisX.setStartX(startAxisX.getNewX());
        axisX.setStartY(startAxisX.getNewZ());
        axisX.setEndX(endAxisX.getNewX());
        axisX.setEndY(endAxisX.getNewZ());

        startAxisY.setRotateX(a, newY + y, -(newZ + z));
        endAxisY.setRotateX(a, newY + y, -(newZ + z));
        axisY.setStartX(startAxisY.getNewX());
        axisY.setStartY(startAxisY.getNewZ());
        axisY.setEndX(endAxisY.getNewX());
        axisY.setEndY(endAxisY.getNewZ());

        startAxisZ.setRotateX(a, newY + y, -(newZ + z));
        endAxisZ.setRotateX(a, newY + y, -(newZ + z));
        axisZ.setStartX(startAxisZ.getNewX());
        axisZ.setStartY(startAxisZ.getNewZ());
        axisZ.setEndX(endAxisZ.getNewX());
        axisZ.setEndY(endAxisZ.getNewZ());
    }
    @Override
    public void setRotateY(double a, int x, int z){
        startAxisX.setRotateY(a, newX + x, -(newZ + z));
        endAxisX.setRotateY(a, newX + x, -(newZ + z));
        axisX.setStartX(startAxisX.getNewX());
        axisX.setStartY(startAxisX.getNewZ());
        axisX.setEndX(endAxisX.getNewX());
        axisX.setEndY(endAxisX.getNewZ());

        startAxisY.setRotateY(a, newX + x, -(newZ + z));
        endAxisY.setRotateY(a, newX + x, -(newZ + z));
        axisY.setStartX(startAxisY.getNewX());
        axisY.setStartY(startAxisY.getNewZ());
        axisY.setEndX(endAxisY.getNewX());
        axisY.setEndY(endAxisY.getNewZ());

        startAxisZ.setRotateY(a, newX + x, -(newZ + z));
        endAxisZ.setRotateY(a, newX + x, -(newZ + z));
        axisZ.setStartX(startAxisZ.getNewX());
        axisZ.setStartY(startAxisZ.getNewZ());
        axisZ.setEndX(endAxisZ.getNewX());
        axisZ.setEndY(endAxisZ.getNewZ());
    }
    @Override
    public void setRotateZ(double a, int x, int y){
        startAxisX.setRotateZ(a, newX + x, newY + y);
        endAxisX.setRotateZ(a, newX + x, newY + y);
        axisX.setStartX(startAxisX.getNewX());
        axisX.setStartY(startAxisX.getNewZ());
        axisX.setEndX(endAxisX.getNewX());
        axisX.setEndY(endAxisX.getNewZ());

        startAxisY.setRotateZ(a, newX + x, newY + y);
        endAxisY.setRotateZ(a, newX + x, newY + y);
        axisY.setStartX(startAxisY.getNewX());
        axisY.setStartY(startAxisY.getNewZ());
        axisY.setEndX(endAxisY.getNewX());
        axisY.setEndY(endAxisY.getNewZ());

        startAxisZ.setRotateZ(a, newX + x, newY + y);
        endAxisZ.setRotateZ(a, newX + x, newY + y);
        axisZ.setStartX(startAxisZ.getNewX());
        axisZ.setStartY(startAxisZ.getNewZ());
        axisZ.setEndX(endAxisZ.getNewX());
        axisZ.setEndY(endAxisZ.getNewZ());
    }
    @Override
    public void reBuild(){}
    @Override
    public void delete(){}

    public int getH() {
        return 50;
    }
}
