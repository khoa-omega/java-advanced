package com.vti.repository;

import com.vti.entity.Department;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentRepository implements IDepartmentRepository {
    @Override
    public List<Department> getAll() {
        try (Session session = HibernateUtils.openSession()) {
            String hql = "FROM Department";
            Query<Department> query = session.createQuery(hql, Department.class);
            return query.getResultList();
        }
    }

    @Override
    public Department getById(int id) {
        try (Session session = HibernateUtils.openSession()) {
            return session.get(Department.class, id);
        }
    }

    @Override
    public Department getByName(String name) {
        try (Session session = HibernateUtils.openSession()) {
            String hql = "FROM Department WHERE name = :name";
            Query<Department> query = session.createQuery(hql, Department.class);
            query.setParameter("name", name);
            return query.uniqueResult();
        }
    }

    @Override
    public void create(Department department) {
        try (Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            session.persist(department);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Department department) {
        try (Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            session.merge(department);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(int id) {
        try (Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            Department old = session.get(Department.class, id);
            session.remove(old);
            session.getTransaction().commit();
        }
    }

    @Override
    public boolean existsById(int id) {
        return getById(id) != null;
    }

    @Override
    public boolean existsByName(String name) {
        return getByName(name) != null;
    }
}
