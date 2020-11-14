package automation_pratice.objetos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdicionaProdutoCarrinhoObjeto {
	private WebDriver driver;

	public AdicionaProdutoCarrinhoObjeto(WebDriver driver) {
		this.driver = driver;
	}	
	

	public WebElement adicionaCarrinho() {
		this.driver.findElement(By.xpath("//*[@id='homefeatured']/li[1]")).click();
		return driver.findElement(By.xpath("*//a/span[contains(text(), 'Add to cart')]"));
	}
	public WebElement total() {
		return this.driver.findElement(By.id("total_price"));
	}
	public WebElement continuarComCheckout() {
		
		return this.driver.findElement(By.xpath("*//a/span[contains(text(),'Proceed to checkout')]"));
	}
	public WebElement verificaNomeProduto() {
		return this.driver.findElement(By.xpath("*//span[contains(text(),'Faded Short Sleeve T-shirts')]"));
	}
	public WebElement continuarCheckout() {
		return this.driver.findElement(By.xpath("*//p/a[@title='Proceed to checkout']"));
	}

}
