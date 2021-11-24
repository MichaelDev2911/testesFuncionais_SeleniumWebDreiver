package tests;

import static tests.utils.DataUtils.obterDataComDiferencaDias;
import static tests.utils.DataUtils.obterDataFormatada;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import core.BaseTest;
import pages.MenuPage;
import pages.MovimentacaoPage;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTest extends BaseTest {
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movpage = new MovimentacaoPage();

	@Test
	public void test1_InserirMovimentacao() {
		menuPage.acessarTelaInserirMovimentacao();
		movpage.setDataMovimentacao(obterDataFormatada(new Date()));
		movpage.setDataPagamento(obterDataFormatada(new Date()));
		movpage.setDescricao("Movimenta��o do teste");
		movpage.setInteressado("Interessado qualquer");
		movpage.setValor("500");
		movpage.setConta("Conta de teste alterada");
		movpage.setStatusPago();
		movpage.salvar();
		
		Assert.assertEquals("Movimenta��o adicionada com sucesso!",
				movpage.obterMensagemSucesso());
		
	}
	
	@Test 
	public void test2_CamposObrigatoriosMovimentacao() {

		menuPage.acessarTelaInserirMovimentacao();
		movpage.salvar();
		List<String> erros = movpage.obterErros();
		//Assert.assertEquals("Data da Movimenta��o � obrigat�rio",erros.get(0));
		//Assert.assertTrue(erros.contains("Data da Movimenta��o � obrigat�rio"));
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimenta��o � obrigat�rio",
				"Data do pagamento � obrigat�rio",
				"Descri��o � obrigat�rio",
				"Interessado � obrigat�rio",
				"Valor � obrigat�rio",
				"Valor deve ser um n�mero"
				)));
		Assert.assertEquals(6, erros.size());
		
	}
	
	@Test
	public void test3_InsertMovimentacaoFutura() {
		
		Date dataFutura = obterDataComDiferencaDias(1);
		
		menuPage.acessarTelaInserirMovimentacao();
		movpage.setDataMovimentacao(obterDataFormatada(dataFutura));
		movpage.setDataPagamento("02/09/2017");
		movpage.setDescricao("Movimenta��o do teste");
		movpage.setInteressado("Interessado qualquer");
		movpage.setValor("500");
		movpage.setConta("Conta de teste alterada");
		movpage.setStatusPago();
		movpage.salvar();

		List<String> erros = movpage.obterErros();
	
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimenta��o deve ser menor ou igual � data atual!"
				)));
		Assert.assertEquals(1, erros.size());
	
		
	}
}
