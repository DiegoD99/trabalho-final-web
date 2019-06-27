package com.ufc.es.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ufc.es.model.Prato;
import com.ufc.es.service.PratoService;

@Controller
@RequestMapping("/prato") 
public class PratoController {
	@Autowired
	private PratoService pratoService;
	
	@RequestMapping("/formularioPrato")
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView("FormularioPrato");
		mv.addObject("prato", new Prato());
		return mv;
	}
	@RequestMapping("/salvarPrato")
	public ModelAndView salvar(@Validated Prato p, BindingResult result, @RequestParam(value="imagem") MultipartFile imagem  ) {
		ModelAndView mv = new ModelAndView("FormularioPrato");
		
		if(result.hasErrors()) {
			return mv;
		}
		
		mv.addObject("mensagem", "Prato cadastrado com sucesso!");
		pratoService.cadastrar(p,imagem);
		return mv;
	}
	@RequestMapping("/listagemPratos")
	public ModelAndView listar() {
		List<Prato> pratos = pratoService.listar();
		ModelAndView mv = new ModelAndView("ListagemPratos");
		mv.addObject("listaDePratos", pratos);
		
		return mv;
	}
	
	@RequestMapping("/excluirPrato/{id}")
	public ModelAndView excluir(@PathVariable Long id) {
		pratoService.excluir(id);
		ModelAndView mv = new ModelAndView("redirect:/prato/listagemPratos");
		return mv;
	}
	@RequestMapping("/atualizarPrato/{id}")
	public ModelAndView atualizar(@PathVariable Long id) {
		Prato prato = pratoService.buscarPorId(id);
		ModelAndView mv = new ModelAndView("FormularioPrato");
		mv.addObject("prato", prato);
		return mv;
	}
}
 