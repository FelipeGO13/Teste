package br.com.sgie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.sgie.model.Aluno;
import br.com.sgie.service.AlunoService;

@Controller
public class AlunoController {

	@Autowired
	AlunoService service;
	
	@RequestMapping("/gestaoAlunos")
	public String home(Model model) {
		
		List<Aluno> lista = service.findAll();
		model.addAttribute("alunos", lista);

        return "gestaoAlunos.html";
	}
	
	
	
}
