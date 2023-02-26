package com.vti;

import com.vti.dto.DepartmentDTO;
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

        System.out.println("-------------------- COUNT BY ID --------------------");

        System.out.println("- count by id = " + repository.countById());

        System.out.println("-------------------- FIND ALL --------------------");

        for (Department department : repository.findAll()) {
            System.out.println("+ department = " + department);
        }

        System.out.println("-------------------- FIND ALL USING DTO --------------------");

        for (DepartmentDTO dto : repository.findAllUsingDTO()) {
            System.out.println("- department dto = " + dto);
        }

        System.out.println("-------------------- FIND ALL WITH PAGING --------------------");

        for (Department department : repository.findAllWithPaging(2, 1)) {
            System.out.println("+ department (page = 2, size = 1) = " + department);
        }

        System.out.println("-------------------- FIND BY ID --------------------");

        Department departmentC = repository.findById(2);
        System.out.println("- department (id = 2) = " + departmentC);

        System.out.println("-------------------- UPDATE --------------------");

        departmentC.setName("Kinh doanh");
        repository.update(departmentC);

        System.out.println("-------------------- DELETE BY ID --------------------");

        repository.deleteById(1);

        System.out.println("-------------------- FIND ALL --------------------");

        for (Department department : repository.findAll()) {
            System.out.println("+ department = " + department);
        }

        HibernateUtils.closeFactory();
    }
}
