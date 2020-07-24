package com.javaguides.resttemplate.api;

public class Employee {
	
	    private String firstName;
	    private String lastName;
	    private String emailId;
		public Employee(String firstName, String lastName, String emailId) {
			super();
		
			this.firstName = firstName;
			this.lastName = lastName;
			this.emailId = emailId;
		}
		
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId + "]";
		}
		
	    
	    

}
