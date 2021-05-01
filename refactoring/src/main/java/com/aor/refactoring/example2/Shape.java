package com.aor.refactoring.example2;

public class Shape {
    private double x;
    private double y;
    private double width;  // ONLY FOR RECTANGLES
    private double height; // ONLY FOR RECTANGLES
    private double radius; // ONLY FOR CIRCLES

    public Shape() {
    }

    public double getArea(){
        return 0.0;
    }

    public double getPerimeter() {
        return 0.0;
    }

    public void draw(GraphicFramework graphics) {
    }
}
