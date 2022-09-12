package com.vti.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class AccountDTO {
	@NonNull
	private int id;

	@NonNull
	private String username;

	@NonNull
	private String departmentName;
}
