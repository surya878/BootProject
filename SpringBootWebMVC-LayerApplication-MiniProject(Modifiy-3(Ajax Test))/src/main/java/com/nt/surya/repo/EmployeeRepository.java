package com.nt.surya.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.surya.model.Employee;

public interface EmployeeRepository extends JpaRepository
								<Employee, Integer> {

	
	
	//SQL: select count(ename) from emptab where ename=?
	
	@Query("SELECT COUNT(empName) FROM Employee WHERE empName=:ename")
	
	public Integer getCountOfEmpName(String ename);
}
