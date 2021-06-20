package com.nt.surya.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.surya.model.Employee;

public interface EmployeeRepository extends JpaRepository
								<Employee, Integer> {

}
