package com.example.dscatalog2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dscatalog2.entities.Category;
import com.example.dscatalog2.repositories.CategoryRepository;

			//Camada de Serviço

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	@Transactional(readOnly = true)
	public List<Category> findAll() {
		return repository.findAll();
	}

}

/* @Transactional(readOnly = true): O parâmetro “readOnly” na anotação @Transactional 
  especifica que nenhuma operação de DML poderá ser executada (Insert, Delete ou Update),
  ou seja, apenas consultas.
*/
