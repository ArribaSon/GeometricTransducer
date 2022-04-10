package com.arribason.geometrictranducer.Geometry3D;

public abstract class GObject3D {

    public void setTranslateX(int dx){}

    public void setTranslateY(int dy){}

    public void setTranslateZ(int dz){}

    public void setRotateX(double a, int y, int z){}

    public void setRotateY(double a, int x, int z){}

    public void setRotateZ(double a, int x, int y){}

    public void reBuild(){}

    public void delete(){}
}
