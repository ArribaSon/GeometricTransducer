package com.arribason.geometrictranducer.Geometry3D;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Vertex3D extends GObject3D{

    private int newX = 0;
    private int newY = 0;
    private int newZ = 0;
    private double gridX = 0;
    private double gridY = 0;
    private double gridZ = 0;

    private final Grid3D grid3D;
    private final Circle circle;
    private final Group group;

    public Vertex3D(Group group, Grid3D grid3D, Color color){
        this.group = group;
        this.grid3D = grid3D;
        circle = new Circle(0, 0, 5, color);
        group.getChildren().add(circle);
    }

    @Override
    public void setTranslateX(int dx){
        newX = (int) (dx + newX);
        reBuild();
    }
    @Override
    public void setTranslateY(int dy){
        newY = (int) (dy + newY);
        reBuild();
    }
    @Override
    public void setTranslateZ(int dz){
        newZ = (int) (-dz + newZ);
        reBuild();
    }
    @Override
    public void setRotateX(double a, int y, int z){
        newY = newY - y;
        newZ = newZ - z;
        newY = (int) (Math.cos(a * Math.PI / 180) * newY + Math.sin(a * Math.PI / 180) * newZ);
        newZ = (int) (-Math.sin(a * Math.PI / 180) * newY + Math.cos(a * Math.PI / 180) * newZ);
        newY = (int) (newY + y + (newY * 0));
        newZ = (int) (newZ + z + (newZ * 0));
        reBuild();
    }
    @Override
    public void setRotateY(double a, int x, int z){
        newX = newX - x;
        newZ = newZ - z;
        newX = (int) (Math.cos(a * Math.PI / 180) * newX + Math.sin(a * Math.PI / 180) * newZ);
        newZ = (int) (-Math.sin(a * Math.PI / 180) * newX + Math.cos(a * Math.PI / 180) * newZ);
        newX = (int) (newX + x + (newX * 0));
        newZ = (int) (newZ + z + (newZ * 0));
        reBuild();
    }
    @Override
    public void setRotateZ(double a, int x, int y){
        newX = newX - x;
        newY = newY - y;
        newX = (int) (Math.cos(a * Math.PI / 180) * newX + Math.sin(a * Math.PI / 180) * newY);
        newY = (int) (-Math.sin(a * Math.PI / 180) * newX + Math.cos(a * Math.PI / 180) * newY);
        newX = (int) (newX + x + (newX * 0));
        newY = (int) (newY + y + (newY * 0));
        reBuild();
    }
    @Override
    public void reBuild(){
        circle.setTranslateX(newX);
        circle.setTranslateY(newZ);
    }
    @Override
    public void delete(){
        group.getChildren().removeAll(circle);
    }

    public double getGridX(){
        return (double) newX / grid3D.getH();
    }
    public double getGridY(){
        return (double) newY / grid3D.getH();
    }
    public double getGridZ(){
        return -(double) newZ / grid3D.getH();
    }
    public int getNewX() {
        return newX;
    }
    public int getNewY() {
        return newY;
    }
    public int getNewZ() {
        return newZ;
    }
}
