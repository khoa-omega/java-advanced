package com.vti.form;

import com.vti.entity.Account;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountCreateForm {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Account.Role role;
    private int departmentId;
}
