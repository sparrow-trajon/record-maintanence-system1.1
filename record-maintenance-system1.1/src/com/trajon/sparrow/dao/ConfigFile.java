package com.trajon.sparrow.dao;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import com.trajon.sparrow.log.LoggerWrap;



public class ConfigFile 
{
	LoggerWrap log= new LoggerWrap();

	public ConfigFile()  
	{
		try
		{
			createConfigFile();
		} 
		catch (IOException e) 
		{
			log.error("error in the creating the config properties file", new IOException());
		}
	}

	private static void createConfigFile() throws IOException 
	{
		Properties prop = new Properties();
		OutputStream output = null;
		output = new FileOutputStream("resource/config.properties");
		prop.setProperty("DB_URL", "URL");
		prop.setProperty("DB_USERNAME", "username");
		prop.setProperty("DB_PASSWORD", "password");
		prop.setProperty("DB_DRIVER_CLASS", "com.mysql.jdbc.Driver");
		prop.store(output, null);
	} 

}

