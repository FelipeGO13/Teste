package br.com.sgie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.sgie.model.Instituicao;
import br.com.sgie.service.InstituicaoService;

@Controller
public class TestController {

	@RequestMapping("/index")
	public String home(Model model) {
		
        return "index.html";
	}

}
