package com.vti.controller;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.form.DepartmentCreateForm;
import com.vti.form.DepartmentFilterForm;
import com.vti.form.DepartmentUpdateForm;
import com.vti.service.IDepartmentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    @Autowired
    private IDepartmentService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping()
    public Page<DepartmentDTO> findAll(Pageable pageable, DepartmentFilterForm form) {
        Page<Department> departments = service.findAll(pageable, form);

        List<DepartmentDTO> departmentDTOs = mapper.map(
                departments.getContent(),
                new TypeToken<List<DepartmentDTO>>() {}.getType()
        );

        return new PageImpl<>(departmentDTOs, pageable, departments.getTotalElements());
    }

    @GetMapping(value = "/{id}")
    public DepartmentDTO findById(@PathVariable(name = "id") int id) {
        Department entity = service.findById(id);
        return mapper.map(entity, DepartmentDTO.class);
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
