package com.vti.form;

import com.vti.validation.DepartmentNameNotExists;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
public class DepartmentCreateForm {
    @NotBlank(message = "{DepartmentForm.name.NotBlank}")
    @Length(max = 50, message = "{DepartmentForm.name.Length}")
    @DepartmentNameNotExists
    private String name;

    @PositiveOrZero(message = "Department total members must be greater than or equal 0.")
    private Integer totalMembers;

    @Pattern(
            regexp = "DEVELOPER|TESTER|SCRUM_MASTER|PROJECT_MANAGER",
            message = "Department type must be DEVELOPER, TESTER, SCRUM_MASTER or PROJECT_MANAGER."
    )
    private String type;

    private List<@Valid Account> accounts;

    @Getter
    @Setter
    public static class Account {
        @NotBlank(message = "Account username must NOT be blank.")
        @Length(max = 50, message = "Account username's length is max 50 characters.")
        private String username;
        private String password;
        private String firstName;
        private String lastName;
        private String role;
    }
}
