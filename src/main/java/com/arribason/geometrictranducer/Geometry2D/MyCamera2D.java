package com.arribason.geometrictranducer.Geometry2D;

import java.util.LinkedList;
import java.util.List;

public class MyCamera2D {

    private int x = 0;
    private int y = 0;
    private final List<GObject2D> gObject2DList;

    MyCamera2D() {

        gObject2DList = new LinkedList<>();
    }

    public void setTranslateX(int dx) {
        x = dx;
        for (GObject2D elem : gObject2DList) {
            elem.setTranslateX(-dx);
        }
    }

    public void setTranslateY(int dy) {
        y = -dy;
        for (GObject2D elem : gObject2DList) {
            elem.setTranslateY(dy);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return -y;
    }

    public void add(GObject2D object2D) {
        gObject2DList.add(object2D);
    }
}
