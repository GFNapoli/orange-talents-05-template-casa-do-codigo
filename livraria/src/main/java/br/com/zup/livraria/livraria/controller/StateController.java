package br.com.zup.livraria.livraria.controller;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.livraria.livraria.controller.form.StateForm;
import br.com.zup.livraria.livraria.entity.Country;
import br.com.zup.livraria.livraria.entity.State;
import br.com.zup.livraria.livraria.repository.CountryRepository;
import br.com.zup.livraria.livraria.repository.StateRepository;

@RestController
@RequestMapping("/state")
public class StateController {

	@Autowired
	private StateRepository repository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> registerState(@RequestBody @Valid StateForm form){
		
		Optional<State> existingiInCountry = repository.findByNameAndCountryId(form.getName(), form.getCountry());
		if(existingiInCountry.isPresent()) {
			return ResponseEntity.badRequest().build();
		}
		
		Optional<Country> country = countryRepository.findById(form.getCountry());
		State state = form.converter(country.get());
		repository.save(state);
		return ResponseEntity.ok().build();
	}
}
