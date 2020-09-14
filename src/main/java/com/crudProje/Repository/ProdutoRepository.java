package com.crudProje.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudProje.Model.Produtos;

public interface ProdutoRepository extends JpaRepository<Produtos, Long>{

}
