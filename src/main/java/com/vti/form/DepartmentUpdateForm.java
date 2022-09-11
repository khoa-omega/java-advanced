package com.vti.form;

import com.vti.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentUpdateForm {
	private String name;
	private int totalMembers;

	public Department toEntity(int id) {
		return new Department(id, name, totalMembers);
	}
}
