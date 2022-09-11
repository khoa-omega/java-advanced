package com.vti.form;

import com.vti.entity.Department;

public class DepartmentUpdateForm {
	private String name;

	public DepartmentUpdateForm() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department toEntity(int id) {
		return new Department(id, name);
	}
}
