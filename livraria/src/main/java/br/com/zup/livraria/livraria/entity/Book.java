package br.com.zup.livraria.livraria.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@NotBlank
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
	private String isbn;
	
	private LocalDate releaseDate;
	
	@NotNull
	@ManyToOne
	private Category category;
	
	@NotNull
	@ManyToOne
	private Author author;
	
	public Book() {
	}

	public Book(@NotBlank String title, @NotBlank @Size(max = 500) String resume, String sumary,
			@NotBlank @DecimalMin("20") BigDecimal price, @NotBlank @Min(100) Integer numberOfPages,
			@NotBlank String isbn, LocalDate releaseDate, @NotNull Category category, @NotNull Author author) {
		this.title = title;
		this.resume = resume;
		this.sumary = sumary;
		this.price = price;
		this.numberOfPages = numberOfPages;
		this.isbn = isbn;
		this.releaseDate = releaseDate;
		this.category = category;
		this.author = author;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getResume() {
		return resume;
	}

	public String getSumary() {
		return sumary;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public Integer getNumberOfPages() {
		return numberOfPages;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public Category getCategory() {
		return category;
	}

	public Author getAuthor() {
		return author;
	}
	
}
