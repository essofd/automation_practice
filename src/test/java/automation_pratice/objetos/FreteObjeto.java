package automation_pratice.objetos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FreteObjeto {
private WebDriver driver;
	
	public FreteObjeto(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement termo() {
		return this.driver.findElement(By.id("cgv"));
	}
	public WebElement continuar() {
		return this.driver.findElement(By.xpath("*//button/span[contains(text(),'Proceed to checkout')]"));
	}
}
