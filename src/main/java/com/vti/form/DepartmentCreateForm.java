package com.vti.form;

import com.vti.entity.Department;

public class DepartmentCreateForm {
	private String name;

	public DepartmentCreateForm() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department toEntity() {
		return new Department(name);
	}
}
