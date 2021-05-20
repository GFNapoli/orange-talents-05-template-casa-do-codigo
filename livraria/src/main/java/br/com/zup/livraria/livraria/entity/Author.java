package br.com.zup.livraria.livraria.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@NotBlank
	private String name;
	@NotBlank 
	@Email
	private String email;
	@NotBlank
	@Length(max = 400)
	private String description;
	private LocalDateTime registrationTime = LocalDateTime.now();
	
	
	
	public Author() {
	}

	public Author(String name, String email, String description) {
		
		this.name = name;
		this.email = email;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getDescription() {
		return description;
	}

	public LocalDateTime getRegistrationTime() {
		return registrationTime;
	}
	
}
