package com.example.dscatalog2.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dscatalog2.entities.Category;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = new ArrayList<>();
		list.add(new Category(1L, "Books")); //1L e 2L pois o L se trata de um Long da classe Category
		list.add(new Category(2L, "Electronics"));
		return ResponseEntity.ok().body(list);
	}
	

}




/* Resource = Camamda de Controladores REST.
   Resource = Recursos da entidade Catgory.
   
   @RestController: É uma anottation que é uma forma de usar algo que já está implementado através de
   recursos que foram criados e nesse caso foram criados pela equipe do springboot.
   
   @RequestMapping: Determina a rota RETS do seu recurso.
   @RequestMapping(value = "/categories"): Geralmente a rota do recurso e colocado no plural.
   
   	@GetMapping: Essa anotação é usada para mapear solicitações HTTP GET em métodos manipuladores 
   	específicos. @GetMapping é uma anotação composta que atua como um atalho para @ RequestMapping 
   	( method = RequestMethod. GET )
   
   EndPoints: É a primeira rota possível que vai responder alguma coisa.
   
   ResponseEntity: É um objeto do springboot que encapsula(agrupa) uma resposta HTTP (Protocolo de 
   Transferência de Hipertexto), o ResponseEntity també é um generic.
   
   findAll() É um método que busca todas as categorias
   
   .ok() : É um método builder do ResponseEntity para que a resposta seja 200 "realizada com sucesso".
   
   .body() : É um método que define o corpo da resposta
   
   	
*/
