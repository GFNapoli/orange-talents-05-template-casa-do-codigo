package br.com.zup.livraria.livraria.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.zup.livraria.livraria.entity.State;

public interface StateRepository extends CrudRepository<State, Long>{

	Iterable<State> findByName(String name);

	Optional<State> findByNameAndCountryId(String name, Long country);

}
