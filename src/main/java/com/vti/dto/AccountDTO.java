package com.vti.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
public class AccountDTO extends RepresentationModel<AccountDTO> {
    private Integer id;
    private String role;
    private String username;
    private String fullName;
    private String departmentName;
}
