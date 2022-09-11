package com.vti.repository;

import com.vti.entity.Department;

import java.util.List;

public interface IDepartmentRepository {
    List<Department> getAll();

    Department getById(int id);

    Department getByName(String name);

    void create(Department department);

    void update(Department department);

    void deleteById(int id);

    boolean existsById(int id);

    boolean existsByName(String name);
}
