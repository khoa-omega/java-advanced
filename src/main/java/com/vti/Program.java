package com.vti;

import com.vti.entity.Circle;
import com.vti.entity.Rectangle;
import com.vti.repository.ShapeRepository;
import com.vti.utils.HibernateUtils;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        ShapeRepository repository = new ShapeRepository();

        System.out.println("-------------------- CREATE --------------------");

        Circle circleA = new Circle();
        circleA.setName("Red circle");
        circleA.setRadius(5);
        repository.create(circleA);

        Circle circleB = new Circle();
        circleB.setName("Green circle");
        circleB.setRadius(10);
        repository.create(circleB);

        Rectangle rectangleA = new Rectangle();
        rectangleA.setName("Blue rectangle");
        rectangleA.setWidth(15);
        rectangleA.setHeight(20);
        repository.create(rectangleA);

        System.out.println("-------------------- FIND ALL --------------------");

        List<Circle> circles = repository.findAllCircles();
        for (Circle circle : circles) {
            System.out.println("- circle = " + circle);
        }

        List<Rectangle> rectangles = repository.findAllRectangles();
        for (Rectangle rectangle : rectangles) {
            System.out.println("+ rectangle = " + rectangle);
        }

        HibernateUtils.closeFactory();
    }
}
