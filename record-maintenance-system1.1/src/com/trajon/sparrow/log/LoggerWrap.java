package com.trajon.sparrow.log;

import org.apache.log4j.Logger;

/**
 * Wrapper class  to log the messages for the project. Using LOg4j as API.
 * 
 * @author Manish
 *
 */
public class LoggerWrap 
{

	static Logger logger= Logger.getLogger(LoggerWrap.class.getName());

	public LoggerWrap(String name) 
	{

	}

	public LoggerWrap()
	{

	}

	public void info(String message)
	{
		logger.info(message);
	}

	public void debug(String message)
	{
		logger.debug(message);

	}

	public void error(String message)
	{
		logger.error(message);
	}

	public void error(String message, Throwable throwable)
	{
		logger.error(message, throwable);
	}


	public void fatal(String message)
	{
		logger.fatal(message);
	}

	public void warn(String message)
	{
		logger.warn(message);
	}

	public Boolean isDebugEnabled()
	{
		return logger.isDebugEnabled();
	}

}
