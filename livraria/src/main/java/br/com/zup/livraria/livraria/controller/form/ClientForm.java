package br.com.zup.livraria.livraria.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.livraria.livraria.entity.Client;
import br.com.zup.livraria.livraria.entity.Country;
import br.com.zup.livraria.livraria.entity.State;
import br.com.zup.livraria.livraria.notation.DocumentValidation;
import br.com.zup.livraria.livraria.notation.ItExist;
import br.com.zup.livraria.livraria.notation.UniqueValue;

public class ClientForm {

	@NotBlank
	@Email
	@UniqueValue(domainClass = Client.class, fieldName = "email")
	private String email;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String lastName;
	
	@NotBlank
	@UniqueValue(domainClass = Client.class, fieldName = "document")
	@DocumentValidation
	private String document;
	
	@NotBlank
	private String adress;
	
	@NotBlank
	private String complement;
	
	@NotBlank
	private String city;
	
	@NotNull
	@ItExist(domainClass = Country.class, fieldName = "id")
	private Long country;
	
	private Long state;
	
	@NotBlank
	private String phoneNumber;
	
	@NotBlank
	private String zipCode;

	public ClientForm() {
	}

	public ClientForm(@NotBlank @Email String email, @NotBlank String name, @NotBlank String lastName,
			@NotBlank String document, @NotBlank String adress, @NotBlank String complement, @NotBlank String city,
			@NotNull Long country, Long state, @NotBlank String phoneNumber, @NotBlank String zipCode) {
		this.email = email;
		this.name = name;
		this.lastName = lastName;
		this.document = document;
		this.adress = adress;
		this.complement = complement;
		this.city = city;
		this.country = country;
		this.state = state;
		this.phoneNumber = phoneNumber;
		this.zipCode = zipCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getCountry() {
		return country;
	}

	public void setCountry(Long country) {
		this.country = country;
	}

	public Long getState() {
		return state;
	}

	public void setState(Long state) {
		this.state = state;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public Client converter(Country country) {
		return new Client(email, name, lastName, document, adress, complement, city, country, phoneNumber, zipCode);
	}
	
	public Client converterWhitState(Country country, State state) {
		return new Client(email, name, lastName, document, adress, complement, city, country, state, phoneNumber, zipCode);
	}
}
