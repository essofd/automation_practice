package automation_pratice.tarefas;

import org.openqa.selenium.WebDriver;

import automation_pratice.objetos.AdicionaProdutoCarrinhoObjeto;

public class AdicionaProdutoCarrinho {
	
private  AdicionaProdutoCarrinhoObjeto produto;
	
	public AdicionaProdutoCarrinho(WebDriver driver){
		this.produto = new AdicionaProdutoCarrinhoObjeto(driver);
	}
	
	public void adicionaProdutoCarrinho() {
		produto.adicionaCarrinho().click();
		
	}
	
	public String nomeProduto() {
		return produto.verificaNomeProduto().getText();
	}
	
	public String total() {
		return produto.total().getText();
	}
	public void checkout() {
		produto.continuarComCheckout().click();
	}
	public void continuarCheckout() {
		produto.continuarCheckout().click();
	}
	

}
