package utils;

import com.aventstack.extentreports.ExtentReports;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getExtentReports() {
        if (extent == null) {
            String reportFilePath = System.getProperty("user.dir") + "/target/extent-reports.html";
            com.aventstack.extentreports.reporter.ExtentSparkReporter reporter = new com.aventstack.extentreports.reporter.ExtentSparkReporter(reportFilePath);

            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }
        return extent;
    }

    public static void flush() {
        if (extent != null) {
            extent.flush();
        }
    }
}
