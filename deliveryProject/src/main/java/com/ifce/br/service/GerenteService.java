package com.ifce.br.service;

import java.util.List;
import java.util.Optional;
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
	
	public List<Gerente> listarGerentes(){
		return gerenteRepository.findAll();
	}
	
	public void excluirGerente(Long Codigo) {
		gerenteRepository.deleteById(Codigo);
	}
	
	public Optional<Gerente> buscarPorId(Long codigo) {
		
		return gerenteRepository.findById(codigo);
		
	}
}
