package com.example.dscatalog2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dscatalog2.entities.Category;
import com.example.dscatalog2.repositories.CategoryRepository;

			//Camada de Serviço

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll() {
		return repository.findAll();
	}

}
