package br.com.zup.livraria.livraria.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.zup.livraria.livraria.entity.Author;
import br.com.zup.livraria.livraria.entity.Book;
import br.com.zup.livraria.livraria.entity.Category;

public class DetailsBook {

	private Long id;
	private String title;
	private String resume;
	private String sumary;
	private BigDecimal price;
	private Integer numberOfPages;
	private String isbn;
	private LocalDate releaseDate;
	private Category category;
	private Author author;
	
	public DetailsBook() {
	}
	

	public DetailsBook(Book book) {
		this.id = book.getId();
		this.title = book.getTitle();
		this.resume = book.getResume();
		this.sumary = book.getSumary();
		this.price = book.getPrice();
		this.numberOfPages = book.getNumberOfPages();
		this.isbn = book.getIsbn();
		this.releaseDate = book.getReleaseDate();
		this.category = book.getCategory();
		this.author = book.getAuthor();
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
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getSumary() {
		return sumary;
	}
	public void setSumary(String sumary) {
		this.sumary = sumary;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	
}
