package com.vti.repository;

import com.vti.dto.DepartmentDTO;
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

    public List<Department> findAllWithPaging(int page, int size) {
        try (Session session = HibernateUtils.openSession()) {
            return session
                    .createQuery("FROM Department", Department.class)
                    .setFirstResult((page - 1) * size)
                    .setMaxResults(size)
                    .getResultList();
        }
    }

    public List<DepartmentDTO> findAllUsingDTO() {
        try (Session session = HibernateUtils.openSession()) {
            String hql = "SELECT new com.vti.dto.DepartmentDTO(name) FROM Department";
            return session
                    .createQuery(hql, DepartmentDTO.class)
                    .getResultList();
        }
    }

    public List<Department> findAll() {
        try (Session session = HibernateUtils.openSession()) {
            return session
                    .createQuery("FROM Department", Department.class)
                    .getResultList();
        }
    }

    public Department findById(int id) {
        try (Session session = HibernateUtils.openSession()) {
            return session
                    .createQuery("FROM Department WHERE id = :id", Department.class)
                    .setParameter("id", id)
                    .uniqueResult();
        }
    }

    public Department findByName(String name) {
        try (Session session = HibernateUtils.openSession()) {
            return session
                    .createQuery("FROM Department WHERE name = :name", Department.class)
                    .setParameter("name", name)
                    .uniqueResult();
        }
    }

    public void create(Department department) {
        try (Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            session.persist(department);
            session.getTransaction().commit();
        }
    }

    public void update(Department department) {
        try (Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            session.createQuery("UPDATE Department SET name = :name WHERE id = :id", Department.class)
                    .setParameter("name", department.getName())
                    .setParameter("id", department.getId())
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }

    public void deleteById(int id) {
        try (Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM Department WHERE id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }

    public boolean existsById(int id) {
        return findById(id) != null;
    }

    public boolean existsByName(String name) {
        return findByName(name) != null;
    }

    public long countById() {
        try (Session session = HibernateUtils.openSession()) {
            return session
                    .createQuery("SELECT COUNT(id) FROM Department", Long.class)
                    .uniqueResult();
        }
    }
}
