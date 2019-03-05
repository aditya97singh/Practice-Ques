package com.capgemini.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.beans.Employee;

@Service
public class EmployeeService {

	static List<Employee> el = new ArrayList<>();
	static {
		el.add(new Employee(1, "Aditya", 20000, "Aa"));
		el.add(new Employee(2, "shobhit", 20000, "Bb"));

	}

	public Employee findOne(int id) {
		for (Employee employee : el) {
			if (employee.getId() == (id)) {
				return employee;
			}
		}
		return null;
	}

	public Employee save(Employee employee) {
		if (findOne(employee.getId())!= employee) {
			el.add(employee);
			return employee;
		}
		return null;
	}
	
    public Employee update(int id)
    {   
    	Employee e=findOne(id);
    	if(e!=null)
    	{	e.setSalary(e.getSalary()+1000);
    	    return e;
    	}
    	return null;
    }  
    
    public List<Employee> delete(int id)
    {
    	Employee e=findOne(id);
    	if(e!=null)
    	{
    		el.remove(e);
    		return el;
    	}
    	return null;
    }
    
    public List<Employee> get()
    {
    	return el;
    }
}
