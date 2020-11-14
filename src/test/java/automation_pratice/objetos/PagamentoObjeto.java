package automation_pratice.objetos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PagamentoObjeto {
private WebDriver driver;
	
	public  PagamentoObjeto(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement transferenciaBancaria() {
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.className("payment_module")));
		return element;
	}
	public WebElement confirmar() {
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("*//button/span[contains(text(),'I confirm my order')]")));
		return element;
	}

}
