package br.com.zup.livraria.livraria.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import br.com.zup.livraria.livraria.entity.Author;
import br.com.zup.livraria.livraria.notation.UniqueValue;

public class AuthorForm {

	@NotBlank 
	private String name;
	@NotBlank 
	@Email
	@UniqueValue(domainClass = Author.class, fieldName = "email")
	private String email;
	@NotBlank 
	@Length(max = 400)
	private String description;
	

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Author converter() {
		
		return new Author(name, email, description);
	}
	
	
}
