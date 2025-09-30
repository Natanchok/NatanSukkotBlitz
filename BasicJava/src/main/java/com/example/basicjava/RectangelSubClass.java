package com.example.basicjava;

public class RectangelSubClass extends Shape_Challange13{

    private double length;
    private double width;

    public RectangelSubClass(double length, double width) {
        this.length = length;
        this.width = width;
    }
    @Override
    public double area() {
        return length * width;
    }

    public String name( ){
        return "Rectangle";
    }

    public double perimeter() {
        return 2 * (length + width);
    }
}
