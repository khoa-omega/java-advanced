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
        departmentB.setName("Bảo vệ");
        repository.create(departmentB);

        System.out.println("-------------------- FIND BY NAME LIKE --------------------");

        List<Department> departments = repository.findByNameLike("B");
        for (Department department : departments) {
            System.out.println("- department = " + department);
        }

        HibernateUtils.closeFactory();
    }
}
