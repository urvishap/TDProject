package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.employees.Employees;

@Repository
public interface EmpRepository extends JpaRepository<Employees, Integer> {

	/*method calling employee by id*/
	public Employees findEmployeeByempId(Integer empId);
	
	
}
