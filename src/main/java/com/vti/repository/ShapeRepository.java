package com.vti.repository;

import com.vti.entity.Circle;
import com.vti.entity.Rectangle;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class ShapeRepository {
    public List<Circle> findAllCircles() {
        try (Session session = HibernateUtils.openSession()) {
            return session
                    .createQuery("FROM Circle", Circle.class)
                    .getResultList();
        }
    }

    public List<Rectangle> findAllRectangles() {
        try (Session session = HibernateUtils.openSession()) {
            return session
                    .createQuery("FROM Rectangle", Rectangle.class)
                    .getResultList();
        }
    }

    public void create(Object object) {
        try (Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            session.persist(object);
            session.getTransaction().commit();
        }
    }
}
