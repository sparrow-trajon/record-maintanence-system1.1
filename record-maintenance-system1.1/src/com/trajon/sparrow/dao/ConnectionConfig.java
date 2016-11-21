package com.trajon.sparrow.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.trajon.sparrow.log.LoggerWrap;


public class ConnectionConfig
{
	private  String DEFAULT_USER_NAME;
	private  String DEFAULT_PASSWORD;
	private  String DEFAULT_URL;
	LoggerWrap log=new LoggerWrap();
	Connection connection;
	ConfigFile configFile;

	private  void getProperties() 
	{
		Properties prop = new Properties();
		/**
		 * creates the config.properties if it is not present in the project
		 */
		try
		{
			if(!new File("resource/config.properties").exists())
			{
				configFile = new ConfigFile();
			}
			InputStream input = new FileInputStream("resource/config.properties");
			prop.load(input);
			Class.forName(prop.getProperty("DB_DRIVER_CLASS"));
		}
		catch(ClassNotFoundException|IOException exception)
		{
			log.error("can't load the jdbc driver  ", exception);
		} 
		DEFAULT_URL=prop.getProperty("DB_URL");
		DEFAULT_USER_NAME=prop.getProperty("DB_USERNAME");
		DEFAULT_PASSWORD=prop.getProperty("DB_PASSWORD");
		if(log.isDebugEnabled())
		{
			log.debug("all the properties has been extracted");
		}
	}

	public Connection getConnection() throws SQLException, IOException, ClassNotFoundException
	{

		/**
		 * getting all the config properties
		 */
		getProperties();
		if(log.isDebugEnabled())
		{
			log.debug("createConnection is being executed..!!");
		}
		try
		{
			connection = DriverManager.getConnection(DEFAULT_URL, DEFAULT_USER_NAME, DEFAULT_PASSWORD);
		}
		catch(SQLException exception)
		{
			log.error("connectioon is null in the connection config");
		}
		return connection;
	}

}
