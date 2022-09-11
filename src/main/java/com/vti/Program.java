package com.vti;

import com.vti.entity.Group;
import com.vti.entity.GroupStudent;
import com.vti.entity.Student;
import com.vti.repository.GroupRepository;
import com.vti.repository.GroupStudentRepository;
import com.vti.repository.StudentRepository;
import com.vti.utils.HibernateUtils;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        StudentRepository sRepository = new StudentRepository();
        GroupRepository gRepository = new GroupRepository();
        GroupStudentRepository gsRepository = new GroupStudentRepository();

        // Create groups
        System.out.println("------------ Create groups ------------");
        gRepository.create(new Group("SQL"));
        gRepository.create(new Group("Java Basic"));
        gRepository.create(new Group("Front end"));
        gRepository.create(new Group("Java Advanced"));

        // Create students
        System.out.println("------------ Create students ------------");
        sRepository.create(new Student("Nam"));
        sRepository.create(new Student("Hùng"));
        sRepository.create(new Student("Cường"));
        sRepository.create(new Student("Duy"));

        // Create group student
        System.out.println("------------ Create group student ------------");
        gsRepository.create(new GroupStudent(new Group(1), new Student(1)));
        gsRepository.create(new GroupStudent(new Group(1), new Student(2)));
        gsRepository.create(new GroupStudent(new Group(2), new Student(1)));
        gsRepository.create(new GroupStudent(new Group(2), new Student(2)));
        gsRepository.create(new GroupStudent(new Group(3), new Student(3)));
        gsRepository.create(new GroupStudent(new Group(4), new Student(4)));

        // Get all groups
        System.out.println("------------ Get all groups ------------");
        List<Group> groups = gRepository.getAll();
        for (Group group : groups) {
            System.out.println("group = " + group.getName());
            for (GroupStudent groupStudent : group.getGroupStudents()) {
                System.out.println("student = " + groupStudent.getStudent().getName());
                System.out.println("join date = " + groupStudent.getJoinedDate());
            }
        }

        // Get all students
        System.out.println("------------ Get all students ------------");
        List<Student> students = sRepository.getAll();
        for (Student student : students) {
            System.out.println("student = " + student.getName());
            for (GroupStudent groupStudent : student.getGroupStudents()) {
                System.out.println("group = " + groupStudent.getGroup().getName());
                System.out.println("joined date = " + groupStudent.getJoinedDate());
            }
        }

        HibernateUtils.closeFactory();
    }
}
