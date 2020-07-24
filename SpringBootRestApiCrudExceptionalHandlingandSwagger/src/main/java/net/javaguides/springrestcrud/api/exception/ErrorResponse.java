package net.javaguides.springrestcrud.api.exception;

import java.util.Date;

public class ErrorResponse {
	
	private Date timeStamp;
	private String message;
	private String location;
	public ErrorResponse(Date timeStamp, String message, String location) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.location = location;
	}
	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "ErrorResponse [timeStamp=" + timeStamp + ", message=" + message + ", location=" + location + "]";
	}
	
	

}
