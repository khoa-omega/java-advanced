package com.vti.form;

import com.vti.entity.Type;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DepartmentUpdateForm {
    private int id;
    private String name;
    private int totalMembers;
    private Type type;
}
