package com.vti.dto;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AccountDTO {
	@NonNull
	private String username;

	@NonNull
	private String departmentName;
}
