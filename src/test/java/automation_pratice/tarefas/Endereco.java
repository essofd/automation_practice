package automation_pratice.tarefas;

import org.openqa.selenium.WebDriver;

import automation_pratice.objetos.EnderecoObjeto;

public class Endereco {

	private EnderecoObjeto endereco;

	public Endereco (WebDriver driver) {
			this.endereco = new EnderecoObjeto(driver);
		}

	public void continuar() {
		this.endereco.continuar().click();
	}
}
