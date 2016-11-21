package com.trajon.sparrow.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.trajon.sparrow.bean.Employee;
import com.trajon.sparrow.exceptions.EmptyList;
import com.trajon.sparrow.log.LoggerWrap;


public class DataService
{

	LoggerWrap logger= new LoggerWrap();

	public void displayData(List<Employee> emplist)
	{
		if(emplist.isEmpty())
		{
			logger.info("Oops..List is empty");
			return;
		}
		else
		{
			System.out.println("-------------------displaying the data------");

			emplist.forEach((action)->{System.out.println(action.getId()+"    " +action.getName()+"    "
					+action.getGender()+"    " +action.getEmailAddress()+"    "+action.getName()   );});	
		}

	}

	public void displayData(List<Employee> emplist, String message)
	{
		if(emplist.isEmpty())
		{
			logger.info("Oops..List is empty");
			return;
		}
		else
		{
			System.out.println("-------------------displaying the  "+  message+"-------------");

			emplist.forEach((action)->{System.out.println(action.getId()+"    " +action.getName()+"    "
					+action.getGender()+"    " +action.getEmailAddress()+"    "+action.getName()   );});	
		}

	}

	public List<Employee> getNonDuplicateList(List<Employee> empList)
	{
		Map<Long, Employee> map=new HashMap<>();
		List<Employee> employeesList=new ArrayList<>();
		if(empList.isEmpty())
		{
			logger.error("Error is : Empty List ",new EmptyList("list is empty"));

		}
		else
		{
			for(Employee action:empList)
			{
				map.put(Long.valueOf((long)(action.getId())), action);
			}
			map.forEach((k,v)->employeesList.add(v));
		}

		return (null==employeesList?Collections.emptyList():employeesList);


	}

	public void displayOverwrittenData(List<Employee> rawList, List<Employee> nonDuplicatList)
	{
		if((!rawList.isEmpty()) && (!nonDuplicatList.isEmpty()))
		{
			System.out.println("\n------------Displaying the overwritten data for the employee list------------\n");
			rawList.forEach((action -> 
			{
				if(!nonDuplicatList.contains(action))
				{
					System.out.println(action.getId()+"    " +action.getName()+"    "
							+action.getGender()+"    " +action.getEmailAddress()+"    "+action.getName()   );
				}
			}
					));
		}
		else
		{
			logger.error("Error is : "+"one of the list is empty");
		}


	}

	public void getSortedIds(List<Employee> empList)
	{
		if(!empList.isEmpty())
		{
			System.out.println("-------------Displaying the Id in sorted order which has been added to the target file----- ");

			List<Integer> list=new ArrayList<>();
			empList.forEach(action-> list.add(Integer.valueOf(action.getId())));
			list.stream().sorted().forEach(System.out::println);	
		}
		else
		{
			logger.error("Error is :"+" list is empty");
		}
	}

}

