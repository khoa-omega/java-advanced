package com.vti.form;

import com.vti.entity.Department;
import com.vti.entity.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentCreateForm {
	private String name;
	private int totalMembers;
	private Type type;

	public Department toEntity() {
		return new Department(name, totalMembers, type);
	}
}
