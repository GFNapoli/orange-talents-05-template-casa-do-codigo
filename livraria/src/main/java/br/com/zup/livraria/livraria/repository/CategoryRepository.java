package br.com.zup.livraria.livraria.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.zup.livraria.livraria.entity.Category;

public interface CategoryRepository  extends CrudRepository<Category, Long>{

	Optional<Category> findByName(String name);

}
