package com.vti;

import java.util.Arrays;
import java.util.List;

public class Department {
    private int id;
    private String name;

    public Department() {
    }

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public List<Department> getAll() {
        return Arrays.asList(
                new Department(1, "HR"),
                new Department(2, "Sale"),
                new Department(3, "Marketing")
        );
    }

    public void showAll() {
        for (Department department : getAll()) {
            System.out.println("department = " + department);
        }
    }
}
