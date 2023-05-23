package extentReortsPractice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportsExample {

	WebDriver driver;
	ExtentReports extent;
	ExtentSparkReporter spartReporter;
	ExtentTest testCase;
	
	/*https://www.extentreports.com/docs/versions/5/java/index.html
	 * 
	 * Found the answer in
	 * https://sqa.stackexchange.com/questions/46834/unable-to-import-
	 * extenthtmlreporter-for-the-java-class
	 * 
	 * ExtentHtmlReporter, ExtentLoggerReporter The ExtentHtmlReporter and
	 * ExtentLoggerReporter were deprecated in series 4.1.x and have been removed in
	 * version 5. The replacement is ExtentSparkReporter, which is comprehensive,
	 * ports all features along with a host of new ones.
	 * 
	 * ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");
	 * 
	 * Or downgrade to 4.0.9
	 */
	
	/*
	 * Essence jar file for do this 
	 * 1.extentreports-5.0.9.jar
	 * 2.Apache FreeMarker » 2.3.32
	 * 3.RxJava » 3.1.6 Reactive Extensions for Java (java.lang.NoClassDefFoundError: io/reactivex/rxjava3/core/Observer)
	 * 4.org.mongodb » bson » 4.9.1(without this it will run)
	 */

	@BeforeSuite
	public void launchBrowser()
	{	
		spartReporter=new ExtentSparkReporter("ExtentReport.Html"); //java.lang.NoClassDefFoundError: io/reactivex/rxjava3/core/Observer
		extent=new ExtentReports();
		extent.attachReporter(spartReporter);
		System.setProperty("webdriver.chrome.driver", "D:\\selenium practice\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}
	@Test
	public void openGoogle()
	{	
		testCase=extent.createTest("verify google title");
		testCase.log(Status.INFO, "navigating to google");
		driver.get("http://www.google.com");
		String googlePageTitle=	driver.getTitle();
		System.out.println(googlePageTitle);
		if(googlePageTitle.equals("Google")) 
		{
			//System.out.println("passed");
			testCase.log(Status.PASS, "Actual title and expected title are equal");
		}
		else 
		{
			//System.out.println("failed");
			testCase.log(Status.FAIL, "Actual title and expected title are not equal");
		}
	}
	@Test
	public void openBing()
	{
		testCase=extent.createTest("verify bing title");
		testCase.log(Status.INFO, "navigate to bing");
		driver.get("http://www.bing.com");
		String bingPageTitle=	driver.getTitle();

		System.out.println(bingPageTitle);
		if(bingPageTitle.equals("Bing")) 
		{
			//System.out.println("passed");
			testCase.log(Status.PASS, "Actual title and expected title are equal");
		}
		else {
			//System.out.println("failed");
			testCase.log(Status.FAIL, "Actual title and expected title are not equal");
		}
	}
	@Test
	public void openWikipedia()
	
	{
		testCase=extent.createTest("verify wikipedia title");
		testCase.log(Status.INFO, "navigate to wikipedia");
		driver.get("https://www.wikipedia.org/");
		String wikipediaPageTitle=	driver.getTitle();
		System.out.println(wikipediaPageTitle);
		if(wikipediaPageTitle.equals("wikipedia")) 
		{
			//System.out.println("passed");
			testCase.log(Status.PASS, "Actual title and expected title are equal");
		}
		else {
			//System.out.println("failed");
			//TakeScreenShot screenshot= driver;
			testCase.log(Status.FAIL, "Actual title and expected title are not equal");
		}
	}
	@AfterSuite
	public void closeBrowser() {
		driver.quit();
		extent.flush();
	}

}
