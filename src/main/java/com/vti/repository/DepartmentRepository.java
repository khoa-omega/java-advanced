package com.vti.repository;

import com.vti.entity.Department;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class DepartmentRepository {
    public List<Department> findAllUsingSQL() {
        try (Session session = HibernateUtils.openSession()) {
            return session
                    .createNativeQuery("SELECT * FROM department", Department.class)
                    .getResultList();
        }
    }

    public void create(Department department) {
        try (Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            session.createNativeQuery("INSERT INTO department(name) VALUES (:name)")
                    .setParameter("name", department.getName())
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }
}
