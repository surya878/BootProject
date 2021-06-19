package com.nt.surya.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.surya.model.Employee;
import com.nt.surya.repo.EmployeeRepository;
import com.nt.surya.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository repo; 
	
	
	public Integer saveEmployee(Employee e) {
		//Local variable Type interface (DataType is decideed by Java Compiler)
		
		var esal=e.getEmpSal();
		var hra=esal*20/100.0;
		var ta=esal*10/100.0;
		
		//set data back to object
		e.setEmpHra(hra);
		e.setEmpTa(ta);
		
		//save object
		var id=repo.save(e).getEmpId();
		
		return id;
	}

	public void updateEmployee(Employee e) {
		//if given id exist in db then update
		
		if(repo.existsById(e.getEmpId())) {
			var esal=e.getEmpSal();
			var hra=esal*20/100.0;
			var ta=esal*10/100.0;
			
			//set data back to object
			e.setEmpHra(hra);
			e.setEmpTa(ta);
			repo.save(e);
		}

	}

	
	public void deleteEmployee(Integer id) {
		
		repo.deleteById(id);

	}

	@Override
	public Optional<Employee> getOneEmployee(Integer id) {
		
		return repo.findById(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> emps=repo.findAll();
		
		return emps.stream()
				.sorted(
	// (e1,e2)->e1.getEmpId().compareTo(e2.getEmpId())  //ASC
		
		(e1,e2)->e2.getEmpId().compareTo(e1.getEmpId())  //DESC
								)
				.collect(Collectors.toList());
	}

}
