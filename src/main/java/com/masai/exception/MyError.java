package com.masai.exception;

import java.time.LocalTime;

public class MyError {
	
	private LocalTime localt;
	private String msg;
	private String description;
	
	
	public MyError(LocalTime localt, String msg, String description) {
		super();
		this.localt = localt;
		this.msg = msg;
		this.description = description;
	}


	public MyError() {
		super();
	}


	public LocalTime getLocalt() {
		return localt;
	}


	public void setLocalt(LocalTime localt) {
		this.localt = localt;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "MyError [localt=" + localt + ", msg=" + msg + ", description=" + description + "]";
	}
	
	
	

}
