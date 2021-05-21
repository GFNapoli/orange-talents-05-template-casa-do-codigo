package br.com.zup.livraria.livraria.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.livraria.livraria.controller.form.AuthorForm;
import br.com.zup.livraria.livraria.entity.Author;
import br.com.zup.livraria.livraria.repository.AuthorRepository;

@RestController
@RequestMapping("/author")
public class AuthorsController {
	
	@Autowired
	private AuthorRepository authorRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<?> register(@RequestBody @Valid AuthorForm form) {
		
		Author author = form.converter();
		authorRepository.save(author);
		
		return ResponseEntity.ok().build();
	}
}
