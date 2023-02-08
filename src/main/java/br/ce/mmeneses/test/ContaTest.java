package br.ce.mmeneses.test;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.mmeneses.core.BaseTest;
import br.ce.mmeneses.core.Propriedades;
import br.ce.mmeneses.pages.ContasPage;
import br.ce.mmeneses.pages.MenuPage;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaTest extends BaseTest {

	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();

	@Test
	public void test1_InserirConta() {
		menuPage.acessarTelaInserirConta();

		contasPage.setNome("Conta de Teste1");
		contasPage.clicarBotaoPorTexto("Salvar");

		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());

	}

	@Test
	public void test_2AlterarConta() {
		menuPage.acessarTelaListarConta();

		contasPage.clicarAlterarConta("Conta de Teste1");
		contasPage.setNome(Propriedades.CONTA_ALTERADA);
		contasPage.clicarBotaoPorTexto("Salvar");

		Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
	}

	@Test
	public void test_3InserirContaMesmoNome() {
		menuPage.acessarTelaInserirConta();
		
		contasPage.setNome(Propriedades.CONTA_ALTERADA);
		contasPage.clicarBotaoPorTexto("Salvar");
		
		Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());

	}
	
}
