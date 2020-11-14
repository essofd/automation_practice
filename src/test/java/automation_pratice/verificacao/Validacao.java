package automation_pratice.verificacao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import automation_pratice.utilitarios.ReportLog;
import automation_pratice.utilitarios.Screenshot;

public class Validacao extends ReportLog{
	private String CHECK_ORDER = "Your order on My Store is complete.";
	private WebDriver driver;
	
	public Validacao (WebDriver driver) {
		this.driver = driver;
	}
	private boolean contemPagina(String text){
		return this.driver.getPageSource().contains(text);
	}
	private String retornaTotal(){
		return this.driver.findElement(By.id("total_price_container")).getText();			
	}
	

	public void validaProduto(String nome) {
		if(this.contemPagina(nome)) {
			
			logSucesso("Produto correto.");
			log(Status.PASS, "Valida��o: Produto correto.", Screenshot.capturaImagem(driver));
		} else {
			logErro("Produto incorreto.");   
			log(Status.FAIL, "Valida��o: Produto incorreto.", Screenshot.capturaImagem(driver));
		}
	}
	public void validaCompra() {
		if(this.contemPagina(CHECK_ORDER)) {
			logSucesso("Compra realizada com sucesso.");
			log(Status.PASS, "Valida��o: Compra realizada com sucesso.", Screenshot.capturaImagem(driver));
		} else {
			logErro("Falha ao comprar.");   
			log(Status.FAIL, "Valida��o: Falha ao comprar.", Screenshot.capturaImagem(driver));
		}
	}
	public void validaTotal(String total) {
		if(total.equals(this.retornaTotal())) {
			logSucesso("Valor total da compra correto.");
			log(Status.PASS, "Valida��o: Valor total da compra correto.", Screenshot.capturaImagem(driver));
		} else {
			logErro("Valor total da compra incorreto.");  
			log(Status.FAIL, "Valida��o: Valor total da compra incorreto.", Screenshot.capturaImagem(driver));
		}	}
	public void validaEndereco(String endereco, String cidade) {
		if(this.contemPagina(endereco) && this.contemPagina(cidade)) {
			logSucesso("O endere�o est� correto.");
			log(Status.PASS, "Valida��o: O endere�o est� correto.", Screenshot.capturaImagem(driver));
		} else {
			logErro(" O endere�o est� incorreto.");  
			log(Status.FAIL, "Valida��o: O endere�o est� incorreto.", Screenshot.capturaImagem(driver));
		}
	}

}
