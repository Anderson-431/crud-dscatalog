package com.example.dscatalog2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dscatalog2.entities.Product;

//Camada de Acesso a dados

@Repository
public interface ProductRepository  extends JpaRepository<Product, Long>{

}
