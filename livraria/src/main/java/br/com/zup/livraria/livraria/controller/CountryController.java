package br.com.zup.livraria.livraria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.livraria.livraria.controller.form.CountryForm;
import br.com.zup.livraria.livraria.entity.Country;
import br.com.zup.livraria.livraria.repository.CountryRepository;

@RestController
@RequestMapping("/country")
public class CountryController {

	@Autowired
	private CountryRepository repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> registerCountry(@RequestBody @Valid CountryForm form){
		
		Country country = form.converter();
		repository.save(country);
		
		return ResponseEntity.ok().build();
	}
}
