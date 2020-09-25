package com.crudProje.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudProje.Model.Usuarios;

public interface UsuarioRepository extends JpaRepository<Usuarios, Integer> {

}
