package br.com.zup.livraria.livraria.config.exception;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.livraria.livraria.controller.form.AuthorForm;
import br.com.zup.livraria.livraria.entity.Author;
import br.com.zup.livraria.livraria.repository.AuthorRepository;

@Component
public class PreventDuplicateEmail implements Validator{

	@Autowired
	private AuthorRepository repository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return AuthorForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		AuthorForm request = (AuthorForm)target;
		Optional<Author> valid = repository.findByEmail(request.getEmail());
		
		if(valid.isPresent()) {
			errors.rejectValue("email", "400", "E-mail já cadastrado");
		}
	}


}
