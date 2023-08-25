package com.hr.webapp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.hr.webapp.CustomProperties;
import com.hr.webapp.model.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EmployeeProxy {

	@Autowired
	private CustomProperties props;

	public Iterable<Employee> getEmployees() {
		String baseApiUrl = props.getApiUrl();
		String getEmployeesUrl = baseApiUrl + "/employees";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Iterable<Employee>> response = restTemplate.exchange(getEmployeesUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<Iterable<Employee>>() {
				});

		log.debug("Get Employees call " + response.getStatusCode().toString());

		return response.getBody();
	}

	public Employee getEmployeeById(Long id) {
		String baseApiUrl = props.getApiUrl();
		String getEmployeeByIdUrl = baseApiUrl + "/employees/" + id;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Employee> response = restTemplate.exchange(getEmployeeByIdUrl, HttpMethod.GET, null,
				Employee.class);

		log.debug("Get Employee By Id call " + response.getStatusCode().toString());

		return response.getBody();
	}

	public Employee createEmployee(Employee e) {
		String baseApiUrl = props.getApiUrl();
		String createEmployeeUrl = baseApiUrl + "/employees/create";

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Employee> request = new HttpEntity<Employee>(e);
		ResponseEntity<Employee> response = restTemplate.exchange(createEmployeeUrl, HttpMethod.POST, request,
				Employee.class);

		log.debug("Post Create Employees call " + response.getStatusCode().toString());

		return response.getBody();
	}

	public Employee updateEmployee(Employee e) {
		String baseApiUrl = props.getApiUrl();
		String updateEmployeeUrl = baseApiUrl + "/employees/update/" + e.getId();

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Employee> request = new HttpEntity<Employee>(e);
		ResponseEntity<Employee> response = restTemplate.exchange(updateEmployeeUrl, HttpMethod.PUT, request,
				Employee.class);

		log.debug("Put Update Employees call " + response.getStatusCode().toString());

		return response.getBody();
	}

	public void deleteEmployee(Long id) {
		String baseApiUrl = props.getApiUrl();
		String removeEmployeeUrl = baseApiUrl + "/employees/remove/" + id;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Void> response = restTemplate.exchange(removeEmployeeUrl, HttpMethod.DELETE, null, Void.class);

		log.debug("Delete Remove Employees call " + response.getStatusCode().toString());
	}
}
