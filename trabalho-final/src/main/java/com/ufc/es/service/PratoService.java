package com.ufc.es.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ufc.es.model.Prato;
import com.ufc.es.repository.PratoRepository;
import com.ufc.es.util.ImgFileUtils;

@Service
public class PratoService {
	@Autowired
	private PratoRepository pratoRepository;
	
	
	public void cadastrar(Prato p, MultipartFile img) {
		String caminho = "images/" + p.getNome() + ".png";
		ImgFileUtils.salvarImagem(caminho, img);
		
		pratoRepository.save(p);
	}


	public List<Prato> listar() {
		
		return pratoRepository.findAll();
	}


	public void excluir(Long id) {
		pratoRepository.deleteById(id);
		
	}


	public Prato buscarPorId(Long id) {
		return pratoRepository.getOne(id);
	}
}
