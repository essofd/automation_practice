package automation_pratice.tarefas;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import automation_pratice.objetos.NovoUsuarioObjeto;

public class NovoUsuario {
private NovoUsuarioObjeto usuario;
	
	public NovoUsuario (WebDriver driver){
		this.usuario = new NovoUsuarioObjeto(driver);
	}
	public void newAccount(String email) {
		this.usuario.emailNovoUsuario().sendKeys(email);
		this.usuario.criarUmaConta().click();
	}
	public void informacoesPessoais(String nome, String sobreNome, String senha, String dia, String mes, String ano,
			String endereco, String cidade, String cep, String telefone) {
		this.usuario.titulo().click();
		this.usuario.primeiroNome().sendKeys(nome);
		this.usuario.sobreNome().sendKeys(sobreNome);
		this.usuario.senha().sendKeys(senha);
		this.usuario.dia().sendKeys(Keys.ARROW_DOWN);
		this.usuario.dia().sendKeys(dia);
		this.usuario.dia().sendKeys(Keys.ENTER);
		this.usuario.mes().sendKeys(Keys.ARROW_DOWN);
		this.usuario.mes().sendKeys(mes);
		this.usuario.mes().sendKeys(Keys.ENTER);
		this.usuario.ano().sendKeys(Keys.ARROW_DOWN);
		this.usuario.ano().sendKeys(ano);
		this.usuario.ano().sendKeys(Keys.ENTER);
		this.usuario.endereco().sendKeys(endereco);
		this.usuario.cidade().sendKeys(cidade);
		this.usuario.estado().sendKeys(Keys.ARROW_DOWN);
		this.usuario.estado().sendKeys(Keys.ENTER);
		this.usuario.cep().sendKeys(cep);
		this.usuario.pais().sendKeys(Keys.ARROW_DOWN);
		this.usuario.pais().sendKeys(Keys.ENTER);
		this.usuario.telefone().sendKeys(telefone);
	}
	public void registraConta() {
		this.usuario.registraConta().click();
	}
}
