package automation_pratice.objetos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NovoUsuarioObjeto {
private WebDriver driver;
	
	public NovoUsuarioObjeto(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement emailNovoUsuario() {
		return this.driver.findElement(By.id("email_create"));
	}
	public WebElement criarUmaConta() {
		return this.driver.findElement(By.id("SubmitCreate"));
	}
	public WebElement titulo() {
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name("id_gender")));
		return element;
	}
	public WebElement primeiroNome() {
		return this.driver.findElement(By.id("customer_firstname"));
	}
	public WebElement sobreNome() {
		return this.driver.findElement(By.id("customer_lastname"));
	}
	public WebElement senha() {
		return this.driver.findElement(By.id("passwd"));
	}
	public WebElement dia() {
		return this.driver.findElement(By.id("days"));
	}
	public WebElement mes() {
		return this.driver.findElement(By.id("months"));
	}
	public WebElement ano() {
		return this.driver.findElement(By.id("years"));
	}
	public WebElement endereco() {
		return this.driver.findElement(By.id("address1"));
	}
	public WebElement cidade() {
		return this.driver.findElement(By.id("city"));
	}
	public WebElement estado() {
		return this.driver.findElement(By.id("id_state"));
	}
	public WebElement cep() {
		return this.driver.findElement(By.id("postcode"));
	}
	public WebElement pais() {
		return this.driver.findElement(By.id("id_country"));
	}
	public WebElement telefone() {
		return this.driver.findElement(By.id("phone_mobile"));
	}
	public WebElement registraConta() {
		return this.driver.findElement(By.id("submitAccount"));
	}
}
