package com.vti;

import com.vti.entity.Group;
import com.vti.entity.GroupStudent;
import com.vti.entity.Student;
import com.vti.repository.GroupStudentRepository;
import com.vti.utils.HibernateUtils;

public class Program {
    public static void main(String[] args) {
        GroupStudentRepository repository = new GroupStudentRepository();

        System.out.println("-------------------- CREATE --------------------");

        Group groupA = new Group();
        groupA.setName("iOS");

        Group groupB = new Group();
        groupB.setName("Android");

        Student studentA = new Student();
        studentA.setName("Nguyễn Văn Khoa");

        Student studentB = new Student();
        studentB.setName("Nguyễn Ngọc Minh Trang");

        GroupStudent groupStudentA = new GroupStudent();
        groupStudentA.setStudent(studentA);
        groupStudentA.setGroup(groupA);
        repository.create(groupStudentA);

        GroupStudent groupStudentB = new GroupStudent();
        groupStudentB.setStudent(studentA);
        groupStudentB.setGroup(groupB);
        repository.update(groupStudentB);

        GroupStudent groupStudentC = new GroupStudent();
        groupStudentC.setStudent(studentB);
        groupStudentC.setGroup(groupA);
        repository.update(groupStudentC);

        System.out.println("-------------------- FIND ALL --------------------");

        for (GroupStudent groupStudent : repository.findAll()) {
            System.out.println("- student = " + groupStudent.getStudent().getName());
            System.out.println("+ group = " + groupStudent.getGroup().getName());
        }

        HibernateUtils.closeFactory();
    }
}
