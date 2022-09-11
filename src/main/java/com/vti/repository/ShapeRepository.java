package com.vti.repository;

import com.vti.entity.Circle;
import com.vti.entity.Rectangle;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ShapeRepository {
    public List<Circle> getAllCircles() {
        try (Session session = HibernateUtils.openSession()) {
            Query<Circle> query = session.createQuery("FROM Circle", Circle.class);
            return query.getResultList();
        }
    }

    public List<Rectangle> getAllRectangles() {
        try (Session session = HibernateUtils.openSession()) {
            Query<Rectangle> query = session.createQuery("FROM Rectangle", Rectangle.class);
            return query.getResultList();
        }
    }

    public void createCircle(Circle circle) {
        try (Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            session.persist(circle);
            session.getTransaction().commit();
        }
    }

    public void createRectangle(Rectangle rectangle) {
        try (Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            session.persist(rectangle);
            session.getTransaction().commit();
        }
    }
}
