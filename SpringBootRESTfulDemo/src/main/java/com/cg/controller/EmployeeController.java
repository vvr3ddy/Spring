package com.cg.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Employee;

@RestController
@RequestMapping(value = "/employeeAPI")
public class EmployeeController {

	ArrayList<Employee> empList;

	public EmployeeController() {
		empList = new ArrayList<>();
		empList.add(new Employee(1, "John Doe", 27414, "Analyst"));
		empList.add(new Employee(2, "Jean Paul", 42580, "Sr. Analyst"));
		empList.add(new Employee(3, "Sam Smith", 65000, "Project Manager"));
		empList.add(new Employee(4, "Ravi", 27414, "Analyst"));
	}

	@GetMapping(value = "/empList")
	public List<Employee> getEmployeeList() {
		return empList;
	}

	@GetMapping(value = "/getById/{empId}")
	public Employee getByEmployeeId(@PathVariable int empId) {
		Employee emp = null;
		for (Employee e : empList) {
			if (e.getId() == empId) {
				emp = e;
			}
		}
		return emp;
	}

	@PostMapping(value = "/addEmployee")
	public ResponseEntity<Object> addEmployee(@RequestBody Employee emp) {
		empList.add(emp);
		return new ResponseEntity<>("Successfully Added", HttpStatus.OK);
	}

	@PostMapping(value = "/addEmployee2")
	public String addEmpl(@RequestBody Employee emp) {
		empList.add(emp);
		return "new employee added";
	}

	@DeleteMapping(value = "/delete/{empId}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable int empId) {
		boolean flag = false;
		for (Employee e : empList) {
			if (e.getId() == empId) {
				flag = true;
				empList.remove(e);

			} else {
				flag = false;
			}

		}
		if (flag)
			return new ResponseEntity<>("Deleted record successfully", HttpStatus.OK);
		else
			return new ResponseEntity<>("Unable to delete record", HttpStatus.NOT_FOUND);

	}

}
