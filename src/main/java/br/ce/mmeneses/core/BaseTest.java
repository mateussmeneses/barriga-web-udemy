package br.ce.mmeneses.core;

import static br.ce.mmeneses.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.ce.mmeneses.pages.LoginPage;

public class BaseTest {
	
	
	@Rule
	public TestName testName = new TestName();
	
	private static LoginPage page = new LoginPage();
	@Before
	public static void inicializa() {
		page.acessarTelaInicial();
		page.setEmail("conta@nova.com");
		page.setSenha("123456");
		page.entrar();
	}
	
	
	@After
	public void finaliza() throws IOException {
		TakesScreenshot ss = (TakesScreenshot) DriverFactory.getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("target" +File.separator+ "screenshots" + 
			File.separator +	testName.getMethodName() + ".jpg"));
		if (Propriedades.FECHAR_BROWSER) {
			killDriver();
		}
	}
}
