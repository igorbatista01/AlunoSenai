package br.com.igorpereira.senai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.igorpereira.senai.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {


    List<Aluno> findByNomeContainingIgnoreCase(String nome);

}