package automation_pratice.tarefas;

import org.openqa.selenium.WebDriver;

import automation_pratice.objetos.PagamentoObjeto;

public class Pagamento {
private PagamentoObjeto pagamento;
	
	public Pagamento(WebDriver driver){
		this.pagamento = new PagamentoObjeto(driver);
	}
	public void transferenciaBancaria() {
		this.pagamento.transferenciaBancaria().click();
	}
	public void confirmar() {
		this.pagamento.confirmar().click();
	}
}
