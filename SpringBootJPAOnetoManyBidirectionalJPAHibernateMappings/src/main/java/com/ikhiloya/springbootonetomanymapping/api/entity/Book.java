package com.ikhiloya.springbootonetomanymapping.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Book")
public class Book {
	
	@Column(name = "ID", nullable = false, length = 10)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	
	    @Column(name = "Title")
	    @NotBlank(message = "Enter a title ")
	    private String title;

	    @Column(name = "Genre")
	    @NotBlank(message = "Enter a genre ")
	    private String genre;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="authorId", nullable = false)
	    @OnDelete(action = OnDeleteAction.CASCADE)
	    private Author author;
	    
	    public Book() {
	    }


	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getGenre() {
	        return genre;
	    }

	    public void setGenre(String genre) {
	        this.genre = genre;
	    }

	    
	    public long getAuthorId() {
	    	return author.getId();
	    }
	    
	    public String getAuthorFirstName() {
	    	return author.getFirstName()+" "+author.getLastName();
	    }
	    
	    @JsonIgnore
	    public Author getAuthor() {
	        return author;
	    }

	    @JsonIgnore
	    public void setAuthor(Author author) {
	        this.author = author;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }
	    

}
