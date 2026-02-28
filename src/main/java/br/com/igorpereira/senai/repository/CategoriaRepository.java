package br.com.igorpereira.senai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.igorpereira.senai.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}