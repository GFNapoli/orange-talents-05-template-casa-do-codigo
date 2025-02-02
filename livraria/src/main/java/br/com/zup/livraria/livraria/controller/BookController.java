package br.com.zup.livraria.livraria.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.livraria.livraria.config.exception.BookStoreRequestException;
import br.com.zup.livraria.livraria.controller.dto.BookDto;
import br.com.zup.livraria.livraria.controller.dto.DetailsBook;
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
	@Transactional
	public ResponseEntity<?> registerBook(@RequestBody @Valid BookForm form){
			
		Author author = authorRepository.findById(form.getAuthor()).orElseThrow(
				() -> new BookStoreRequestException("Autor não cadastrado", HttpStatus.NOT_FOUND));				
	
		Category category = categoryRepository.findById(form.getCategory()).orElseThrow(
				() -> new BookStoreRequestException("Categoria não cadastrado", HttpStatus.NOT_FOUND));
		
		Book book = form.convert(author, category);
		repository.save(book);
		return ResponseEntity.ok().build();
		
	}
	
	@GetMapping
	public List<BookDto> bookList(){
		
		List<BookDto> listOfBooks = new ArrayList<>();
		Iterable<Book> books = repository.findAll();
		books.forEach(book -> listOfBooks.add(new BookDto(book)));
		
		return listOfBooks;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetailsBook> detail(@PathVariable Long id){
		Book book = repository.findById(id).orElseThrow(
				() -> new BookStoreRequestException("Livro não cadastrado",HttpStatus.NOT_FOUND));
		
		return ResponseEntity.ok(new DetailsBook(book));

	}
}
