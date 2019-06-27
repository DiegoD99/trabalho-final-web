package com.ufc.es.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ufc.es.model.Cliente;
import com.ufc.es.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	@RequestMapping("/formulario")
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView("Formulario");
		mv.addObject(new Cliente());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvar(@Validated  Cliente c, BindingResult result) {
		ModelAndView mv = new ModelAndView("Formulario");
		if(result.hasErrors()) {
			return mv;
		}
		mv.addObject("mensagem", "Cliente cadastrado com sucesso!");
		clienteService.cadastrar(c);
		return mv;
	}
}