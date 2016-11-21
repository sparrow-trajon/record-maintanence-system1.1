package com.trajon.sparrow.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trajon.sparrow.bean.Employee;
import com.trajon.sparrow.log.LoggerWrap;

public class EmployeeDAO 
{


	Connection connection;
	ConnectionConfig config=new ConnectionConfig();
	LoggerWrap log=new LoggerWrap();

	public  List<Employee> getEmployeeList()
	{
		List<Employee > employeeList=new ArrayList<>();
		Connection connection = null;
		ConnectionConfig config=new ConnectionConfig();
		String sql="select * from employee";



		try 
		{

			connection=config.getConnection();
			if(connection==null)
			{
				log.error("connection is null  ", new SQLException());
			}
			else
			{
				Statement statement;

				statement = connection.createStatement();
				ResultSet resultSet=	statement.executeQuery(sql);


				while(resultSet.next())
				{
					employeeList.add(new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(5), resultSet.getInt(4)));

				}


			}

		} 
		catch (SQLException|ClassNotFoundException| IOException exception) 
		{
			log.error("error in the employee DAO  ", exception);
		} 

		return employeeList;
	}

}