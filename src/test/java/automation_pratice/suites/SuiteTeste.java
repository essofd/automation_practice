package automation_pratice.suites;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import automation_pratice.utilitarios.ReportLog; 
import automation_pratice.testes.CompraProduto;


@RunWith(Suite.class)
@SuiteClasses({
	CompraProduto.class
})
public class SuiteTeste {
	@BeforeClass
	public static void inicializaTeste() {
		ReportLog.criarReport("Automation Practice Testing Site", "Regression Suite");
	}
	@AfterClass
	public static void finalizaTeste() {
		ReportLog.exit();
	}
}