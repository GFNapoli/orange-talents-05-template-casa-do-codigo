package br.com.zup.livraria.livraria.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String name;
	private String email;
	private String description;
	private LocalDateTime registrationTime;
	
	public Author(String name, String email, String description, LocalDateTime registrationTime) {
		
		this.name = name;
		this.email = email;
		this.description = description;
		this.registrationTime = registrationTime;
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
