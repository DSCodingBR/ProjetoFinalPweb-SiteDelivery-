package com.ifce.br.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ifce.br.model.Gerente;
import com.ifce.br.repository.GerenteRepository;


@Service
public class GerenteService {
	
	@Autowired
	private GerenteRepository gerenteRepository;
	
	public void cadastrarGerente(Gerente gerente) {
		gerenteRepository.save(gerente);
	}
	
}
