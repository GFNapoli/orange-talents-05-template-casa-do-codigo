package br.com.zup.livraria.livraria.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.zup.livraria.livraria.entity.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

	Optional<Author> findByEmail(String email);

}
