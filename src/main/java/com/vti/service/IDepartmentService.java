package com.vti.service;

import com.vti.entity.Department;

import java.util.List;

public interface IDepartmentService {
    List<Department> getAll();

    Department getById(int id);

    Department getByName(String name);

    void create(Department department);

    void update(Department department);

    void deleteById(int id);
}
