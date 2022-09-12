package com.vti.form;

import com.vti.entity.Account;
import com.vti.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountUpdateForm {
    private String username;
    private int departmentId;

    public Account toEntity(int id) {
        return new Account(id, username, new Department(departmentId));
    }
}
