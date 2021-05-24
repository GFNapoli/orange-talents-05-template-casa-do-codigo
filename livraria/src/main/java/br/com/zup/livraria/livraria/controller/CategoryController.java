package br.com.zup.livraria.livraria.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.livraria.livraria.controller.form.CategoryForm;
import br.com.zup.livraria.livraria.entity.Category;
import br.com.zup.livraria.livraria.repository.CategoryRepository;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> newCategory(@RequestBody @Valid CategoryForm form){
		
		Category category = form.convert();
		categoryRepository.save(category);
		
		return ResponseEntity.ok().build();
	}
	
}
