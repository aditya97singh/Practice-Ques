package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.beans.Employee;
import com.capgemini.service.EmployeeService;

@RestController
	public class MyController {

		@Autowired
		private EmployeeService employeeService;

		@GetMapping("/employee/{id}")
		public Employee getEmployeeById(@PathVariable int id) {
			return employeeService.findOne(id);
		}
		
		@GetMapping("/employee/{id}/{name}/{salary}/{designation}")
		public Employee save(@PathVariable int id,@PathVariable String name,@PathVariable int salary,@PathVariable String designation)
		{
			Employee employee=new Employee(id,name,salary,designation);
			return employeeService.save(employee);
		}
		
		@RequestMapping(value="/deleteEmployee/{id}", method=RequestMethod.DELETE)
		public List<Employee> delete(@PathVariable int id)
		{
			return employeeService.delete(id);
		}
				
		@RequestMapping(value="employee", method=RequestMethod.GET) 
		public List<Employee> get()
		{
			return employeeService.get();
		}

}
