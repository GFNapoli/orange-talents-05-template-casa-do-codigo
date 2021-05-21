package br.com.zup.livraria.livraria.controller.dto;

import br.com.zup.livraria.livraria.entity.Book;

public class BookDto {

	private Long id;
	private String title;
	
	public BookDto(Book book) {
		this.id = book.getId();
		this.title = book.getTitle();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
