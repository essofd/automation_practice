package automation_pratice.tarefas;

import org.openqa.selenium.WebDriver;

import automation_pratice.objetos.FreteObjeto;

public class Frete {
private FreteObjeto frete;
	
	public Frete (WebDriver driver){
		this.frete = new FreteObjeto(driver);
	}
	public void concordarTermos() {
		this.frete.termo().click();
	}
	public void continuar() {
		this.frete.continuar().click();
	}
}
