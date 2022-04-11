package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.employees.Employees;
import com.example.demo.repositories.EmpRepository;

@RestController("/")
public class EmpController {

	
	@Autowired
	private EmpRepository emprepository;
	
	/* Storing the employee data into database*/
	@PostMapping("/Employee")
	public String addEmployee(@RequestParam String empFirstName,
							  @RequestParam String empLastName,
							  @RequestParam String empAddress)
	{
		Employees emp = new Employees();
		
		emp.setEmpFirstName(empFirstName);
		emp.setEmpLastName(empLastName);
		emp.setEmpAddress(empAddress);
		
		emprepository.save(emp);
		return "Entered emplyee's id is: " + emp.empId;
	}
	
	/*Display employee data by taking employee id*/
	@GetMapping("/Employee")
	public String getEmployee(@RequestParam("empId") int empId)
	{
		
		Employees employee = emprepository.findEmployeeByempId(empId);
		
		return " Employee name is  " + employee.empFirstName + " " + employee.empLastName +
				" Employee Address is " + employee.empAddress;
	}
	
	
}
