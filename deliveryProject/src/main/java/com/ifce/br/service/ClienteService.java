package com.ifce.br.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ifce.br.model.Cliente;
import com.ifce.br.repository.ClienteRepository;


@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public void cadastrarCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	public List<Cliente> listarClientes(){
		return clienteRepository.findAll();
	}
	
	public void excluirCliente(Long id) {
		clienteRepository.deleteById(id);
	}
	
	public Optional<Cliente> buscarPorId(Long id) {
		
		return clienteRepository.findById(id);
		
	}
}
