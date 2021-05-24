package br.com.zup.livraria.livraria.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String lastName;
	
	@NotBlank
	private String document;
	
	@NotBlank
	private String adress;
	
	@NotBlank
	private String complement;
	
	@NotBlank
	private String city;
	
	@NotNull
	@ManyToOne
	private Country country;
	
	@ManyToOne(optional = true)
	private State state;
	
	@NotBlank
	private String phoneNumber;
	
	@NotBlank
	private String zipCode;

	public Client() {
	}

	public Client(@NotBlank @Email String email, @NotBlank String name, @NotBlank String lastName,
			@NotBlank String document, @NotBlank String adress, @NotBlank String complement, @NotBlank String city,
			@NotNull Country country, State state, @NotBlank String phoneNumber, @NotBlank String zipCode) {
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

	public Client(@NotBlank @Email String email, @NotBlank String name, @NotBlank String lastName,
			@NotBlank String document, @NotBlank String adress, @NotBlank String complement, @NotBlank String city,
			@NotNull Country country, @NotBlank String phoneNumber, @NotBlank String zipCode) {
		this.email = email;
		this.name = name;
		this.lastName = lastName;
		this.document = document;
		this.adress = adress;
		this.complement = complement;
		this.city = city;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.zipCode = zipCode;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDocument() {
		return document;
	}

	public String getAdress() {
		return adress;
	}

	public String getComplement() {
		return complement;
	}

	public String getCity() {
		return city;
	}

	public Country getCountry() {
		return country;
	}

	public State getState() {
		return state;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getZipCode() {
		return zipCode;
	}
	
	
}
