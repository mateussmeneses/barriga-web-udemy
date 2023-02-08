package br.ce.mmeneses.core;

public class Propriedades {
	public static boolean FECHAR_BROWSER = false;

	public static Browsers  browser = Browsers.CHROME;
	
	public static String CONTA_ALTERADA = "Conta Alterada"  + System.nanoTime();
	
	public enum Browsers {
		CHROME,
		FIREFOX
	}
	
}
