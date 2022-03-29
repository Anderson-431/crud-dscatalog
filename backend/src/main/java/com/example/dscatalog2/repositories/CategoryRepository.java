package com.example.dscatalog2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dscatalog2.entities.Category;

//Camada de Acesso a dados

@Repository
public interface CategoryRepository  extends JpaRepository<Category, Long>{

}
