package br.com.lojavirtual;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.lojavirtual.controller.AcessoController;
import br.com.lojavirtual.model.Acesso;
import br.com.lojavirtual.service.AcessoService;

@SpringBootTest(classes = LojavirtualApplication.class)
class LojavirtualApplicationTests {

	@Autowired
	private AcessoService acessoService;
	
	//@Autowired
	//private AcessoRepository acessoRepository;
	
	@Autowired
	private AcessoController acessoController;
	
	@Test
	public void testCadastroAcesso() {
	
		Acesso acesso = new Acesso();
		acesso.setDescricao("ROLE_ADMIN");
		acessoController.salvarAcesso(acesso);
	}

}
