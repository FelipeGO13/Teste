package br.com.sgie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.sgie.model.Curso;
import br.com.sgie.model.Instituicao;
import br.com.sgie.service.CursoService;
import br.com.sgie.service.InstituicaoService;

@Controller
public class InstituicoesController {

	
	@Autowired
	InstituicaoService instituicaoService;
	
	@Autowired
	CursoService cursoService;
	
	@RequestMapping("/gestaoInstituicoes")
	public String gerenciarInstituicao(Model model) {
		
				
		List<Instituicao> lista = instituicaoService.findAll();
		model.addAttribute("instituicoes", lista);

        return "gestaoInstituicoes.html";
	}
	
	@RequestMapping("/incluirInstituicao")
	public String incluirInstituicao(Model model) {
		model.addAttribute("instituicao", new Instituicao());
        return "incluirInstituicao.html";
	}
	
	@RequestMapping("/cadastrarInstituicao")
	public String cadastrarInstituicao(Model model, @ModelAttribute Instituicao instituicao) {

		instituicao.setStatus("ativo");
		instituicaoService.create(instituicao);
		List<Instituicao> lista = instituicaoService.findAll();
		model.addAttribute("instituicoes", lista);
		model.addAttribute("instituicao", new Instituicao());
		model.addAttribute("mensagem", "Instituição cadstrada com sucesso!");
		return "gestaoInstituicoes.html";
	}
	
	@RequestMapping("/excluirInstituicao/{id}")
	public String excluirInstituicao(Model model, @PathVariable Long id) {
		instituicaoService.deleteById(id);
		List<Instituicao> lista = instituicaoService.findAll();
		model.addAttribute("instituicoes", lista);
		model.addAttribute("mensagem", "Instituição excluída com sucesso!");
		return "gestaoInstituicoes.html";
	}
	
	@RequestMapping("/incluirCurso/{id}")
	public String cadastrarCurso(Model model, @PathVariable Long id) {
		
		Instituicao instituicao = instituicaoService.findOne(id);
		model.addAttribute("instituicao", instituicao);
		
		List<Curso> listaCursos = cursoService.findAll();
		model.addAttribute("cursos", listaCursos);
		model.addAttribute("cursoCadastro", listaCursos);
		return "cadastrarCurso.html";
	}
	
	
}
