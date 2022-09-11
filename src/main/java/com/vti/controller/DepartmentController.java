package com.vti.controller;

import com.vti.entity.Department;
import com.vti.form.DepartmentCreateForm;
import com.vti.form.DepartmentUpdateForm;
import com.vti.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    @Autowired
    private IDepartmentService service;

    @GetMapping
    public Page<Department> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @PostMapping
    public void create(@RequestBody DepartmentCreateForm form) {
        service.save(form.toEntity());
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody DepartmentUpdateForm form) {
        service.save(form.toEntity(id));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id) {
        service.deleteById(id);
    }
}
