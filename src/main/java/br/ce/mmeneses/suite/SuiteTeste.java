package br.ce.mmeneses.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.mmeneses.test.ContaTest;
import br.ce.mmeneses.test.MovimentacaoTest;
import br.ce.mmeneses.test.RemoverMovimentacaoContaTest;
import br.ce.mmeneses.test.ResumoTest;
import br.ce.mmeneses.test.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverMovimentacaoContaTest.class,
	SaldoTest.class,
	ResumoTest.class
	
})
public class SuiteTeste {

}
