package com.vti.form;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountFilterForm {
    private String search;
    private Integer minId;
    private Integer maxId;
}
