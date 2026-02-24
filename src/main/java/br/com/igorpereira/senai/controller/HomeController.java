package br.com.igorpereira.senai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/home")
public class HomeController {
	
	@GetMapping
	public String home() {
		System.out.println("HomeController");
		return "home/index";
	}
	
	
	@GetMapping("/notasaluno")
	public String homeNotas (@RequestParam(name="nome") String nome, @RequestParam(name="id") Long id, @RequestParam(name="cpf") String cpf,
			
			Model model) {
		
		model.addAttribute("attrNome", nome);
		model.addAttribute("attrId", id);
		model.addAttribute("attrCpf", cpf);
		System.err.print("parametros recebidos: "+"nome: "+nome+" matricula"+" " + id+ " cpf "+ cpf+"\n");
		return "home/index";
	}	

}
