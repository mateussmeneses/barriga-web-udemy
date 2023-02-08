package br.ce.mmeneses.test;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.mmeneses.core.BaseTest;
import br.ce.mmeneses.core.DriverFactory;
import br.ce.mmeneses.pages.MenuPage;
import br.ce.mmeneses.pages.ResumoPage;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResumoTest extends BaseTest {
	private MenuPage menuPage = new MenuPage();
	private ResumoPage resumoPage = new ResumoPage();
	
	@Test
	public void test1_ExcluirMovimentacao() {
		menuPage.acessarTelaResumo();
		resumoPage.excluirMovimentacao();
		
		Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());
	}
	
	@Test
	public void test2_ResumoMensal() {
		menuPage.acessarTelaResumo();
		Assert.assertEquals("Seu Barriga - Extrato", DriverFactory.getDriver().getTitle());
	
		List<WebElement> elementosEncontrados = DriverFactory.getDriver()
					.findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
		Assert.assertEquals(0, elementosEncontrados.size());
	}

}
