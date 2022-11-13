package com.vti.form;

import com.vti.entity.Department;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.time.LocalDateTime;

@Getter
@Setter
public class DepartmentFilterForm {
    private String search;

    private Department.Type type;
    private Integer minCreatedYear;

    @DateTimeFormat(iso = ISO.DATE_TIME)
    private LocalDateTime createdAt;

    @DateTimeFormat(iso = ISO.DATE_TIME)
    private LocalDateTime minCreatedAt;

    @DateTimeFormat(iso = ISO.DATE_TIME)
    private LocalDateTime maxCreatedAt;

    private Long minTotalAccounts;
    private Long maxTotalAccounts;
}
