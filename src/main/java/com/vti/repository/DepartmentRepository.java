package com.vti.repository;

import com.vti.entity.Department;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class DepartmentRepository {
    public List<Department> getAllBySearching(String search) {
        try (Session session = HibernateUtils.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Department> query = builder.createQuery(Department.class);
            Root<Department> student = query.from(Department.class);
            query.select(student).where(builder.like(student.get("name"), "%" + search + "%"));
            return session.createQuery(query).getResultList();
        }
    }

    public void create(Department department) {
        try (Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            session.persist(department);
            session.getTransaction().commit();
        }
    }
}
