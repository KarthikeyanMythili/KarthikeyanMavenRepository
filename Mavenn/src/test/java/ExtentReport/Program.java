package ExtentReport;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Program {
	@Test
	public void report()
	{
		ExtentSparkReporter esp = new ExtentSparkReporter("ExtentReport//AttachedFile.html");
		ExtentReports er=new ExtentReports();
		er.attachReporter(esp);
		ExtentTest test = er.createTest("Program");
		test.log(Status.INFO, "Test case attached with extent report");
		er.flush();
	}

}
