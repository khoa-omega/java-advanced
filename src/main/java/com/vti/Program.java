package com.vti;

import com.vti.entity.Circle;
import com.vti.entity.Rectangle;
import com.vti.repository.ShapeRepository;
import com.vti.utils.HibernateUtils;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        ShapeRepository repository = new ShapeRepository();

        // Create circles
        repository.createCircle(new Circle(1, "Circle", 10));
        repository.createCircle(new Circle(2, "Circle", 20));
        repository.createCircle(new Circle(3, "Circle", 30));

        // Create rectangles
        repository.createRectangle(new Rectangle(4, "Rectangle", 10, 10));
        repository.createRectangle(new Rectangle(5, "Rectangle", 20, 20));
        repository.createRectangle(new Rectangle(6, "Rectangle", 30, 30));

        // Show all circles
        List<Circle> circles = repository.getAllCircles();
        for (Circle circle : circles) {
            System.out.println("circle = " + circle);
        }

        // Show all rectangles
        List<Rectangle> rectangles = repository.getAllRectangles();
        for (Rectangle rectangle : rectangles) {
            System.out.println("rectangle = " + rectangle);
        }

        HibernateUtils.closeFactory();
    }
}
