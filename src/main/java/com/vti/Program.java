package com.vti;

import com.vti.entity.Group;
import com.vti.repository.GroupRepository;
import com.vti.utils.HibernateUtils;

public class Program {
    public static void main(String[] args) {
        GroupRepository repository = new GroupRepository();

        System.out.println("-------------------- CREATE --------------------");
        Group group = new Group();
        group.setName("Java Advanced");
        repository.create(group);

        System.out.println("Please check database to see new group.");
        HibernateUtils.closeFactory();
    }
}
