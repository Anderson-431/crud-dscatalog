package com.example.dscatalog2.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_category")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	public Category() {
	}

	public Category(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(id, other.id);
	}
}

/* Serializable: A serialização em Java é o processo no qual a instância de
   um objetoé transformada em uma sequência de bytes e é útil quando 
   precisamos enviar objetos pela rede, salvar no disco, ou comunicar de 
   uma JVM com outra. Isso porque o estado atual do objeto é “congelado” e 
   na outra “ponta” nós podemos “descongelar” este objeto sem perder nenhuma 
   informação. 

	Equals e Hascode: A comparação de objetos é feita através do resultado do 
	método equals() . A implementação correta do hashCode() é aquela que sempre
 	retorna o mesmo  valor quando chamado para um mesmo objeto, de acordo com
  	o contrato do hashCode
  	
  	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) : anotation para deixar o ID 
	auto-incrementavel 


*/

