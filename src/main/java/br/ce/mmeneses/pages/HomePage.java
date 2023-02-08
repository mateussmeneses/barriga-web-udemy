package br.ce.mmeneses.pages;

import org.openqa.selenium.By;

import br.ce.mmeneses.core.BasePage;

public class HomePage extends BasePage {

//	public String obterSaldoConta(String nome) {
//		return obterCelula("Conta", nome, "Saldo", "tabelaSaldo").getText();
//	}
	public String  obterSaldoConta(String nome) {
		return obterTexto(By.xpath("//*[@id=\"tabelaSaldo\"]/tbody/tr/td[2]"));
	}
}
