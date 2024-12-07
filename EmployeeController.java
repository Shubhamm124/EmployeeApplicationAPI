package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// Get all employees
	@GetMapping
	public String getAllEmployees(Model model) {
		List<Employee> employees = employeeService.getAllEmployees();
		model.addAttribute("employees", employees);
		return "employee-list";
	}

	// Get employee by ID
	@GetMapping("/{id}")
	public String getEmployeeById(@PathVariable Long id, Model model) {
		Optional<Employee> employee = employeeService.getEmployeeById(id);
		employee.ifPresent(emp -> model.addAttribute("employee", emp));
		return employee.isPresent() ? "employee-detail" : "redirect:/employees";
	}

	// Create a new employee (show form)
	@GetMapping("/create")
	public String showCreateForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "employee-form";
	}

	// Create a new employee (save)
	@PostMapping
	public String createEmployee(@ModelAttribute Employee employee) {
		employeeService.createEmployee(employee);
		return "redirect:/employees";
	}

	// Edit employee (show form)
	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable Long id, Model model) {
		Optional<Employee> employee = employeeService.getEmployeeById(id);
		employee.ifPresent(emp -> model.addAttribute("employee", emp));
		return employee.isPresent() ? "employee-form" : "redirect:/employees";
	}

	// Edit employee (update)
	@PostMapping("/{id}")
	public String updateEmployee(@PathVariable Long id, @ModelAttribute Employee employee) {
		employeeService.updateEmployee(id, employee);
		return "redirect:/employees";
	}

	// Delete employee (confirmation page)
	@GetMapping("/delete/{id}")
	public String deleteEmployeeConfirmation(@PathVariable Long id, Model model) {
		Optional<Employee> employee = employeeService.getEmployeeById(id);
		employee.ifPresent(emp -> model.addAttribute("employee", emp));
		return employee.isPresent() ? "employee-delete" : "redirect:/employees";
	}

	// Delete employee
	@PostMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.createEmployee(id);
		return "redirect:/employees";
	}
}
