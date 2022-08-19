package com.ifce.br.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ifce.br.model.Gerente;


@Controller
@RequestMapping("/app")
public class APPController {
	
	
	@GetMapping("/appinicio")
	public String loginCliente () {
		return "/app";
	}

	
	@PostMapping("/login")
	public String logar (Gerente gerente, String usuario, String Senha, String lembrar) {
		return "/login";
	}
}
