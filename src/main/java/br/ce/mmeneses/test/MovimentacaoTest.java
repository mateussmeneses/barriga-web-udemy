package br.ce.mmeneses.test;

import static br.ce.mmeneses.utils.DataUtils.obterDataFormatada;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.mmeneses.core.BaseTest;
import br.ce.mmeneses.core.Propriedades;
import br.ce.mmeneses.pages.MenuPage;
import br.ce.mmeneses.pages.MovimentacaoPage;
import br.ce.mmeneses.utils.DataUtils;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTest extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage();

	@Test
	public void test1_InserirMovimentacao() {
		menuPage.acessarTelaInserirMovimentacao();

		movPage.setDataMovimentacao(obterDataFormatada(new Date()));
		movPage.setDataPagamento(obterDataFormatada(new Date()));
		movPage.setDescricao("Movimentação do teste");
		movPage.setInteressado("Interessado qualquer");
		movPage.setValor("500");
		movPage.setConta(Propriedades.CONTA_ALTERADA);
		movPage.setStatusPago();
		movPage.salvar();

		Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.obterMensagemSucesso());
	}

	@Test
	public void test2_CamposObrigatorios() {
		menuPage.acessarTelaInserirMovimentacao();

		movPage.salvar();
		List<String> erros = movPage.obterErros();
//		Assert.assertEquals("Data da Movimentação é obrigatório", erros.get(0));
//		Assert.assertTrue(erros.contains("Data da Movimentação é obrigatório"));
		Assert.assertTrue(erros.containsAll(Arrays.asList("Data da Movimentação é obrigatório",
				"Data do pagamento é obrigatório", "Descrição é obrigatório", "Interessado é obrigatório",
				"Valor é obrigatório", "Valor deve ser um número")));
		Assert.assertEquals(6, erros.size());
	}

	@Test
	public void test3_InserirMovimentacaoFutura() {
		menuPage.acessarTelaInserirMovimentacao();

		Date dataFutura = DataUtils.obterDataComDiferencaDias(5);

		movPage.setDataMovimentacao(obterDataFormatada(dataFutura));
		movPage.setDataPagamento(obterDataFormatada(dataFutura));
		movPage.setDescricao("Movimentação do teste");
		movPage.setInteressado("Interessado qualquer");
		movPage.setValor("500");
		movPage.setConta(Propriedades.CONTA_ALTERADA);
		movPage.setStatusPago();
		movPage.salvar();

		List<String> erros = movPage.obterErros();
		Assert.assertTrue(
				erros.containsAll(Arrays.asList("Data da Movimentação deve ser menor ou igual à data atual")));
		Assert.assertEquals(1, erros.size());
	}

	
	
}
