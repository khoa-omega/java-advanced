package com.vti;

import com.vti.entity.Group;
import com.vti.entity.Student;
import com.vti.repository.StudentRepository;
import com.vti.utils.HibernateUtils;

import java.util.List;

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
        studentA.setGroup(groupA);

        Student studentB = new Student();
        studentB.setName("Nguyễn Ngọc Minh Trang");
        studentB.setGroup(groupB);

        repository.create(studentA);
        repository.create(studentB);

        System.out.println("-------------------- FIND ALL --------------------");

        List<Student> students = repository.findAll();
        for (Student student : students) {
            System.out.println("- student = " + student.getName());
            System.out.println("+ group = " + student.getGroup().getName());
        }

        HibernateUtils.closeFactory();
    }
}
