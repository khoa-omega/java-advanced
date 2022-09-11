package com.vti.repository;

import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository implements IDepartmentRepository {
	@Override
	public List<String> getAllDepartments() {
		List<String> departments = new ArrayList<>();
		departments.add("HR");
		departments.add("Sale");
		departments.add("Marketing");
		return departments;
	}

	@Override
	public void createDepartment() {
		// TODO ...
	}
}
