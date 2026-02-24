package br.com.igorpereira.senai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.igorpereira.senai.model.Aluno;
import br.com.igorpereira.senai.repository.AlunoRepository;

@Service
@Transactional
public class AlunoService {

    private final AlunoRepository alunoRepository;


    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }


    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }


    @Transactional(readOnly = true)
    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    public List<Aluno> findByNomeContainingIgnoreCase(String nome) {
					return alunoRepository.findByNomeContainingIgnoreCase(nome);
	}


    @Transactional(readOnly = true)
    public Optional<Aluno> findById(Long id) {
        return alunoRepository.findById(id);
    }


    public Aluno update(Aluno aluno) {
        return alunoRepository.save(aluno);
    }


    public void deleteById(Long id) {
        alunoRepository.deleteById(id);
    }
    

    
    
}