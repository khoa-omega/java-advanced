package com.vti.service;

import com.vti.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDepartmentService {
    Page<Department> findAll(Pageable pageable);

    Department findById(int id);

    void save(Department department);

    void deleteById(int id);

    boolean existsById(int id);
}
