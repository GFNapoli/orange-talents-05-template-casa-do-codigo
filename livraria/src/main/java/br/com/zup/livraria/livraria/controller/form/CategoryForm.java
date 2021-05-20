package br.com.zup.livraria.livraria.controller.form;

import javax.validation.constraints.NotBlank;

import br.com.zup.livraria.livraria.entity.Category;

public class CategoryForm {

	@NotBlank
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
