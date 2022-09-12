package com.vti.form;

import com.vti.entity.Account;
import com.vti.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountCreateForm {
    private String username;
    private int departmentId;

    public Account toEntity() {
        return new Account(username, new Department(departmentId));
    }
}
