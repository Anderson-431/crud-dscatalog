package com.example.dscatalog2.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.dscatalog2.dto.CategoryDTO;
import com.example.dscatalog2.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	//Metodo para buscar todas as categorias
	@GetMapping
	public ResponseEntity<Page<CategoryDTO>> findAll(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy
			
			){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		Page<CategoryDTO> list = service.findAllPaged(pageRequest);
		
		return ResponseEntity.ok().body(list);
	}
	
	//Metodo para buscar uma categoria por Id
	@GetMapping(value = "/{id}")
	public ResponseEntity <CategoryDTO> findById(@PathVariable Long id){
		CategoryDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	//Metodo para inserir no banco uma nova categoria
		@PostMapping
		public ResponseEntity<CategoryDTO> insert(@RequestBody CategoryDTO dto){
			dto = service.insert(dto);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(dto.getId()).toUri();
			return ResponseEntity.created(uri).body(dto);
		}

	//Metodo para atualizar uma categoria no banco 
		@PutMapping(value = "/{id}")
		public ResponseEntity<CategoryDTO> update(@PathVariable Long id, @RequestBody CategoryDTO dto){
			dto = service.update(id, dto);
			return ResponseEntity.ok().body(dto);
		}
		
		//Metodo para deletar uma categoria no banco 
		@DeleteMapping(value = "/{id}")
		public ResponseEntity<CategoryDTO> delete(@PathVariable Long id){
			service.delete(id);
			return ResponseEntity.noContent().build();
	}
}




/* Resource = Camamda de Controladores REST.
   Resource = Recursos da entidade Catgory.
   
   @RestController: ?? uma anottation que ?? uma forma de usar algo que j?? est?? implementado atrav??s de
   recursos que foram criados e nesse caso foram criados pela equipe do springboot.
   
   @RequestMapping: Determina a rota RETS do seu recurso.
   @RequestMapping(value = "/categories"): Geralmente a rota do recurso e colocado no plural.
   
   	@GetMapping: Essa anota????o ?? usada para mapear solicita????es HTTP GET em m??todos manipuladores 
   	espec??ficos. @GetMapping ?? uma anota????o composta que atua como um atalho para @ RequestMapping 
   	( method = RequestMethod. GET )
   
   EndPoints: ?? a primeira rota poss??vel que vai responder alguma coisa.
   
   ResponseEntity: ?? um objeto do springboot que encapsula(agrupa) uma resposta HTTP (Protocolo de 
   Transfer??ncia de Hipertexto), o ResponseEntity tamb?? ?? um generic.
   
   findAll() ?? um m??todo que busca todas as categorias
   
   .ok() : ?? um m??todo builder do ResponseEntity para que a resposta seja 200 "realizada com sucesso".
   
   .body() : ?? um m??todo que define o corpo da resposta
   
   @PathVariable = Serve para casar a variavel que est?? na rota, exemplo: @GetMapping(value = "/{id}") com 
   a variavel do java (@PathVariable Long id).
   
   	
*/
