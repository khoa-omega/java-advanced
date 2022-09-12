package com.vti.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class DepartmentDTO {
    private String name;
    private String type;
    private LocalDate createdDate;
    private List<AccountDTO> accounts;

    @Data
    @NoArgsConstructor
    static class AccountDTO {
        private int id;
        private String username;
    }
}
