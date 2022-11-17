package com.vti;

import com.vti.entity.Group;
import com.vti.entity.Student;
import com.vti.repository.GroupRepository;
import com.vti.utils.HibernateUtils;

import java.util.Arrays;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        GroupRepository gRepository = new GroupRepository();

        System.out.println("-------------------- CREATE --------------------");
        Group groupA = new Group();
        groupA.setName("Java Advanced");

        Student studentA = new Student();
        studentA.setName("Khoa");

        Student studentB = new Student();
        studentB.setName("Minh Trang");

        studentA.setGroup(groupA);
        studentB.setGroup(groupA);
        groupA.setStudents(Arrays.asList(studentA, studentB));

        gRepository.create(groupA);

        System.out.println("-------------------- FIND ALL --------------------");
        List<Group> groups = gRepository.findAll();
        for (Group group : groups) {
            System.out.println("group = " + group.getName());
            List<Student> students = group.getStudents();
            for (Student student : students) {
                System.out.println("student = " + student.getName());
            }
        }

        HibernateUtils.closeFactory();
    }
}
