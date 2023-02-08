package br.ce.mmeneses.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.mmeneses.core.BaseTest;
import br.ce.mmeneses.core.Propriedades;
import br.ce.mmeneses.pages.ContasPage;
import br.ce.mmeneses.pages.MenuPage;

public class RemoverMovimentacaoContaTest extends BaseTest{

	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void testExcluirContaComMovimentacao() {
		menuPage.acessarTelaListarConta();

		contasPage.clicarExcluirConta(Propriedades.CONTA_ALTERADA);
		Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());

	}
}
