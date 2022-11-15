package com.vti;

import com.vti.entity.Department;
import com.vti.repository.DepartmentRepository;
import com.vti.utils.HibernateUtils;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        DepartmentRepository repository = new DepartmentRepository();

        System.out.println("-------------------- CREATE --------------------");
        Department departmentA = new Department();
        departmentA.setName("Giám đốc");
        repository.create(departmentA);

        Department departmentB = new Department();
        departmentB.setName("Kinh doanh");
        repository.create(departmentB);

        System.out.println("-------------------- FIND BY ID --------------------");
        Department departmentById = repository.findById(2);
        System.out.println("departmentById = " + departmentById);

        System.out.println("-------------------- UPDATE --------------------");
        departmentA.setName("Bảo vệ");
        repository.update(departmentA);

        System.out.println("-------------------- FIND BY NAME --------------------");
        Department departmentByName = repository.findByName("Bảo vệ");
        System.out.println("departmentByName = " + departmentByName);

        System.out.println("-------------------- DELETE BY ID --------------------");
        repository.deleteById(1);

        System.out.println("-------------------- FIND ALL --------------------");
        List<Department> departments = repository.findAll();
        for (Department department : departments) {
            System.out.println("department = " + department);
        }

        HibernateUtils.closeFactory();
    }
}
