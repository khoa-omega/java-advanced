package com.vti.form;

import com.vti.validation.AccountUsernameNotExists;
import com.vti.validation.DepartmentNameNotExists;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Data
@NoArgsConstructor
public class DepartmentCreateForm {
    @NotBlank(message = "Department name must NOT be blank")
    @Length(max = 50, message = "Department name's length is max 50 characters")
    @DepartmentNameNotExists
    private String name;

    @NotNull(message = "Department total members must NOT be null")
    @PositiveOrZero(message = "Department total members must be greater than or equal 0")
    private int totalMembers;

    @Pattern(
            regexp = "DEVELOPER|TESTER|SCRUM_MASTER|PROJECT_MANAGER",
            message = "Department type must be DEVELOPER, TESTER, SCRUM_MASTER or PROJECT_MANAGER"
    )
    private String type;

    @NotEmpty(message = "Account must be not empty.")
    private List<@Valid Account> accounts;

    @Data
    @NoArgsConstructor
    public static class Account {
        @AccountUsernameNotExists
        private String username;
    }
}
