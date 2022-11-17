package com.vti;

import com.vti.entity.GroupStudent;
import com.vti.repository.GroupStudentRepository;
import com.vti.utils.HibernateUtils;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        GroupStudentRepository repository = new GroupStudentRepository();

        System.out.println("-------------------- CREATE --------------------");
        GroupStudent groupStudentA = new GroupStudent();
        groupStudentA.setStudentId(1);
        groupStudentA.setGroupId(1);
        repository.create(groupStudentA);

        System.out.println("-------------------- FIND ALL --------------------");
        List<GroupStudent> groupStudents = repository.findAll();
        for (GroupStudent groupStudent : groupStudents) {
            System.out.println("groupStudent = " + groupStudent);
        }

        HibernateUtils.closeFactory();
    }
}
