package com.arribason.geometrictranducer.Geometry;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Vertex2D extends GObject2D {

    private int newX = 0;
    private int newY = 0;
    private double gridX = 0;
    private double gridY = 0;

    private final Grid2D grid2D;
    private final Circle circle;
    private final Group group;

    public Vertex2D(Group group, Grid2D grid2D, Color color) {
        this.group = group;
        this.grid2D = grid2D;
        circle = new Circle(0, 0, 5, color);
        //circle.setA
        group.getChildren().add(circle);
    }

    @Override
    public void setTranslateX(int dx) {
        newX = (int) (dx + gridX * grid2D.getH());
        reBuild();
    }

    @Override
    public void setTranslateY(int dy) {
        newY = (int) (-dy + gridY * grid2D.getH());
        reBuild();
    }

    @Override
    public void reBuild() {
        circle.setTranslateX(newX);
        circle.setTranslateY(newY);
    }

    public int getX() {
        return newX;
    }

    public int getY() {
        return newY;
    }

    public void setX(double dx) {
        gridX = dx;
        setTranslateX(0);
    }

    public void setY(double dy) {
        gridY = dy;
        setTranslateY(0);
    }

    public void delete() {
        group.getChildren().removeAll(circle);
    }

    public double getGridX(){
        return  gridX;
    }

    public double getGridY(){
        return  gridY;
    }
}
