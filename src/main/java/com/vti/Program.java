package com.vti;

import com.vti.entity.GroupStudent;
import com.vti.entity.GroupStudentPK;
import com.vti.repository.GroupStudentRepository;
import com.vti.utils.HibernateUtils;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        GroupStudentRepository repository = new GroupStudentRepository();

        // Create group student
        repository.create(new GroupStudent(new GroupStudentPK(1, 1)));
        repository.create(new GroupStudent(new GroupStudentPK(1, 2)));
        repository.create(new GroupStudent(new GroupStudentPK(2, 1)));
        repository.create(new GroupStudent(new GroupStudentPK(2, 2)));
        // repository.create(new GroupStudent(new GroupStudentPK(2, 2)));

        // Get all group student
        System.out.println("------------ Get all students ------------");
        List<GroupStudent> groupStudents = repository.getAll();
        for (GroupStudent groupStudent : groupStudents) {
            System.out.println("groupStudent = " + groupStudent);
        }

        HibernateUtils.closeFactory();
    }
}
