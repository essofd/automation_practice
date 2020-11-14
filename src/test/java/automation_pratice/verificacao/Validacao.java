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
			log(Status.PASS, "Validação: Produto correto.", Screenshot.capturaImagem(driver));
		} else {
			logErro("Produto incorreto.");   
			log(Status.FAIL, "Validação: Produto incorreto.", Screenshot.capturaImagem(driver));
		}
	}
	public void validaCompra() {
		if(this.contemPagina(CHECK_ORDER)) {
			logSucesso("Compra realizada com sucesso.");
			log(Status.PASS, "Validação: Compra realizada com sucesso.", Screenshot.capturaImagem(driver));
		} else {
			logErro("Falha ao comprar.");   
			log(Status.FAIL, "Validação: Falha ao comprar.", Screenshot.capturaImagem(driver));
		}
	}
	public void validaTotal(String total) {
		if(total.equals(this.retornaTotal())) {
			logSucesso("Valor total da compra correto.");
			log(Status.PASS, "Validação: Valor total da compra correto.", Screenshot.capturaImagem(driver));
		} else {
			logErro("Valor total da compra incorreto.");  
			log(Status.FAIL, "Validação: Valor total da compra incorreto.", Screenshot.capturaImagem(driver));
		}	}
	public void validaEndereco(String endereco, String cidade) {
		if(this.contemPagina(endereco) && this.contemPagina(cidade)) {
			logSucesso("O endereço está correto.");
			log(Status.PASS, "Validação: O endereço está correto.", Screenshot.capturaImagem(driver));
		} else {
			logErro(" O endereço está incorreto.");  
			log(Status.FAIL, "Validação: O endereço está incorreto.", Screenshot.capturaImagem(driver));
		}
	}

}
