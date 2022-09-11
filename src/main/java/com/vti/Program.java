package com.vti;

import com.vti.entity.Group;
import com.vti.entity.Student;
import com.vti.repository.GroupRepository;
import com.vti.repository.StudentRepository;
import com.vti.utils.HibernateUtils;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        StudentRepository sRepository = new StudentRepository();
        GroupRepository gRepository = new GroupRepository();

        // Create groups
        System.out.println("------------ Create groups ------------");
        gRepository.create(new Group("SQL"));
        gRepository.create(new Group("Java Basic"));
        gRepository.create(new Group("Front end"));
        gRepository.create(new Group("Java Advanced"));

        // Create students
        System.out.println("------------ Create students ------------");
        sRepository.create(new Student("Nam", new Group(1)));
        sRepository.create(new Student("Hùng", new Group(2)));
        sRepository.create(new Student("Cường", new Group(3)));
        sRepository.create(new Student("Duy", new Group(4)));
        // sRepository.create(new Student("Hải", new Group(4)));

        // Get all groups
        System.out.println("------------ Get all groups ------------");
        List<Group> groups = gRepository.getAll();
        for (Group group : groups) {
            System.out.println("group = " + group);
        }

        // Get all students
        System.out.println("------------ Get all students ------------");
        List<Student> students = sRepository.getAll();
        for (Student student : students) {
            System.out.println("student = " + student);
        }

        HibernateUtils.closeFactory();
    }
}
