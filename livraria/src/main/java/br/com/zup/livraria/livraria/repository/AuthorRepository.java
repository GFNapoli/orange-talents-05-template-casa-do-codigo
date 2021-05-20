package br.com.zup.livraria.livraria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.livraria.livraria.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

	Optional<Author> findByEmail(String email);

}
