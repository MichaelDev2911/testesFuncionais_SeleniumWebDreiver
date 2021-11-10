package tests;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.ContasPage;
import pages.MenuPage;

public class ContaTest extends BaseTest {
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	Random random = new Random();
	
	@Test
	public void testInserirConta() {
		
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta do Teste"+ random.nextInt());
		contasPage.salvar();
		
		Assert.assertEquals("Conta adicionada com sucesso!"
				, contasPage.obterMensagemSucesso());
		
	}
	
	@Test
	public void testAlterarConta() {
		menuPage.acessarTelaListarConta();
		contasPage.clicarAlterarConta("Conta de teste");
		contasPage.setNome("Conta de teste alterada");
		contasPage.salvar();
		Assert.assertEquals("Conta alterada com sucesso!"
				, contasPage.obterMensagemSucesso());
		
	}
	
	@Test
	public void testInserirContaMesmoNome() {
	menuPage.acessarTelaInserirConta();
	
	contasPage.setNome("Conta de teste");
	contasPage.salvar();
	
	Assert.assertEquals("Já existe uma conta com esse nome!"
			, contasPage.obterMensagemErro());
		
	}

}
