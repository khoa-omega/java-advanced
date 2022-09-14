package com.vti.form;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountCreateForm {
    private String username;
    private int departmentId;
}
