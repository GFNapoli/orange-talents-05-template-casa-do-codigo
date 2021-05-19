package br.com.zup.livraria.livraria.controller.form;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.zup.livraria.livraria.entity.Author;

public class AuthorForm {

	@NotBlank @NotEmpty
	private String name;
	@NotBlank @NotEmpty
	@Email
	private String email;
	@NotBlank @NotEmpty
	@Length(max = 400)
	private String description;
	private LocalDateTime registrationTime;
	
	public Author converter() {
		
		return new Author(name, email, description, registrationTime);
	}
	
	
}
