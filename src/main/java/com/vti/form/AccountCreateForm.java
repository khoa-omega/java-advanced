package com.vti.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountCreateForm {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String role;
    private Integer departmentId;
}
