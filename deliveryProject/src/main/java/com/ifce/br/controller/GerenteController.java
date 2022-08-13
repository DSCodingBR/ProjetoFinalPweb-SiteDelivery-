package com.ifce.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ifce.br.model.Gerente;
import com.ifce.br.service.GerenteService;

@Controller
@RequestMapping("/gerente")
public class GerenteController {
	
	@Autowired
	private GerenteService gerenteService;
	
	@GetMapping("/login")
	public String loginGerente () {
		return "/login";
	}
	
	@GetMapping("/cadastroadmin")
	public ModelAndView gerenteFormulario () {
		ModelAndView mv = new ModelAndView ("cadastroAdmin");
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView cadastrarGerente (@Validated Gerente gerente, BindingResult result) {
		ModelAndView mv = new ModelAndView ("login");
		if(result.hasErrors()) {
			return mv;
		}
		mv.addObject("mensagem", "Sucesso ao Cadastrar!");
		gerenteService.cadastrarGerente(gerente);
		return mv;
	}
	
}
