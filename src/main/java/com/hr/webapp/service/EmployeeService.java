package com.hr.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.webapp.model.Employee;
import com.hr.webapp.repository.EmployeeProxy;

import lombok.Data;

@Data
@Service
public class EmployeeService {

	@Autowired
	private EmployeeProxy employeeProxy;

	public Iterable<Employee> getEmployees() {
		return employeeProxy.getEmployees();
	}

	public Employee getEmployee(final long id) {
		return employeeProxy.getEmployeeById(id);
	}

	public Employee saveEmployee(Employee e) {
		Employee savedEmployee;

		e.setLastName(e.getLastName().toUpperCase());

		if (e.getId() == null) {
			savedEmployee = employeeProxy.createEmployee(e);
		} else {
			savedEmployee = employeeProxy.updateEmployee(e);
		}

		return savedEmployee;
	}

	public void deleteEmployee(final long id) {
		employeeProxy.deleteEmployee(id);
	}
}
