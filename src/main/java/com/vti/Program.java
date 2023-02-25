package com.vti;

import com.vti.entity.Group;
import com.vti.entity.Student;
import com.vti.repository.StudentRepository;
import com.vti.utils.HibernateUtils;

import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        StudentRepository repository = new StudentRepository();

        System.out.println("-------------------- CREATE --------------------");

        Group groupA = new Group();
        groupA.setName("iOS");

        Group groupB = new Group();
        groupB.setName("Android");

        Student studentA = new Student();
        studentA.setName("Nguyễn Văn Khoa");

        Student studentB = new Student();
        studentB.setName("Nguyễn Ngọc Minh Trang");

        studentA.setGroups(Arrays.asList(groupA, groupB));
        studentB.setGroups(Arrays.asList(groupA, groupB));

        repository.create(studentA);
        repository.update(studentB);

        System.out.println("-------------------- FIND ALL --------------------");

        for (Student student : repository.findAll()) {
            System.out.println("- student = " + student.getName());
            for (Group group : student.getGroups()) {
                System.out.println("+ group = " + group.getName());
            }
        }

        HibernateUtils.closeFactory();
    }
}
