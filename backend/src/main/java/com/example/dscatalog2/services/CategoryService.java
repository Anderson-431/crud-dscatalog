package com.example.dscatalog2.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dscatalog2.dto.CategoryDTO;
import com.example.dscatalog2.entities.Category;
import com.example.dscatalog2.repositories.CategoryRepository;
import com.example.dscatalog2.services.exceptions.ResourceNotFoundException;

			//Camada de Serviço

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll() {
		List<Category> list = repository.findAll();
		return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public CategoryDTO findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		Category entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new CategoryDTO(entity);
	}

	@Transactional
	public CategoryDTO insert(CategoryDTO dto) {
		Category entity = new Category();
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new CategoryDTO(entity);
	}

	@Transactional
	public CategoryDTO update(Long id, CategoryDTO dto) {
		try {
		Category entity = repository.getOne(id);
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new CategoryDTO(entity);
	}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found" + id);
		}
	}	
}

/* @Transactional(readOnly = true): O parâmetro “readOnly” na anotação @Transactional 
  especifica que nenhuma operação de DML poderá ser executada (Insert, Delete ou Update),
  ou seja, apenas consultas.
  
  return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
  O comando acima transforma a Lista Category do pacote entities em uma lista CatgoryDTO
  pois a camada de entidades não pode conversar diretamente com a camada de Controladores REST.
*/
