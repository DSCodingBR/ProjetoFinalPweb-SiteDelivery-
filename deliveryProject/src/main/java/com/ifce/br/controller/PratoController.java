package com.ifce.br.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.ifce.br.model.Prato;
import com.ifce.br.service.PratoService;

@Controller
@RequestMapping("/prato")
public class PratoController {
	
	@Autowired
	private PratoService pratoService;
	
	@GetMapping("/formulario")
	public ModelAndView pratoFormulario () {
		ModelAndView mv = new ModelAndView ("Formulario");
		mv.addObject("prato", new Prato());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView cadastrarPrato (@Validated Prato prato, @RequestParam(value="imagem") MultipartFile imagem) {
		ModelAndView mv = new ModelAndView ("Formulario");
		//if (result.hasErros()) {
			//return mv;
		//}
		mv.addObject("mensagem", "Prato Cadastrado Com Sucesso!");
		pratoService.cadastrarPrato(prato, imagem);
		return mv;
	}
	
	@GetMapping("/listar")
	public ModelAndView listarPratos(){
		List<Prato> pratos = pratoService.listarPratos();
		ModelAndView mv = new ModelAndView("listagem-prato");
		mv.addObject("listaPratos", pratos);
		return mv;
	}
	
	@RequestMapping("/excluir/{codigo}")
	public ModelAndView excluirPratos (@PathVariable Long codigo) {
		pratoService.excluirPrato(codigo);
		ModelAndView mv = new ModelAndView ("redirect:/prato/listar");
		return mv;
	}
	@RequestMapping("/atualizar/{codigo}")
	public ModelAndView atualizarPratos (@PathVariable Long codigo) {
		Optional<Prato> prato = pratoService.buscarPorId(codigo);
		ModelAndView mv = new ModelAndView ("Formulario");
		mv.addObject("prato", prato);
		return mv;
	}
	
	
}
