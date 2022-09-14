package com.vti.service;

import com.vti.entity.Department;
import com.vti.form.DepartmentCreateForm;
import com.vti.form.DepartmentFilterForm;
import com.vti.form.DepartmentUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDepartmentService {
    Page<Department> findAll(Pageable pageable, DepartmentFilterForm form);

    Department findById(int id);

    void create(DepartmentCreateForm form);

    void update(DepartmentUpdateForm form);

    void deleteById(int id);

    boolean existsById(int id);
}
