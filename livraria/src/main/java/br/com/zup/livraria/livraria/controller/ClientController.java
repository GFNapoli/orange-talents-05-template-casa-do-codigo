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

import br.com.zup.livraria.livraria.controller.form.ClientForm;
import br.com.zup.livraria.livraria.entity.Client;
import br.com.zup.livraria.livraria.entity.Country;
import br.com.zup.livraria.livraria.entity.State;
import br.com.zup.livraria.livraria.repository.ClientRepository;
import br.com.zup.livraria.livraria.repository.CountryRepository;
import br.com.zup.livraria.livraria.repository.StateRepository;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientRepository repository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> registerClient(@RequestBody @Valid  ClientForm form){
		
		Client client;
		
		Optional<Country> country = countryRepository.findById(form.getCountry());
		
		if(form.getState() == null) {
			client = form.converter(country.get());
			repository.save(client);
			return ResponseEntity.ok().build();
		}
		
		Optional<State> state = stateRepository.findById(form.getState());
		
		if(state.isPresent()) {
			client = form.converterWhitState(country.get(), state.get());
			repository.save(client);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
