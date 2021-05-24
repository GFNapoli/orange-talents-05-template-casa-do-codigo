package br.com.zup.livraria.livraria.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.zup.livraria.livraria.entity.Country;

public interface CountryRepository extends CrudRepository<Country, Long>{

	Country findByName(String country);

}
