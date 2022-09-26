package com.vti.controller;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.form.DepartmentCreateForm;
import com.vti.form.DepartmentFilterForm;
import com.vti.form.DepartmentUpdateForm;
import com.vti.service.IDepartmentService;
import com.vti.validation.DepartmentIDExists;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Validated
@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    @Autowired
    private IDepartmentService service;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private MessageSource messageSource;

    @GetMapping()
    public Page<DepartmentDTO> findAll(Pageable pageable, DepartmentFilterForm form) {
        Page<Department> departments = service.findAll(pageable, form);

        List<DepartmentDTO> departmentDTOs = mapper.map(
                departments.getContent(),
                new TypeToken<List<DepartmentDTO>>() {}.getType()
        );

        for (DepartmentDTO departmentDTO : departmentDTOs) {
            for (DepartmentDTO.AccountDTO accountDTO : departmentDTO.getAccounts()) {
                accountDTO.add(
                        WebMvcLinkBuilder.linkTo(
                                WebMvcLinkBuilder
                                        .methodOn(AccountController.class)
                                        .findById(accountDTO.getId())
                        ).withSelfRel()
                );
            }
            departmentDTO.add(
                    WebMvcLinkBuilder.linkTo(
                            WebMvcLinkBuilder
                                    .methodOn(DepartmentController.class)
                                    .findById(departmentDTO.getId())
                    ).withSelfRel()
            );
        }

        return new PageImpl<>(departmentDTOs, pageable, departments.getTotalElements());
    }

    @GetMapping(value = "/{id}")
    public DepartmentDTO findById(@PathVariable(name = "id") @DepartmentIDExists int id) {
        Department entity = service.findById(id);
        return mapper.map(entity, DepartmentDTO.class).add(
                WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder
                                .methodOn(DepartmentController.class)
                                .findById(id)
                ).withSelfRel()
        );
    }

    @PostMapping
    public void create(@Valid @RequestBody DepartmentCreateForm form) {
        service.create(form);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") @DepartmentIDExists int id, @RequestBody DepartmentUpdateForm form) {
        form.setId(id);
        service.update(form);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id) {
        service.deleteById(id);
    }

    @GetMapping("/messages")
    public String testMessages(@RequestParam(value = "key") String key){
        return messageSource.getMessage(
                key,
                null,
                "Default message",
                LocaleContextHolder.getLocale());
    }

    @GetMapping("/messages/vi")
    public String testMessagesVi(@RequestParam(value = "key") String key){
        return messageSource.getMessage(
                key,
                null,
                "Default message",
                new Locale("vi", "VN"));
    }

    @GetMapping("/messages/en")
    public String testMessagesEn(@RequestParam(value = "key") String key){
        return messageSource.getMessage(
                key,
                null,
                "Default message",
                Locale.US);
    }

    @GetMapping("/exception")
    public void testException() {
        throw new EntityNotFoundException("... Exception information");
    }
}
