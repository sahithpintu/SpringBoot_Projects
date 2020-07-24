package net.javaguides.springrestcrud.api.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "employees")
@ApiModel(description = "All details about the Employee. ")
public class Employee {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false, length = 10)
    private Integer id;
	
	
	 @ApiModelProperty(notes = "The employee first name")
	 @Column(name = "first_name", nullable = false)
    private String firstName;
	 
	  @ApiModelProperty(notes = "The employee last name")
	  @Column(name = "last_name", nullable = false)
    private String lastName;
	  
	  @ApiModelProperty(notes = "The employee email id")
	  @Column(name = "email_address", nullable = false)
    private String emailId;

    public Employee() {

    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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


	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ "]";
	}
    
    
}