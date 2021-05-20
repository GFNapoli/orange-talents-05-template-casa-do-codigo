package br.com.zup.livraria.livraria.config.exception;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.livraria.livraria.controller.form.CategoryForm;
import br.com.zup.livraria.livraria.entity.Category;
import br.com.zup.livraria.livraria.repository.CategoryRepository;

@Component
public class PreventDuplicateName implements Validator{

	@Autowired
	private CategoryRepository repository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return CategoryForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		CategoryForm form = (CategoryForm) target;
		Optional<Category> valid = repository.findByName(form.getName());
		
		if(valid.isPresent()) {
			errors.rejectValue("Name", "400", "Categoria já cadastrada!");
		}
		
	}

}
