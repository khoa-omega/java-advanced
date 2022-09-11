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

        // Get all departments using SQL
        System.out.println("------------ Get all departments using SQL ------------");
        List<Department> departments = repository.getAllUsingSQL();
        for (Department department : departments) {
            System.out.println("department = " + department);
        }

        HibernateUtils.closeFactory();
    }
}
