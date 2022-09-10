package com.vti;

import com.vti.entity.Department;
import com.vti.repository.DepartmentRepository;
import com.vti.utils.HibernateUtils;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        DepartmentRepository repository = new DepartmentRepository();

        // Create departments
        System.out.println("------------ Create departments ------------");
        repository.create(new Department("SQL"));
        repository.create(new Department("Java Basic"));
        repository.create(new Department("Frontend Basic"));
        repository.create(new Department("Java Advanced"));

        // Get all departments
        System.out.println("------------ Get all departments ------------");
        List<Department> departments = repository.getAll();
        for (Department department : departments) {
            System.out.println("department = " + department);
        }

        // Get department by id
        System.out.println("------------ Get department by id ------------");
        System.out.println("repository.getById(2) = " + repository.getById(2));

        // Update department
        System.out.println("------------ Update department ------------");
        repository.update(new Department(2, "New Java Basic"));

        // Delete department
        System.out.println("------------ Delete department ------------");
        repository.deleteById(1);

        // Get all departments
        System.out.println("------------ Get all departments ------------");
        for (Department department : repository.getAll()) {
            System.out.println("department = " + department);
        }

        HibernateUtils.closeFactory();
    }
}
