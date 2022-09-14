package com.vti.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class DepartmentDTO extends RepresentationModel<DepartmentDTO> {
    private String name;

    private String type;

	@JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate createdDate;

    private List<AccountDTO> accounts;

    @Data
    @NoArgsConstructor
    static class AccountDTO {
		@JsonProperty("accountId")
        private int id;

        private String username;
    }
}
