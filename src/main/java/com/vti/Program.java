package com.vti;

import com.vti.entity.Group;
import com.vti.entity.Student;
import com.vti.repository.GroupRepository;
import com.vti.utils.HibernateUtils;

import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        GroupRepository repository = new GroupRepository();

        System.out.println("-------------------- CREATE --------------------");

        Student studentA = new Student();
        studentA.setName("Nguyễn Văn Khoa");

        Student studentB = new Student();
        studentB.setName("Nguyễn Ngọc Minh Trang");

        Group groupA = new Group();
        groupA.setName("Android");
        groupA.setStudents(Arrays.asList(studentA, studentB));

        repository.create(groupA);

        System.out.println("-------------------- FIND ALL --------------------");

        for (Group group : repository.findAll()) {
            System.out.println("- group = " + group.getName());
            for (Student student : group.getStudents()) {
                System.out.println("+ student = " + student.getName());
            }
        }

        HibernateUtils.closeFactory();
    }
}
