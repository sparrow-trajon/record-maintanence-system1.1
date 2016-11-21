package com.trajon.sparrow.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.trajon.sparrow.bean.Employee;
import com.trajon.sparrow.log.LoggerWrap;
import com.trajon.sparrow.services.DataService;
import com.trajon.sparrow.services.EmployeeService;
import com.trajon.sparrow.services.FileService;


public class Controller 
{
	List<Employee> list=new ArrayList<>();

	EmployeeService employeeService=new EmployeeService();

	FileService fileService= new FileService();

	DataService dataService= new DataService();

	public Controller() 
	{
		LoggerWrap log=new LoggerWrap();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		log.info("execution starts at"+ timeStamp );
	}

	public void saveRawData(String filename)
	{
		fileService.createFile(filename);
		employeeService.createEmployeeList(list);
		fileService.populateFile(list, filename, "--------------------------NewData----------------------");

	}

	public void saveNonDuplocateData(String sourceFilename, String destinationFile)
	{
		List<Employee> beansList=fileService.readFile(sourceFilename);
		List<Employee> filterList=dataService.getNonDuplicateList(beansList);
		fileService.createFile(destinationFile);
		fileService.populateFile(filterList, destinationFile, "-------------------NON DUPLICATE DATA----------");
		dataService.displayOverwrittenData(beansList, filterList);
		dataService.getSortedIds(filterList);
		dataService.displayData(filterList, "target file Data");
	}
}
