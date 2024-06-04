package com.exception;

public class TrainerNotFoundException extends Exception
{
	String msg;
	public TrainerNotFoundException(String msg)
	{
		super(msg);
	}
	
}
