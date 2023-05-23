package com.excel.LoginThroughSheet;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TestLoginThroughSheet {

	String[][] data=null;
	WebDriver driver;

	@DataProvider(name="LoginData")
	public String[][] loginData() throws BiffException, IOException {
		data=getExcelData();
		return data;
	}

	public String[][] getExcelData() throws BiffException, IOException {
		//1. file location

		/*try {
			FileInputStream data=new FileInputStream("D:\\TestData\\Book1");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} 
		 */
		//Attach a file to a FileInputStream as this will enable us to read data from the file
		FileInputStream data=new FileInputStream("D:\\TestData\\Book1.xls");
		Workbook workbook= Workbook.getWorkbook(data);
		Sheet sheet1=	workbook.getSheet(0);
		int rows= sheet1.getRows();
		int columns=sheet1.getColumns();

		String testData[][]=new String[rows-1][columns];

		for(int i=1;i<rows;i++)
		{
			for(int j=0;j<columns;j++)
			{
				testData[i-1][j]=sheet1.getCell(j, i).getContents();
			}
		}

		return testData;
	}
	@BeforeTest
	public void beforTest() {
		System.setProperty("driver.chrome.driver", "D:\\selenium practice\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();  //browsercompatablity
		option.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	@Test(dataProvider = "LoginData")
	public void logIn(String uName, String pWord)
	{

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebElement userName= driver.findElement(By.cssSelector("input[name='username']")); ////input[@placeholder='Password']
		userName.sendKeys(uName);
		WebElement passWord= driver.findElement(By.cssSelector("input[name='password']"));
		passWord.sendKeys(pWord);  
		WebElement loginButton= driver.findElement(By.tagName("button"));
		loginButton.click();
		/*
		 * WebElement dropDown1=
		 * driver.findElement(By.className("oxd-userdropdown-tab")); dropDown1.click();
		 */
	}
	@Test(dependsOnMethods = "logIn")
	public void logOut() {
		WebElement dropDown1= driver.findElement(By.className("oxd-userdropdown-tab")); 
		dropDown1.click();
		WebElement logOutLink= driver.findElement(By.linkText("Logout"));
		logOutLink.click();
	}

}
