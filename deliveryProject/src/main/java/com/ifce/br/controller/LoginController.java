package com.ifce.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.ifce.br.model.Gerente;
import com.ifce.br.repository.GerenteRepository;

@Controller
public class LoginController {
	
	@Autowired
	private GerenteRepository gerenteRepository;
	
	@GetMapping("/login")
	public String login () {
		return "/login";
	}
	
	@PostMapping("/login")
	public String logar (Gerente gerente, String usuario, String Senha, String lembrar) {
		return "/login";
	}
}
