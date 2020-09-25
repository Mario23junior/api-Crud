package com.crudProje.Controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.crudProje.Model.Usuarios;
import com.crudProje.Repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	private final UsuarioRepository repository;
	
	public UsuarioController(UsuarioRepository usuarioRepository) {
		this.repository = usuarioRepository;
  	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void salvarUser(@RequestBody @Valid Usuarios user) {
		  repository.save(user);
	}

}
