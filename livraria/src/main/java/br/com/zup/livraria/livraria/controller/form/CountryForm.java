package br.com.zup.livraria.livraria.controller.form;

import javax.validation.constraints.NotBlank;

import br.com.zup.livraria.livraria.entity.Country;
import br.com.zup.livraria.livraria.notation.UniqueValue;

public class CountryForm {

	@NotBlank
	@UniqueValue(domainClass = Country.class, fieldName = "name")
	private String name;
	
	public CountryForm() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Country converter() {
		return new Country(name);
	}
}
