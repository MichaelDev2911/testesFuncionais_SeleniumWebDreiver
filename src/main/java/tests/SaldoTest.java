package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.HomePage;

public class SaldoTest extends BaseTest {

	HomePage page = new HomePage();
	@Test
	public void testSaldoConta() {
		Assert.assertEquals("123.00", page.obterSaldoConta("Conta 1"));
	}
}
