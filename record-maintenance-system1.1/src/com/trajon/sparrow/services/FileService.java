package com.trajon.sparrow.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.trajon.sparrow.bean.Employee;
import com.trajon.sparrow.exceptions.EmptyList;
import com.trajon.sparrow.log.LoggerWrap;

public class FileService 
{
	LoggerWrap logger= new LoggerWrap();
	EmployeeService employeeService= new EmployeeService();


	public void createFile(String fileName) 
	{
		try(FileWriter fileWriter= new FileWriter(fileName)){}
		catch(IOException exception)
		{
			logger.error("Error is {}"+Thread.currentThread().getStackTrace()[1].getMethodName(), exception);
		}
	}


	public List<Employee>  readFile(String fileName)
	{
		String line="";
		List<Employee> emplist=new ArrayList<>();
		try(BufferedReader fileReader= new BufferedReader(new FileReader(fileName)))
		{
			/**
			 * reading the file header which has been appended while creating the file.
			 */
			String firstLine=fileReader.readLine();
			if(firstLine==null)
			{
				logger.error("Error is {}", new EmptyList("list is empty"));
			}
			else
			{
				while((line=fileReader.readLine())!=null)
				{
					String[] tocken=line.split(",");
					if(tocken.length>0){

						Employee employee=new Employee(Integer.parseInt(tocken[0]), tocken[1], tocken[2], tocken[3],  Integer.parseInt(tocken[4]) );
						emplist.add(employee);
					}
				}
			}
		}
		catch(IOException exception)
		{
			logger.error("Error is {}", exception);

		}
		return (null==emplist?Collections.emptyList(): emplist);
	}



	public void populateFile(List<Employee> Employeelist, String fileName, String fileHeader)
	{
		if(Employeelist.isEmpty())
		{
			logger.error("Error is", new EmptyList("List is emptyyy...!!"));

		}
		else
		{
			try(FileWriter fileWriter= new FileWriter(fileName))
			{
				/**
				 * adding the file header to the file.
				 */
				fileWriter.append(fileHeader);
				fileWriter.append("\n");
				Employeelist.forEach((action)->
				{
					try
					{
						fileWriter.append(String.valueOf(action.getId()));
						fileWriter.append(',');
						fileWriter.append(action.getName());
						fileWriter.append(',');
						fileWriter.append(action.getGender());
						fileWriter.append(',');
						fileWriter.append(action.getEmailAddress());
						fileWriter.append(',');
						fileWriter.append(String.valueOf(action.getMobileNumber()));
						fileWriter.append("\n");
					}
					catch( IOException exception)
					{ 
						logger.error("Error is {}", exception);
					}	});
			}

			catch(IOException ioException)
			{
				logger.error("Error is {}"+ioException);
			}
		}
	}
}

