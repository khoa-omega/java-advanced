package com.vti;

import com.vti.entity.Group;
import com.vti.entity.Student;
import com.vti.repository.GroupRepository;
import com.vti.utils.HibernateUtils;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        GroupRepository repository = new GroupRepository();

        System.out.println("-------------------- CREATE --------------------");

        Student studentA = new Student();
        studentA.setName("Nguyễn Văn Khoa");

        Student studentB = new Student();
        studentB.setName("Nguyễn Ngọc Minh Trang");

        Group groupA = new Group();
        groupA.setName("iOS");
        groupA.setStudent(studentA);

        Group groupB = new Group();
        groupB.setName("Android");
        groupB.setStudent(studentB);

        repository.create(groupA);
        repository.create(groupB);

        System.out.println("-------------------- FIND ALL --------------------");

        List<Group> groups = repository.findAll();
        for (Group group : groups) {
            System.out.println("- group = " + group.getName());
            System.out.println("+ student = " + group.getStudent().getName());
        }

        HibernateUtils.closeFactory();
    }
}
