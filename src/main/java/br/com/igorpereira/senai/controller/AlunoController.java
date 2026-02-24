package br.com.igorpereira.senai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.igorpereira.senai.model.Aluno;
import br.com.igorpereira.senai.service.AlunoService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }


    @GetMapping
    public String index(@RequestParam(required = false) String nome, Model model) {
        List<Aluno> alunos;
        if (nome != null && !nome.isBlank()) {
            alunos = alunoService.findByNomeContainingIgnoreCase(nome);
            model.addAttribute("filtro", nome);
        } else {
            alunos = alunoService.findAll();
        }
        model.addAttribute("alunos", alunos);
        return "aluno/index"; 
    }


    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "aluno/form"; 
    }


    @PostMapping
    public String salvar(Aluno aluno, RedirectAttributes redirect) {
        alunoService.save(aluno);
        redirect.addFlashAttribute("sucesso", "Aluno salvo com sucesso");
        return "redirect:/aluno";
    }


    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model, RedirectAttributes redirect) {
        Optional<Aluno> alunoOpt = alunoService.findById(id);
        if (alunoOpt.isEmpty()) {
            redirect.addFlashAttribute("erro", "Aluno não encontrado");
            return "redirect:/aluno";
        }
        model.addAttribute("aluno", alunoOpt.get());
        return "aluno/form";
    }


    @PostMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id, RedirectAttributes redirect) {
        alunoService.deleteById(id);
        redirect.addFlashAttribute("sucesso", "Aluno excluído");
        return "redirect:/aluno"; 
    }
    
    @GetMapping("/buscar")
    public String buscar(@RequestParam String nome, RedirectAttributes redirect) {
		redirect.addAttribute("nome", nome);
		return "redirect:/aluno";
	}
}