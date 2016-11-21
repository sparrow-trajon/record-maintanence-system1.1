package com.trajon.sparrow.services;

import java.util.List;
import com.trajon.sparrow.bean.Employee;
import com.trajon.sparrow.dao.EmployeeDAO;


public class EmployeeService 
{

	Employee bean;
	EmployeeDAO empDao= new EmployeeDAO(); 
	public void createEmployeeList( List<Employee> employeelist)
	{
		employeelist.addAll(empDao.getEmployeeList());

	}

}
