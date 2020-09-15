package com.crudProje.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudProje.Model.Produtos;
import com.crudProje.Repository.ProdutoRepository;
  
@RequestMapping("/api")
@RestController
public class ProdutoController {
   
	@Autowired
	private ProdutoRepository produtoRepository;
	
	// Listando todos os produtos do banco de dados 
	@GetMapping(value = "/lista")
 	 public List<Produtos>list(){
		   return produtoRepository.findAll();
	 }
	
	// listando produto por indentificador id
	@GetMapping(value = "/listId/{id}")
	public ResponseEntity<Produtos> listId(@PathVariable(value = "id") long id){
		 Optional<Produtos> produto = produtoRepository.findById(id);
		  if(produto.isPresent()) {
			  return new ResponseEntity<Produtos>(produto.get(), HttpStatus.OK);
		  }else {
			  return new ResponseEntity<Produtos>(HttpStatus.NOT_FOUND);
		  }
	}
}










