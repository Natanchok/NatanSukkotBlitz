package com.example.basicjava;

public class CircleSubClass extends Shape_Challange13{
    private double radius;
    public CircleSubClass(double radius) {
        this.radius = radius;
    }
    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    public String name( ){
        return "Circle";
    }
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}
