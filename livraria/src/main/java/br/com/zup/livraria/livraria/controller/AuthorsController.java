package br.com.zup.livraria.livraria.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.livraria.livraria.config.exception.PreventDuplicateEmail;
import br.com.zup.livraria.livraria.controller.dto.AuthorDto;
import br.com.zup.livraria.livraria.controller.form.AuthorForm;
import br.com.zup.livraria.livraria.entity.Author;
import br.com.zup.livraria.livraria.repository.AuthorRepository;

@RestController
@RequestMapping("/author")
public class AuthorsController {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private PreventDuplicateEmail duplicateEmail;
	
	@InitBinder
	public void checksEmail(WebDataBinder dataBinder) {
		dataBinder.addValidators(duplicateEmail);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<AuthorDto> register(@RequestBody @Valid AuthorForm form) {
		
		Author author = form.converter();
		authorRepository.save(author);
		
		return ResponseEntity.ok().build();
	}
}
