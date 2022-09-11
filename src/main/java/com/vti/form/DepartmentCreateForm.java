package com.vti.form;

import com.vti.entity.Department;

public class DepartmentCreateForm {
	private String name;
	private int totalMembers;

	public DepartmentCreateForm() {
	}

	public DepartmentCreateForm(String name, int totalMembers) {
		this.name = name;
		this.totalMembers = totalMembers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalMembers() {
		return totalMembers;
	}

	public void setTotalMembers(int totalMembers) {
		this.totalMembers = totalMembers;
	}

	public Department toEntity() {
		return new Department(name, totalMembers);
	}
}
