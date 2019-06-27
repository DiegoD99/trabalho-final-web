package com.ufc.es.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.es.model.Cliente;
import com.ufc.es.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	public void cadastrar(Cliente c) {
		clienteRepository.save(c);
	}
}
