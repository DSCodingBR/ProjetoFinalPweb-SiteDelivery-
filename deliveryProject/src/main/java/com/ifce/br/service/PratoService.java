package com.ifce.br.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ifce.br.model.Prato;
import com.ifce.br.repository.PratoRepository;
import com.ifce.br.util.AulaFileUtils;

@Service 
public class PratoService {

	@Autowired
	private PratoRepository pratoRepository;
	
	public void cadastrarPrato (Prato prato, MultipartFile imagem) {
		String caminho = "images/" + prato.getNome()+".png";
		AulaFileUtils.salvarImagem(caminho, imagem);
		pratoRepository.save(prato);
	}
	
	public List<Prato> listarPratos(){
		return pratoRepository.findAll();
	}
	
	public void excluirPrato(Long Codigo) {
		pratoRepository.deleteById(Codigo);
	}
	
	public Optional<Prato> buscarPorId(Long codigo) {
		
		return pratoRepository.findById(codigo);
		
	}
}
