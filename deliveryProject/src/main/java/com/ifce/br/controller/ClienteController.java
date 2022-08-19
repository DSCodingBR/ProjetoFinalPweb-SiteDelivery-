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
import com.ifce.br.model.Cliente;
import com.ifce.br.service.ClienteService;


@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/login")
	public String loginGerente (Cliente cliente, String usuario, String Senha) {
		return "/loginCliente";
	}
	
	@GetMapping("/cadastrocliente")
	public ModelAndView clienteFormulario () {
		ModelAndView mv = new ModelAndView ("cadastroCliente");
		mv.addObject("cliente", new Cliente());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView cadastrarCliente (@Validated Cliente cliente, BindingResult result) {
		ModelAndView mv = new ModelAndView ("login");
		if(result.hasErrors()) {
			return mv;
		}
		mv.addObject("mensagem", "Sucesso ao Cadastrar!");
		clienteService.cadastrarCliente(cliente);
		return mv;
	}
	
	@GetMapping("/listar")
	public ModelAndView listarClientes(){
		List<Cliente> clientes = clienteService.listarClientes();
		ModelAndView mv = new ModelAndView("listagem-cliente");
		mv.addObject("listaClientes", clientes);
		return mv;
	}
	
	@RequestMapping("/excluir/{id}")
	public ModelAndView excluirPratos (@PathVariable Long id) {
		clienteService.excluirCliente(id);
		ModelAndView mv = new ModelAndView ("redirect:/cliente/listar");
		return mv;
	}
	
	@RequestMapping("/atualizar/{id}")
	public ModelAndView atualizarPratos (@PathVariable Long id) {
		Optional<Cliente> cliente = clienteService.buscarPorId(id);
		ModelAndView mv = new ModelAndView ("cadastroCliente");
		mv.addObject("cliente", cliente);
		return mv;
	}
	
}
