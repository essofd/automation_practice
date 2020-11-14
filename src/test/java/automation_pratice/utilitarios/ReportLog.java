package automation_pratice.utilitarios;

import java.io.IOException;
import java.time.LocalDateTime;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.apache.log4j.Logger;

public class ReportLog {
	
	private static final String DEFAULT_DESCRIPTION = "TEST SUITE";
	private static final String DEFAULT_PATH = "./reports/report_%s.html";
	private static ExtentReports extentReport;
	public static ExtentTest logger;
	
	public static void criarReport(String title, String description) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(String.format(DEFAULT_PATH, LocalDateTime.now().getNano()));
		
		htmlReporter.config().setProtocol(Protocol.HTTPS);
		htmlReporter.config().setEncoding("UTF-8");
		htmlReporter.config().setTheme(Theme.STANDARD);

		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReporter);
		
		
	}

	public static void inicializacao(String testDescription) {
		if(extentReport == null) {
			criarReport(DEFAULT_DESCRIPTION, testDescription);
		}
		
		logger = extentReport.createTest(testDescription);
	}
	
	public void logSucesso(String message) {
		// Log4j
		Logger log = Logger.getLogger(getClass());
		log.info(message);

	}
	
	public void logErro(String message) {
		// Log4j
		Logger log = Logger.getLogger(getClass());
		log.error(message);
	}	
		

	public static void log(Status logStatus, String message, String imagePath) {		
		try {
			if(logger == null) {
				inicializacao(DEFAULT_DESCRIPTION);
			}
			
			logger.log(logStatus, message, MediaEntityBuilder.createScreenCaptureFromPath(imagePath).build());
		} catch (IOException ex) {
			logger.log(logStatus, message + " (Screenshot fail)");
		}
	}

	public static void log(Status logStatus, String message) {		
		if(logger == null) {
			inicializacao(DEFAULT_DESCRIPTION);
		}
		
		logger.log(logStatus, message);
	}
	
	public static void exit() {
		if(extentReport != null) {
			extentReport.flush();
		} else {
			inicializacao("O Caso de Teste passou!");
			log(Status.INFO, "O teste encerrou.");
			exit();
		}
	}

}
