package com.vti.form;

import com.vti.entity.Type;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DepartmentCreateForm {
    private String name;
    private int totalMembers;
    private Type type;

    private List<Account> accounts;

    @Data
    @NoArgsConstructor
    public static class Account {
        private String username;
    }
}
