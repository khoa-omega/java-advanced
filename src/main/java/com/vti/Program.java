package com.vti;

import com.vti.entity.Group;
import com.vti.repository.GroupRepository;
import com.vti.utils.HibernateUtils;

public class Program {
    public static void main(String[] args) {
        GroupRepository repository = new GroupRepository();
        repository.create(new Group("SQL"));
        repository.create(new Group("Java Basic"));
        repository.create(new Group("Frontend Basic"));
        repository.create(new Group("Java Advanced"));
        HibernateUtils.closeFactory();
    }
}
