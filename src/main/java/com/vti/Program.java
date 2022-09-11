package com.vti;

import com.vti.entity.Circle;
import com.vti.entity.Rectangle;
import com.vti.entity.Shape;

//  SOLID Principles
//  L: Liskov substitution principle
//  - Các subclasses có thể thay thế superclasses mà không làm thay đổi tính đúng đắn
public class Program {
    public static void main(String[] args) {
        showInfo(new Circle("Circle", 10.0));
        showInfo(new Rectangle("Rectangle", 10.0, 20.0));
    }

    private static void showInfo(Shape shape) {
        System.out.println("shape.perimeter() = " + shape.perimeter());
        System.out.println("shape.area() = " + shape.area());
    }
}
