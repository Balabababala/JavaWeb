package model;

import java.util.*;

public class GuestBook {

	private String message;
	private Date date;
	
	public GuestBook(String message){
		this.message=message;
		this.date=new Date();
	}
	
	
	public String getMessage() {
		return message;
	}
	public Date getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "GuestBook [message=" + message + ", date=" + date + "]";
	}

	
}

