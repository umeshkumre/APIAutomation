package tests;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;

public class ExtentReporter {

	public static void main(String[] args) {

		ExtentReports extentReport=new ExtentReports();
		
		File extentReportFile=new File(System.getProperty("user.dir")+"\\test-output\\");
		
	}

}
