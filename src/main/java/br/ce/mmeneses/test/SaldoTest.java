package br.ce.mmeneses.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.mmeneses.core.BaseTest;
import br.ce.mmeneses.core.Propriedades;
import br.ce.mmeneses.pages.HomePage;
import br.ce.mmeneses.pages.MenuPage;

public class SaldoTest extends BaseTest {
	HomePage homePage = new HomePage();
	MenuPage menuPage = new MenuPage();
	
	@Test
	public void testSaldoConta() {
		menuPage.acessarTelaPrincipal();
		Assert.assertEquals("500.00", homePage.obterSaldoConta(Propriedades.CONTA_ALTERADA));
	}

}
