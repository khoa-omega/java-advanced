package com.vti.controller;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.form.DepartmentCreateForm;
import com.vti.form.DepartmentFilterForm;
import com.vti.form.DepartmentUpdateForm;
import com.vti.service.IDepartmentService;
import com.vti.validation.DepartmentIdExists;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.vti.entity.Department_.CREATED_AT;
import static org.springframework.data.domain.Sort.Direction.DESC;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Validated
@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    @Autowired
    private IDepartmentService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public Page<DepartmentDTO> findAll(
            @SortDefault(value = CREATED_AT, direction = DESC) Pageable pageable,
            DepartmentFilterForm form
    ) {
        Page<Department> page = service.findAll(pageable, form);
        List<Department> departments = page.getContent();
        List<DepartmentDTO> dtos = mapper.map(departments, new TypeToken<List<DepartmentDTO>>() {}.getType());
        for (DepartmentDTO dto : dtos) {
            dto.add(linkTo(methodOn(DepartmentController.class).findById(dto.getId())).withSelfRel());
            for (DepartmentDTO.AccountDTO account : dto.getAccounts()) {
                account.add(linkTo(methodOn(AccountController.class).findById(account.getId())).withSelfRel());
            }
        }
        return new PageImpl<>(dtos, pageable, page.getTotalElements());
    }

    @GetMapping("/{id}")
    public DepartmentDTO findById(@PathVariable("id") Integer id) {
        Department department = service.findById(id);
        DepartmentDTO dto = mapper.map(department, DepartmentDTO.class);
        return dto.add(linkTo(methodOn(DepartmentController.class).findById(id)).withSelfRel());
    }

    @PostMapping
    public void create(@Valid @RequestBody DepartmentCreateForm form) {
        service.create(form);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") @DepartmentIdExists Integer id, @RequestBody DepartmentUpdateForm form) {
        form.setId(id);
        service.update(form);
    }

    @DeleteMapping
    public void deleteAll(@RequestBody List<Integer> ids) {
        service.deleteAllById(ids);
    }
}
