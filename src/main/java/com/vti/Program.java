package com.vti;

import com.vti.entity.Group;
import com.vti.entity.GroupStudent;
import com.vti.entity.Student;
import com.vti.repository.GroupRepository;
import com.vti.repository.GroupStudentRepository;
import com.vti.repository.StudentRepository;
import com.vti.utils.HibernateUtils;

public class Program {
    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepository();
        GroupRepository groupRepository = new GroupRepository();
        GroupStudentRepository groupStudentRepository = new GroupStudentRepository();

        System.out.println("-------------------- CREATE --------------------");

        Group groupA = new Group();
        groupA.setName("iOS");
        groupRepository.create(groupA);

        Group groupB = new Group();
        groupB.setName("Android");
        groupRepository.create(groupB);

        Student studentA = new Student();
        studentA.setName("Nguyễn Văn Khoa");
        studentRepository.create(studentA);

        Student studentB = new Student();
        studentB.setName("Nguyễn Ngọc Minh Trang");
        studentRepository.create(studentB);

        GroupStudent groupStudentA = new GroupStudent();
        groupStudentA.setStudent(studentA);
        groupStudentA.setGroup(groupA);
        groupStudentRepository.update(groupStudentA);

        GroupStudent groupStudentB = new GroupStudent();
        groupStudentB.setStudent(studentA);
        groupStudentB.setGroup(groupB);
        groupStudentRepository.update(groupStudentB);

        GroupStudent groupStudentC = new GroupStudent();
        groupStudentC.setStudent(studentB);
        groupStudentC.setGroup(groupA);
        groupStudentRepository.update(groupStudentC);

        System.out.println("-------------------- FIND ALL --------------------");

        for (Student student : studentRepository.findAll()) {
            System.out.println("- student = " + student.getName());
            for (GroupStudent groupStudent : student.getGroupStudents()) {
                System.out.println("+ group = " + groupStudent.getGroup().getName());
            }
        }


        HibernateUtils.closeFactory();
    }
}
