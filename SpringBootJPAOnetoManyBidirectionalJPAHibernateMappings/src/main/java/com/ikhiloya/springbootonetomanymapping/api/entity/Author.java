package com.ikhiloya.springbootonetomanymapping.api.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@SuppressWarnings("serial")
@Entity
@Table(name="Author")
public class Author implements Serializable{
	
	
	@Column(name = "ID", nullable = false, length = 10)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long  id;
	
	@Column(name = "FirstName")
	@NotBlank(message = "Enter the author's first name")
	private String firstName;
	
	@Column(name = "LastName")
	@NotBlank(message = "Enter the author's Last name")
	private String lastName;
	
	@OneToMany(mappedBy="author",fetch = FetchType.LAZY)
	private Set<Book> books=new HashSet<>();
	
	public Author() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
	
}
