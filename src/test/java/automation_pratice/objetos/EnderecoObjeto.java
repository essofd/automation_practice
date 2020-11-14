package automation_pratice.objetos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EnderecoObjeto {
private WebDriver driver;
	
	public EnderecoObjeto (WebDriver driver) {
		this.driver = driver;
	}
	public WebElement continuar() {
		return this.driver.findElement(By.xpath("*//p/button/span[contains(text(),'Proceed to checkout')]"));
	}
}
