package com.vti.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProfileDTO {
    private int id;
    private String fullName;
    private String role;
    private String departmentName;
}
