package com.vti.service;

import com.vti.entity.Department;

import java.util.List;

public interface IDepartmentService {
    List<Department> findAll();

    Department findById(int id);

    Department findByName(String name);

    List<Department> searchByName(String search);

    void save(Department department);

    void deleteById(int id);

    void deleteByName(String name);

    boolean existsById(int id);
}
