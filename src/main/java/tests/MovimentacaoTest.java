package tests;

import org.junit.Test;

import core.BaseTest;
import pages.MenuPage;

public class MovimentacaoTest extends BaseTest {
	private MenuPage menuPage = new MenuPage();

	@Test
	public void testInserirMovimentacao() {
		menuPage.acessarTelaInserirMovimentacao();
	}
}
