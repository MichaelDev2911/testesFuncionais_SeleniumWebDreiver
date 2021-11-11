package tests;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.MenuPage;
import pages.MovimentacaoPage;
import tests.utils.DataUtils; 
import static tests.utils.DataUtils.*;

public class MovimentacaoTest extends BaseTest {
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movpage = new MovimentacaoPage();

	@Test
	public void testInserirMovimentacao() {
		menuPage.acessarTelaInserirMovimentacao();
		movpage.setDataMovimentacao("01/09/2017");
		movpage.setDataPagamento("02/09/2017");
		movpage.setDescricao("Movimentação do teste");
		movpage.setInteressado("Interessado qualquer");
		movpage.setValor("500");
		movpage.setConta("Conta de teste alterada");
		movpage.setStatusPago();
		movpage.salvar();
		
		Assert.assertEquals("Movimentação adicionada com sucesso!",
				movpage.obterMensagemSucesso());
		
	}
	
	@Test 
	public void testCamposObrigatoriosMovimentacao() {

		menuPage.acessarTelaInserirMovimentacao();
		movpage.salvar();
		List<String> erros = movpage.obterErros();
		//Assert.assertEquals("Data da Movimentação é obrigatório",erros.get(0));
		//Assert.assertTrue(erros.contains("Data da Movimentação é obrigatório"));
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimentação é obrigatório",
				"Data do pagamento é obrigatório",
				"Descrição é obrigatório",
				"Interessado é obrigatório",
				"Valor é obrigatório",
				"Valor deve ser um número"
				)));
		Assert.assertEquals(6, erros.size());
		
	}
	
	@Test
	public void testInsertMovimentacaoFutura() {
		
		Date dataFutura = obterDataComDiferencaDias(1);
		
		menuPage.acessarTelaInserirMovimentacao();
		movpage.setDataMovimentacao(obterDataFormatada(dataFutura));
		movpage.setDataPagamento("02/09/2017");
		movpage.setDescricao("Movimentação do teste");
		movpage.setInteressado("Interessado qualquer");
		movpage.setValor("500");
		movpage.setConta("Conta de teste alterada");
		movpage.setStatusPago();
		movpage.salvar();

		List<String> erros = movpage.obterErros();
	
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimentação deve ser menor ou igual à data atual!"
				)));
		Assert.assertEquals(1, erros.size());
	
		
	}
}
