package br.com.lojavirtual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.lojavirtual.model.Acesso;
import br.com.lojavirtual.service.AcessoService;

@Controller
public class AcessoController {

	@Autowired
	private AcessoService acessoService;
	
	@PostMapping
	public Acesso salvarAcesso(Acesso acesso) {
		
		return acessoService.save(acesso);
	}
}
