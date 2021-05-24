package br.com.zup.livraria.livraria.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.livraria.livraria.entity.Country;
import br.com.zup.livraria.livraria.entity.State;
import br.com.zup.livraria.livraria.notation.ItExist;

public class StateForm {

	@NotBlank
	private String name;
	
	@NotNull
	@ItExist(domainClass = Country.class, fieldName = "id")
	private Long country;

	public StateForm() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCountry() {
		return country;
	}

	public void setCountry(Long country) {
		this.country = country;
	}
	
	public State converter(Country country) {
		return new State(name, country);
	}
}
