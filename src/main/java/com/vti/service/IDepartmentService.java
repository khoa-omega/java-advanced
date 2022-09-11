package com.vti.service;

import com.vti.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDepartmentService {
    Page<Department> findAll(Pageable pageable);

    Department findById(int id);

    Department findByName(String name);

    Page<Department> searchByName(String search, Pageable pageable);

    void save(Department department);

    void deleteById(int id);

    void deleteByName(String name);

    boolean existsById(int id);
}
