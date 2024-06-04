package com.exception;

public class ScheduleNotFoundException extends Exception
{
	String msg;
	public ScheduleNotFoundException(String msg)
	{
		super(msg);
	}
	
}
