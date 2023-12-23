package ExtentReport;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShot_ExtentReport {
	ChromeDriver driver;
	@Test
	public void report()
	
	{
		WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.get("https://demowebshop.tricentis.com/");
	 String screen_shot = driver.getScreenshotAs(OutputType.BASE64);
		
		ExtentSparkReporter esp = new ExtentSparkReporter("ExtentReport//TakeScreenshot.html");
		ExtentReports er=new ExtentReports();
		er.attachReporter(esp);
		ExtentTest test = er.createTest("ScreenShot_ExtentReport");
		test.log(Status.INFO, "Test case attached with extent report");
		
		
		test.addScreenCaptureFromBase64String(screen_shot);
		er.flush();

	}



}
