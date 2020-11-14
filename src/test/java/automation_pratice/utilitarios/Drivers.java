package automation_pratice.utilitarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Drivers {
	
	public static String path_Chrome_Driver = "drivers/chromedriver.exe";
	
	public static WebDriver getChromeDriver() {
		//Chrome driver versão 86
		System.setProperty("webdriver.chrome.driver", path_Chrome_Driver);
		return new ChromeDriver();
	}

}
