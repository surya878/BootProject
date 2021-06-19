package com.nt.surya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.surya.model.Employee;
import com.nt.surya.service.IEmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private IEmployeeService service;

	// 1. show Register page
	/**
	 * If End user enters/register,GET type then we should display one Register page
	 * in browser
	 */

	@GetMapping("/register")
	public String showReg() {
		return "EmployeeRegister";
	}

	// 2. save() : Click From submit

	@PostMapping("/save")
	public String saveEmp(@ModelAttribute Employee employee, Model model) {
		Integer id = service.saveEmployee(employee);
		String mesage = "Employee '" + id + "' created!!";
		model.addAttribute("message", mesage);
		return "EmployeeRegister";
	}

	// 3.display all rows
	@GetMapping("/all")
	public String getAllEmps(Model model) {
		List<Employee> emps = service.getAllEmployees();
		model.addAttribute("list", emps);
		return "EmployeeData";
	}

	// 4.Delete by id

	// 5. show Data in Edit (by id)

	// 6. Update data

}
