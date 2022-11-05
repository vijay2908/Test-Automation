package report_management;

import java.time.LocalDate;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportInit {

	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir") + "//reports//index.html";
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		LocalDate date = LocalDate.now();

		report.config().setDocumentTitle("Results");

		report.config().setReportName("Automation Test results");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Tester", "Vijaya Sankar");
		return extent;

	}
}
