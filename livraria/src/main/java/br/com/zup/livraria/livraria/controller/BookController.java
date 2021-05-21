package br.com.zup.livraria.livraria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import br.com.zup.livraria.livraria.controller.form.BookForm;
import br.com.zup.livraria.livraria.entity.Author;
import br.com.zup.livraria.livraria.entity.Book;
import br.com.zup.livraria.livraria.entity.Category;
import br.com.zup.livraria.livraria.repository.AuthorRepository;
import br.com.zup.livraria.livraria.repository.BookRepository;
import br.com.zup.livraria.livraria.repository.CategoryRepository;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private BookRepository repository;
	
	@PostMapping 
	public ResponseEntity<?> registerBook(@RequestBody @Valid BookForm form){
			
		Author author = authorRepository.findById(form.getAuthor()).orElseThrow(
				() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Author não cadastrado"));				
	
		Category category = categoryRepository.findById(form.getCategory()).orElseThrow(
				() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Categoria não cadastrado"));
		
		Book book = form.convert(author, category);
		repository.save(book);
		return ResponseEntity.ok().build();
		
	}
}
