package com.vti.form;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class DepartmentFilterForm {
    private String search;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate minCreatedDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate maxCreatedDate;

    private Integer minYear;
}
