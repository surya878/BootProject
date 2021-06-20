package com.nt.surya.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	private void commonDataFetch(Model model) {
		List<Employee> emps = service.getAllEmployees();
		model.addAttribute("list", emps);
	}

	// 4.Delete by id

	public String deleteById(

			@RequestParam Integer id, Model model) {

		// delete recod by id
		service.deleteEmployee(id);

		// send message latest to ui
		model.addAttribute("message", "Employee '" + id + "' Deleted!");

		// also load latest data
		commonDataFetch(model);
		return "EmployeeData";
	}

	// 5. show Data in Edit (by id)

	/***
	 * On click Edit Link , read id and load object from DB if exist goto Edit page,
	 * else redirect to all page
	 */

	@GetMapping("/edit")
	public String showEdit(@RequestParam Integer id, Model model) {
		String page = null;
		// try to load data from DB
		Optional<Employee> opt = service.getOneEmployee(id);
		// if data exist
		if (opt.isPresent()) {
			model.addAttribute("employee", opt.get());
			page = "EmployeeEdit";
		} else { // no data exist
			page = "redirect:all"; // goto data page
		}
		return page;
	}

	
	// 6. Update data
	/**
	 * On Click Update button, read Form data as ModelAttribute Update in DB and
	 * send success message to UI. Also load latest data
	 */
	@PostMapping("/update")
	public String doUpdate(@ModelAttribute Employee employee, Model model) {
		service.updateEmployee(employee);
		// send message to ui
		model.addAttribute("message", "Employee '" + employee.getEmpId() + "' Updated!!");

		// also load latest data
		commonDataFetch(model);
		return "EmployeeData";

	}
}
