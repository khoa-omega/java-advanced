package com.vti.entity;

public class Circle extends Shape {
    private double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double perimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public double area() {
        return radius * radius * Math.PI;
    }
}
