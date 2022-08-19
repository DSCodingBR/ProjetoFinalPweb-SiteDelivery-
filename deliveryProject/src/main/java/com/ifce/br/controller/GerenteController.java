package com.ifce.br.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.ifce.br.model.Gerente;
import com.ifce.br.model.Prato;
import com.ifce.br.service.GerenteService;

@Controller
@RequestMapping("/gerente")
public class GerenteController {
	
	@Autowired
	private GerenteService gerenteService;
	
	@GetMapping("/login")
	public String loginGerente (Gerente gerente, String usuario, String Senha) {
		return "/login";
	}
	
	@GetMapping("/cadastroadmin")
	public ModelAndView gerenteFormulario () {
		ModelAndView mv = new ModelAndView ("cadastroAdmin");
		mv.addObject("gerente", new Gerente());
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
	
	@GetMapping("/listar")
	public ModelAndView listarGerentes(){
		List<Gerente> gerentes = gerenteService.listarGerentes();
		ModelAndView mv = new ModelAndView("listagem-gerente");
		mv.addObject("listaGerentes", gerentes);
		return mv;
	}
	
	@RequestMapping("/excluir/{codigo}")
	public ModelAndView excluirPratos (@PathVariable Long codigo) {
		gerenteService.excluirGerente(codigo);
		ModelAndView mv = new ModelAndView ("redirect:/gerente/listar");
		return mv;
	}
	
	@RequestMapping("/atualizar/{codigo}")
	public ModelAndView atualizarPratos (@PathVariable Long codigo) {
		Optional<Gerente> gerente = gerenteService.buscarPorId(codigo);
		ModelAndView mv = new ModelAndView ("cadastroAdmin");
		mv.addObject("gerente", gerente);
		return mv;
	}
	
}
