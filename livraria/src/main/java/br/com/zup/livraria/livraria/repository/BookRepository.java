package br.com.zup.livraria.livraria.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.zup.livraria.livraria.entity.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
