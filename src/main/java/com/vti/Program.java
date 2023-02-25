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

        System.out.println("count by id = " + repository.countById());

        System.out.println("-------------------- FIND ALL --------------------");

        List<Department> departments = repository.findAll();
        for (Department department : departments) {
            System.out.println("- department = " + department);
        }

        System.out.println("-------------------- FIND ALL USING DTO --------------------");

        List<DepartmentDTO> departmentDTOs = repository.findAllUsingDTO();
        for (DepartmentDTO departmentDTO : departmentDTOs) {
            System.out.println("- department dto = " + departmentDTO);
        }

        System.out.println("-------------------- FIND ALL WITH PAGING --------------------");

        for (Department department : repository.findAllWithPaging(2, 1)) {
            System.out.println("+ department paging = " + department);
        }

        System.out.println("-------------------- FIND BY ID --------------------");

        System.out.println("+ department (id = 2) = " + repository.findById(2));

        System.out.println("-------------------- UPDATE --------------------");

        departmentB.setName("Kinh doanh");
        repository.update(departmentB);

        System.out.println("-------------------- DELETE BY ID --------------------");

        repository.deleteById(1);

        System.out.println("-------------------- FIND ALL --------------------");

        for (Department department : repository.findAll()) {
            System.out.println("+ department = " + department);
        }

        HibernateUtils.closeFactory();
    }
}
