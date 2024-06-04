package com.exception;

public class AdminNotFoundException extends Exception
{
	String msg;
	public AdminNotFoundException(String msg)
	{
		super(msg);
	}
	
}
