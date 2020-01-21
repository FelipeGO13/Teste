package br.com.sgie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.sgie.model.Curso;
import br.com.sgie.service.CursoService;

@Controller
public class CursoController {
	
	@Autowired
	CursoService service;
	
	@RequestMapping("/gestaoCursos")
	public String home(Model model) {
		
		
		List<Curso> lista = service.findAll();
		model.addAttribute("cursos", lista);

        return "gestaoCursos.html";
	}
	
	
	
}
