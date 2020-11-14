package automation_pratice.testes;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import automation_pratice.tarefas.AdicionaProdutoCarrinho;
import automation_pratice.tarefas.Endereco;
import automation_pratice.tarefas.Frete;
import automation_pratice.tarefas.NovoUsuario;
import automation_pratice.tarefas.Pagamento;
import automation_pratice.utilitarios.Drivers;
import automation_pratice.utilitarios.ReportLog;
import automation_pratice.utilitarios.Screenshot;
import automation_pratice.verificacao.Validacao;

public class CompraProduto {
	private WebDriver driver;
	private AdicionaProdutoCarrinho adicionar;
	private Endereco ender;
	private NovoUsuario usuario;
	private Pagamento pagamento;
	private Frete frete;
	private Validacao verificacao;

	@Before
	public void setUp() {
		ReportLog.inicializacao("Caso de Teste: Realizar uma compra com sucesso.");
		driver = Drivers.getChromeDriver();
		adicionar = new AdicionaProdutoCarrinho(driver);
		ender = new Endereco(driver);
		usuario = new NovoUsuario(driver);
		pagamento = new Pagamento(driver);
		frete = new Frete(driver);
		verificacao = new Validacao(driver);
	}

	@Test
	public void deveRealizarUmaCompraComSucesso() {
		// Entra na aplicacao
		driver.get("http://automationpractice.com/index.php?");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		ReportLog.log(Status.INFO, "O website foi carregado.", Screenshot.capturaImagem(driver));

		// adiciona produto
		adicionar.adicionaProdutoCarrinho();
		String nome = adicionar.nomeProduto();

		// clica em continuar checkout
		adicionar.checkout();

		// valida se a pagina contem o produto
		verificacao.validaProduto(nome);

		String total = adicionar.total();
		
		//retorna total sem o $
		total=total.substring(1);
		
		//adiciona a taxa ao total
		double tot =Double.parseDouble(total);
		tot=tot+0.74; //taxa de 0.74
		total =Double.toString(tot);
		
		//retorna $ para total
		total="$"+total;
		
		//clica em continuar (Proceed to Checkout)
		adicionar.continuarCheckout();

		// Adiciona dados do usuario e envia os dados
		usuario.newAccount("XPTOmeuEmail12345@gmail.com");
		String pNome="Edson";
		String sobreNome="Costa";
		String senha="password";
		String dia="12";
		String mes= "August";
		String ano="1974";
		String endereco = "Rua camapuã, 60";
		String cidade = "Nova Iguacu";
		String cep="01234";
		String tel="21983826716";
		
		usuario.informacoesPessoais(pNome, sobreNome, senha, dia, mes, ano, endereco, cidade, cep, tel);
		usuario.registraConta();

		// valida se o endereço esta correto
		verificacao.validaEndereco(endereco, cidade);

		// clica em continuar (Proceed to Checkout)
		ender.continuar();

		// clica em concordar com os termos do frete
		frete.concordarTermos();

		// clica em continuar (Proceed to Checkout)
		frete.continuar();

		// verifica se o valor total esta correto
		verificacao.validaTotal(total);

		// clica em paybank para opção de transferencia bancaria
		pagamento.transferenciaBancaria();

		// clica em confirmar (I confirm my order)
		pagamento.confirmar();

		// valida se a compra foi realizada com sucesso ("Your order on My Store is complete.")
		verificacao.validaCompra();
	}

	@After
	public void tearDown() {
		// fecha a aplicacao
		driver.quit();
	}
}
