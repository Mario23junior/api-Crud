package com.crudProje.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
