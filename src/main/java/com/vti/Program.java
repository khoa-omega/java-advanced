package com.vti;

import com.vti.entity.Group;
import com.vti.entity.GroupStudent;
import com.vti.entity.GroupStudentPK;
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
        GroupStudentPK pkA = new GroupStudentPK();
        pkA.setStudentId(1);
        pkA.setGroupId(1);
        groupStudentA.setPk(pkA);
        groupStudentRepository.create(groupStudentA);

        GroupStudent groupStudentB = new GroupStudent();
        GroupStudentPK pkB = new GroupStudentPK();
        pkB.setStudentId(1);
        pkB.setGroupId(2);
        groupStudentB.setPk(pkB);
        groupStudentRepository.create(groupStudentB);

        GroupStudent groupStudentC = new GroupStudent();
        GroupStudentPK pkC = new GroupStudentPK();
        pkC.setStudentId(2);
        pkC.setGroupId(1);
        groupStudentC.setPk(pkC);
        groupStudentRepository.create(groupStudentC);

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
