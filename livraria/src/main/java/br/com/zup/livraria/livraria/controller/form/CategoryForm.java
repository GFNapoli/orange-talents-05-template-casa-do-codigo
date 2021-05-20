package br.com.zup.livraria.livraria.controller.form;

import javax.validation.constraints.NotBlank;

import br.com.zup.livraria.livraria.entity.Category;
import br.com.zup.livraria.livraria.notation.UniqueValue;

public class CategoryForm {

	@NotBlank
	@UniqueValue(domainClass = Category.class, fieldName = "name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Category convert() {
		return new Category(name);
	}
}
