package br.com.zup.livraria.livraria.controller.form;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zup.livraria.livraria.entity.Author;
import br.com.zup.livraria.livraria.entity.Book;
import br.com.zup.livraria.livraria.entity.Category;
import br.com.zup.livraria.livraria.notation.UniqueValue;

public class BookForm {

	@NotBlank
	@UniqueValue(domainClass = Book.class, fieldName = "title")
	private String title;
	
	@NotBlank
	@Size(max = 500)
	private String resume;
	
	private String sumary;
	
	@NotNull
	@DecimalMin(value = "20")
	private BigDecimal price;
	
	@NotNull
	@Min(value = 100)
	private Integer numberOfPages;
	
	@NotBlank
	@UniqueValue(domainClass = Book.class, fieldName = "isbn")
	private String isbn;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Future
	private LocalDate releaseDate;
	
	@NotNull
	private Long category;
	
	@NotNull
	private Long author;
	
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
	public Long getCategory() {
		return category;
	}
	public void setCategory(Long category) {
		this.category = category;
	}
	public Long getAuthor() {
		return author;
	}
	public void setAuthor(Long author) {
		this.author = author;
	}
	public Book convert(Author author, Category category) {
		return new Book(title, resume, sumary, price, numberOfPages, isbn, releaseDate, category, author);
	}
	
	
	
}
