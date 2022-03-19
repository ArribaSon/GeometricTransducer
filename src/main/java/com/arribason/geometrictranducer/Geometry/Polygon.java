package com.arribason.geometrictranducer.Geometry;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.LinkedList;
import java.util.List;

public class Polygon extends GObject2D {

    private final List<Vertex2D> vertex2DList;
    private final List<Line> lineList;
    private final int n;
    private final Group group;

    public Polygon(Group group, Grid2D grid2D, int n, Color color) {
        this.group = group;
        this.n = n;
        vertex2DList = new LinkedList<>();
        lineList = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            vertex2DList.add(new Vertex2D(group, grid2D, color));
        }
        for (int i = 0; i < n - 1; i++) {
            lineList.add(new Line(vertex2DList.get(i).getX(), vertex2DList.get(i).getY(),
                    vertex2DList.get(i + 1).getX(), vertex2DList.get(i + 1).getY()));
            lineList.get(i).setStroke(color);
            lineList.get(i).setStrokeWidth(4);
            group.getChildren().add(lineList.get(i));
        }
        lineList.add(new Line(vertex2DList.get(n - 1).getX(), vertex2DList.get(0).getY(),
                vertex2DList.get(n - 1).getX(), vertex2DList.get(0).getY()));
        lineList.get(n - 1).setStroke(color);
        lineList.get(n - 1).setStrokeWidth(4);
        group.getChildren().add(lineList.get(n - 1));
    }

    @Override
    public void setTranslateX(int dx) {
        for (int i = 0; i < n; i++) {
            vertex2DList.get(i).setTranslateX(dx);
            lineList.get(i).setTranslateX(dx);
        }
    }

    @Override
    public void setTranslateY(int dy) {
        for (int i = 0; i < n; i++) {
            vertex2DList.get(i).setTranslateY(dy);
            lineList.get(i).setTranslateY(-dy);
        }
    }

    @Override
    public void reBuild() {
        for (int i = 0; i < n - 1; i++) {
            lineList.get(i).setStartX(vertex2DList.get(i).getX());
            lineList.get(i).setStartY(vertex2DList.get(i).getY());
            lineList.get(i).setEndX(vertex2DList.get(i + 1).getX());
            lineList.get(i).setEndY(vertex2DList.get(i + 1).getY());
        }
        lineList.get(n - 1).setStartX(vertex2DList.get(n - 1).getX());
        lineList.get(n - 1).setStartY(vertex2DList.get(n - 1).getY());
        lineList.get(n - 1).setEndX(vertex2DList.get(0).getX());
        lineList.get(n - 1).setEndY(vertex2DList.get(0).getY());
    }

    public void setVertexes(double[] x, double[] y) {
        for (int i = 0; i < n; i++) {
            vertex2DList.get(i).setX(x[i]);
            vertex2DList.get(i).setY(-y[i]);
        }
        reBuild();
    }

    public void delete() {
        for (int i = 0; i < n; i++) {
            vertex2DList.get(i).delete();
            group.getChildren().removeAll(lineList.get(i));
        }
    }

    public int getN(){
        return n;
    }

    public void getVertexes(double[] x, double[] y){
        for (int i = 0; i < n; i++) {
            x[i] = vertex2DList.get(i).getGridX();
            y[i] = -vertex2DList.get(i).getGridY();
        }
    }
}
