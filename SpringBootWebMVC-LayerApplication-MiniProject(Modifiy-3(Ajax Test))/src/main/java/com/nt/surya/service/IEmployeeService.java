package com.nt.surya.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.surya.model.Employee;

public interface IEmployeeService {

	Integer saveEmployee(Employee e);
	
	void updateEmployee(Employee e);
	
	void deleteEmployee(Integer id);
	
	Employee getOneEmployee(Integer id);
	List<Employee> getAllEmployees();
	
	boolean isEmployeeExistByName(String ename);
	Page<Employee> getAllEmployees(Pageable pageable);
}
