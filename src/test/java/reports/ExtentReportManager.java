package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
	
	private static ExtentReports extent ;
	
	public static ExtentReports getReportInstance() {
		
		if(extent == null) {
			
			ExtentSparkReporter spark = new ExtentSparkReporter( System.getProperty("user.dir")
                    + "/reports/ExtentReport.html");
			
			extent =new ExtentReports();
			extent.attachReporter(spark);
			extent.setSystemInfo("Project", "Tutorial Ninja");
			extent.setSystemInfo("Tester", "Omkar");
            extent.setSystemInfo("Browser", "Chrome");
		}
		
		return extent;
		
	}
	
}