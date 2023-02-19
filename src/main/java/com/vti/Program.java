package com.vti;

import com.vti.entity.GroupStudent;
import com.vti.entity.GroupStudentPK;
import com.vti.repository.GroupStudentRepository;
import com.vti.utils.HibernateUtils;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        GroupStudentRepository repository = new GroupStudentRepository();

        System.out.println("-------------------- CREATE --------------------");

        GroupStudentPK pk = new GroupStudentPK();
        pk.setStudentId(1);
        pk.setGroupId(1);

        GroupStudent groupStudentA = new GroupStudent();
        groupStudentA.setPk(pk);
        repository.create(groupStudentA);

        System.out.println("-------------------- FIND ALL --------------------");

        List<GroupStudent> groupStudents = repository.findAll();
        for (GroupStudent groupStudent : groupStudents) {
            System.out.println("groupStudent = " + groupStudent);
        }

        HibernateUtils.closeFactory();
    }
}
