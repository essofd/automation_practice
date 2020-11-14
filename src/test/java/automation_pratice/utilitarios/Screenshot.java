package automation_pratice.utilitarios;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

public class Screenshot {
	
	public static String capturaImagem(WebDriver driver) {
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = "./reports/screenshots/" + source.getName();
	    return salvaImagemArquivo(source, path);
	}
	
	private static String salvaImagemArquivo(File source, String path) {
		try {
	        FileUtils.copyFile(source, new File(path)); 
	    } catch(IOException ex) {
	    	ReportLog.log(Status.WARNING, "Capture error: " + ex.getMessage());
	    }
	    return path.replace("./reports/", "");
	}

}
