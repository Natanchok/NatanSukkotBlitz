package com.example.basicjava;

public class TriangleSubClass extends Shape_Challange13{

    private double base;
    private double height;

    public TriangleSubClass(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }

    public String name( ){
        return "Triangle";
    }

    public double perimeter() {
        return 3 * base;
    }
}
