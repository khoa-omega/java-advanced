package com.vti;

import com.vti.entity.Student;
import com.vti.entity.Student.Gender;
import com.vti.repository.StudentRepository;
import com.vti.utils.HibernateUtils;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        StudentRepository repository = new StudentRepository();

        System.out.println("-------------------- CREATE --------------------");

        Student studentA = new Student();
        studentA.setName("Nguyễn Văn Khoa");
        studentA.setGender(Gender.MALE);
        repository.create(studentA);

        Student studentB = new Student();
        studentB.setName("Nguyễn Ngọc Minh Trang");
        studentB.setGender(Gender.FEMALE);
        repository.create(studentB);

        System.out.println("-------------------- FIND ALL --------------------");

        List<Student> students = repository.findAll();
        for (Student student : students) {
            System.out.println("student = " + student);
        }

        HibernateUtils.closeFactory();
    }
}
